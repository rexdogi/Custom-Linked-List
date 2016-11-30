package Elementai;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.*;
import java.util.*;
import java.util.stream.Stream;

/**
 * Created by Paulius on 11/10/2016.
 */
public class FailuApdorojimas {

    public List<Object> nuskaityti(String failas) throws IOException {
        List list = new ArrayList<>();
        BufferedReader read = new BufferedReader(new FileReader(failas));
        String line = null;
        while( (line = read.readLine()) != null) {
            StringTokenizer tokens = new StringTokenizer(line);
            while (tokens.hasMoreTokens()) list.add(tokens.nextToken());
        }
        return list;
    }

    public void papildyti(Object duom) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("duomenys.txt");
        writer.println(duom);
    }

}
