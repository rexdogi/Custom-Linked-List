package Elementai;

/**
 * Created by Paulius on 9/8/2016.
 */
/**
 Sarasas - dvipusis
 Iterpimas pagal reiksme
 Salinimas pagal reiksme
 veiksmas filtravimas,
 Papildomas eile
 */

public class Elementas<Tipas> {

    public Tipas duom;
    public Elementas<Tipas> sekantis;
    public Elementas<Tipas> ankstesnis;

    Elementas(Tipas duom, Elementas<Tipas> priekyn, Elementas<Tipas> ankstesnis) {
        this.duom = duom;
        this.sekantis = priekyn;
        this.ankstesnis = ankstesnis;
    }

}
