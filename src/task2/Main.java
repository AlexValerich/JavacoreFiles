package task2;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> saveFile = new ArrayList<>();
        String savePath = "c:/games/savegames/";

        GameProgress player1 = new GameProgress(100, 10, 15, 1.2);
        GameProgress player2 = new GameProgress(50, 5, 10, 0.8);
        GameProgress player3 = new GameProgress(1, 2, 20, 2);

        saveGame(player1, savePath + "savedata1.dat");
        saveGame(player2, savePath + "savedata2.dat");
        saveGame(player3, savePath + "savedata3.dat");

            File dir = new File(savePath);
                    for (File item : Objects.requireNonNull(dir.listFiles())) {
                        if (item.getName().contains(".dat")) {
                            saveFile.add(item.getName());
                        }
                    }

        zipFiles(savePath, saveFile);

        for (String file:saveFile) {
            File deleteFile = new File(savePath, file);
            boolean del = deleteFile.delete();

        }
    }

    static void saveGame(GameProgress game, String path) {

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));
            out.writeObject(game);
            out.flush();
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    static void zipFiles(String zipPath, ArrayList<String> saveList) {

        try {
            ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(zipPath + "zip.zip"));
            for (String file : saveList) {

                FileInputStream fis = new FileInputStream(zipPath + file);
                ZipEntry entry = new ZipEntry(file);
                zout.putNextEntry(entry);
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                zout.write(buffer);
                zout.closeEntry();
                zout.flush();
                fis.close();
            }
            zout.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
