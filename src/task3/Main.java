package task3;

import task2.GameProgress;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Main {
    public static void main(String[] args) {
        String savePath = "c:/games/savegames/";
        String zipFile = "zip.zip";
        String saveFile = "savedata2.dat";

        openZip(savePath, zipFile, saveFile);
        openProgress(savePath);

    }

    static void openZip(String path, String zipName, String saveName) {
        try (ZipInputStream zin = new ZipInputStream(new
                FileInputStream(path + zipName))) {
            ZipEntry entry;
            String name;
            while ((entry = zin.getNextEntry()) != null) {
                name = entry.getName();
                if (name.equals(saveName)) {
                    FileOutputStream fout = new FileOutputStream(path + "save.dat");
                    for (int c = zin.read(); c != -1; c = zin.read()) {
                        fout.write(c);
                    }
                    fout.flush();
                    zin.closeEntry();
                    fout.close();
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    static void openProgress(String savePath) {
        GameProgress gameProgress = null;

        try (FileInputStream fis = new FileInputStream(savePath + "save.dat");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            gameProgress = (GameProgress) ois.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(gameProgress);
    }
}
