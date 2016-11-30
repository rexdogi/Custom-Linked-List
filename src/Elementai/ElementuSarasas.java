package Elementai;

import java.io.FileNotFoundException;

/**
 * Created by Paulius on 10/13/2016.
 */
public class ElementuSarasas<Tipas> {

    private Elem<Tipas> head;
    private FailuApdorojimas apdorojimas = new FailuApdorojimas();

    public void isvestiVisus() {
        Elem laikinas = this.head;
        while (laikinas != null) {
            System.out.println(laikinas.duom);
            laikinas = laikinas.sekantis;
        }

        laikinas = gautiPaskutiniElem();
        while (laikinas != null) {
            System.out.println(laikinas.duom);
            if (laikinas.ankstesnis != null) {
                laikinas = laikinas.ankstesnis;
            } else break;
        }
    }

    public void prideti(Tipas tipas) {
        if (head == null) {
            sukurtiElementa(tipas);
            return;
        }
        if (tipas instanceof Integer) {
            pridetPagalSkaiciu(tipas);
        } else if (tipas instanceof String) {

        } else {
            pridetiGale(tipas);
        }
    }

    /**
     * Sukuria pirmajį elementą head jeigu jis neegzistuoja
     */
    public void sukurtiElementa(Tipas tipas) {
        this.head = new Elem<>(tipas, null, null);
        //  new FailoRasymas(this.head.duom.toString());
    }

    /**
     * Prideda duomenų tipą Integer pagal reikšmę.
     */
    private void pridetPagalSkaiciu(Tipas tipas) {
        Elem<Tipas> laikinas = this.head;

        if (laikinas.duom == tipas) {
            System.out.println("priekyje");
            pridetiPriekyje(tipas);
            return;
        }

        if ((Integer) laikinas.duom < (Integer) tipas) {
            while (laikinas.sekantis != null) {
                if ((Integer) laikinas.duom < (Integer) tipas) {
                    if ((Integer) laikinas.sekantis.duom > (Integer) tipas) {
                        break;
                    } else laikinas = laikinas.sekantis;
                } else break;
            }
            if (laikinas.sekantis == null) {
                pridetiGale(tipas);
            } else {
                laikinas.sekantis = new Elem<>(tipas, laikinas.sekantis, laikinas);
            }
        } else {
            this.head = new Elem<>(tipas, this.head, null);
        }
        // new FailoRasymas(next.duom.toString());
    }

    /**
     * Prideda bet kurį duomenu tipą sarašo priekyje
     */
    private void pridetiPriekyje(Tipas tipas) {
        this.head = new Elem<>(tipas, head, null);
    }

    /**
     * Prideda bet kurį duomenu tipą sarašo gale
     */
    private void pridetiGale(Tipas tipas) {
        if (head == null) {
            sukurtiElementa(tipas);
            return;
        }
        Elem laikinas = head;
        while (laikinas.sekantis != null) {
            laikinas = laikinas.sekantis;
        }
        System.out.println("DEBUG: " + laikinas.duom);
        laikinas.sekantis = new Elem<>(tipas, null, laikinas);
    }

    /**
     * Gražina pirmo elemento duomenis iš sarašo
     */
    public Tipas gautiPirma() {
        return this.head.duom;
    }

    /**
     * Gražina paskutinio elemento duomenis iš sarašo
     */
    public Tipas gautiPaskutini() {
        Elem<Tipas> laikinas = head;
        while (laikinas.sekantis != null) {
            laikinas = laikinas.sekantis;
        }
        return laikinas.duom;
    }

    private Elem gautiPaskutiniElem() {
        Elem<Tipas> laikinas = head;
        while (laikinas.sekantis != null) {
            laikinas = laikinas.sekantis;
        }
        return laikinas;
    }

    public Tipas gautiPagalIndeksa(int index) {
        Elem<Tipas> laikinas = this.head;
        for (int i = 0; i < index; i++) {
            laikinas = laikinas.sekantis;
        }
        return laikinas.duom;
    }

    public int gautiPagalReiksme(Tipas value) {
        Elem<Tipas> laikinas = this.head;
        int index = 0;
        while (laikinas.sekantis != null) {
            if (laikinas.duom != value) {
                laikinas = laikinas.sekantis;
                index++;
            } else break;
        }
        return index;
    }

    private Elem gautiPirmaElem() {
        return this.head;
    }

    public Elem<Tipas> gautiElementaPagalReiksme(Tipas value) {
        Elem<Tipas> laikinas = this.head;
        int index = 0;
        while (laikinas.sekantis != null) {
            if (laikinas.duom != value) {
                laikinas = laikinas.sekantis;
                index++;
            } else break;
        }
        return laikinas;
    }

    /**
     * Išema elementą pagal reikšmę iš sarašo
     */
    public void salinti(Tipas tipas) {
        Elem<Tipas> laikinas = this.head;
        if (laikinas != null) {
            while (laikinas.sekantis != null) {
                if (laikinas.duom.equals(tipas)) break;
                laikinas = laikinas.sekantis;
            }
            if (laikinas.ankstesnis == null) {
                salintiPirma();
            } else if (laikinas.sekantis == null) {
                salintiPaskutini();
            } else {
                laikinas.ankstesnis.sekantis = laikinas.sekantis;
                laikinas.sekantis.ankstesnis = laikinas.ankstesnis;
            }
        }
    }

    /**
     * Išema pirmą elementą iš sarašo
     */
    private void salintiPirma() {
        head = head.sekantis;
        head.ankstesnis = null;
    }

    /**
     * Išema paskutinį elementą iš sarašo
     */
    private void salintiPaskutini() {
        Elem<Tipas> laikinas = head;
        while (laikinas.sekantis != null) {
            laikinas = laikinas.sekantis;
        }
        laikinas.ankstesnis.sekantis = null;
    }


}
