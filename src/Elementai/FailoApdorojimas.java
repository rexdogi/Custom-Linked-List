package Elementai;

import sun.nio.cs.ext.IBM037;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.*;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by Paulius on 11/10/2016.
 */
public class FailoApdorojimas {

    public List<Asmuo> nuskaityti(String failas) throws IOException {
        List<Asmuo> list = new ArrayList<>();
        BufferedReader read = new BufferedReader(new FileReader(failas));
        String line = null;
        while( (line = read.readLine()) != null) {
            StringTokenizer tokens = new StringTokenizer(line);
            if(tokens.hasMoreTokens())
            list.add(new Asmuo(tokens.nextToken(), tokens.nextToken(), Integer.parseInt(tokens.nextToken())));
        }
        return list;
    }

    public void papildyti(Asmuo duom) throws IOException {
        FileWriter writer = new FileWriter("duomenys.txt", true);
        writer.write("\n");
        writer.write(duom.getVardas() + " " + duom.getPavarde() + " " + duom.getAmzius());
        writer.close();
    }

    public void salinti(Asmuo asmuo) throws IOException {
        System.out.println(asmuo.getVardas() + " " + asmuo.getPavarde() + " " + asmuo.getAmzius());
        BufferedReader file = new BufferedReader(new FileReader("duomenys.txt"));
        String line;
        String input = "";
        while ((line = file.readLine()) != null) {
            System.out.println(line);
            if (line.contains(asmuo.getVardas() + " " + asmuo.getPavarde() + " " + asmuo.getAmzius())) {
                System.out.println(true);
                line = "";
            }
            if(!line.isEmpty())
            input += line + '\n';
        }
        FileOutputStream File = new FileOutputStream("duomenys.txt");
        File.write(input.trim().getBytes());
        file.close();
        File.close();
    }

}
