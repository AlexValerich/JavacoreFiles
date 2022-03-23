package task1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        File dir1 = new File("C://Games/src");
        if (dir1.mkdir())
            logger(dir1);
        File dir2 = new File("C://Games/res");
        if (dir2.mkdir())
            logger(dir2);
        File dir3 = new File("C://Games/savegames");
        if (dir3.mkdir())
            logger(dir3);
        File dir4 = new File("C://Games/temp");
        if (dir4.mkdir())
            logger(dir4);
        File dir5 = new File("C://Games/res/drawables");
        if (dir5.mkdir())
            logger(dir5);
        File dir6 = new File("C://Games/res/vectors");
        if (dir6.mkdir())
            logger(dir6);
        File dir7 = new File("C://Games/res/icons");
        if (dir7.mkdir())
            logger(dir7);
        File dir8 = new File("C://Games/src/main");
        if (dir8.mkdir())
            logger(dir8);
        File dir9 = new File("C://Games/src/test");
        if (dir9.mkdir())
            logger(dir9);
        File fileMain = new File("C://Games/src/main//Main.java");
        try {
            if (fileMain.createNewFile())
                logger(fileMain);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            FileWriter logWrite = new FileWriter("C://Games/temp//temp.txt");
            logWrite.write(log.toString());
            logWrite.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    static StringBuilder log = new StringBuilder();
    static void logger(File dir){
        if(dir.isDirectory()) {
            log.append("Каталог " + dir.getAbsolutePath().toUpperCase() + " создан \n");
        }else  log.append("Файл " + dir.getAbsolutePath().toUpperCase() + " создан \n");
    }

}
