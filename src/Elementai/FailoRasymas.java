package Elementai;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Paulius on 11/8/2016.
 */

public class FailoRasymas {

    private File file;
    private FileWriter fileWritter;
    private BufferedWriter bufferWritter;

    public FailoRasymas(String text) {
        try {
            file = new File("duomenys.txt");

            if(!file.exists()) {
                file.createNewFile();
            }
            fileWritter = new FileWriter(file.getName(),true);
            bufferWritter = new BufferedWriter(fileWritter);
            bufferWritter.write(text);
            bufferWritter.newLine();
            bufferWritter.close();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
