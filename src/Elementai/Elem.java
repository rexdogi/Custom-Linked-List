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

public class Elem<Tipas> {

    public Tipas duom;
    public Elem<Tipas> sekantis;
    public Elem<Tipas> ankstesnis;

    Elem(Tipas duom, Elem<Tipas> priekyn, Elem<Tipas> ankstesnis) {
        this.duom = duom;
        this.sekantis = priekyn;
        this.ankstesnis = ankstesnis;
    }

}
