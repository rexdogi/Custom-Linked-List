package Elementai;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Paulius on 9/8/2016.
 */

public class Main {

    public static void main(String[] args) throws IOException {
        ElementuSarasas<Integer> list = new ElementuSarasas<>();
        Scanner scanner = new Scanner(new File("duomenys.txt"));

       /* while(scanner.hasNextInt())
        {
            list.prideti(scanner.nextInt());
        }*/

       list.pridetiPriekyje(5);
        list.pridetiPriekyje(7);
        list.pridetiGale(10);
        /* list.prideti(7);
        list.isvestiVisus();
        System.out.println();
        list.isvestiVisus();*/

        //list.isimti(100);
        list.isvestiVisus();


    }

}
