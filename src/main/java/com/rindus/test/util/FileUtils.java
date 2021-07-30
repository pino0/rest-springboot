package com.rindus.test.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {

    private FileUtils(){
    }

    public static boolean saveFile(String data, String fileName){
        boolean band = false;
        try {
            File file = new File(fileName);
            FileWriter out;
            if (file.createNewFile()) {
                System.err.println("File created: " + file.getName());
            } else {
                file.delete();
            }

            out = new FileWriter(file,false);
            out.write(data);
            out.close();
            band=true;

        } catch (IOException e) {
            System.err.println("An error occurred saving file.");
            e.printStackTrace();
        }

        return band;
    }
}
