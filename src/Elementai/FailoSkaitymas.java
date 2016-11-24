package Elementai;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Created by Paulius on 11/10/2016.
 */
public class FailoSkaitymas {

    ArrayList<Integer> arrayList;

    public ArrayList<Integer> gautiDuomenis() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("duomenys.txt"));
            StringBuilder sb = new StringBuilder();
            int line = br.read();

            while (line != 0) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.read();
                arrayList.add(line);
            }
            String everything = sb.toString();

        return arrayList;
    }
}
