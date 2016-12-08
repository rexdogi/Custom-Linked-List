package Elementai;

import java.io.IOException;
import java.util.List;

/**
 * Created by Paulius on 9/8/2016.
 */

public class Main {

    public static void main(String[] args) throws IOException {
        ElementuSarasas<Asmuo> elemList = new ElementuSarasas<>();
        List<Asmuo> list = new FailoApdorojimas().nuskaityti("duomenys.txt");
        list.forEach(elemList::init);
        Asmuo a = new Asmuo("Adam","LUL", 60);
        elemList.salinti(asmuo -> asmuo.getVardas().equalsIgnoreCase("Leo"));

      /*  elemList.prideti(a);
        elemList.prideti(new Asmuo("lul","lul", 40));

        elemList.salinti(z -> z.getAmzius() == 50);*/
      //elemList.salinti(elemList.filtruoti(amzius -> amzius.getAmzius() > 0).gautiPirma());
        //elemList.filtruoti(duom -> duom.getAmzius() > 50).forEach(d -> System.out.println(d.getAmzius()));
        elemList.filtruoti(age -> age.getAmzius() > 30).forEach(d -> System.out.println(d.getVardas()));

    }

}
