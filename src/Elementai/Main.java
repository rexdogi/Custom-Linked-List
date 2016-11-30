package Elementai;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Created by Paulius on 9/8/2016.
 */

public class Main {

    public static void main(String[] args) throws IOException {
        ElementuSarasas<Object> elemList = new ElementuSarasas<>();
        List list = new FailuApdorojimas().nuskaityti("duomenys.txt");

        //list.forEach(e -> elemList.prideti((Integer) e));
        list.forEach(e -> elemList.prideti(Integer.parseInt((String)e)));

       // list.isvestiVisus();

       // elemList.salinti(7);

        elemList.isvestiVisus();

      //  System.out.println(list.gautiPirmaElem().sekantis.ankstesnis.duom);
    }

}
