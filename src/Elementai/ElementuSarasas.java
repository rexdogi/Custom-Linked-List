package Elementai;

import java.io.IOException;
import java.util.Iterator;
import java.util.function.Predicate;

/**
 * Created by Paulius on 10/13/2016.
 */
public class ElementuSarasas<Tipas> implements Iterable<Tipas> {

    private String failas = null;
    private Elementas<Tipas> head;
    private FailoApdorojimas apdorojimas = new FailoApdorojimas();

    public void isvestiVisus() {
        Elementas laikinas = this.head;
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

    public void prideti(Tipas tipas) throws IOException {
        if(tipas instanceof Asmuo) apdorojimas.papildyti((Asmuo)tipas);
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

    public void init(Tipas tipas) {
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
        this.head = new Elementas<>(tipas, null, null);
        //  new FailoRasymas(this.head.duom.toString());
    }

    /**
     * Prideda duomenų tipą Integer pagal reikšmę.
     */
    private void pridetPagalSkaiciu(Tipas tipas) {
        Elementas<Tipas> laikinas = this.head;

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
                laikinas.sekantis = new Elementas<>(tipas, laikinas.sekantis, laikinas);
            }
        } else {
            this.head = new Elementas<>(tipas, this.head, null);
        }
        // new FailoRasymas(next.duom.toString());
    }

    /**
     * Prideda bet kurį duomenu tipą sarašo priekyje
     */
    public void pridetiPriekyje(Tipas tipas) {
        this.head = new Elementas<>(tipas, head, null);
    }

    /**
     * Prideda bet kurį duomenu tipą sarašo gale
     */
    private void pridetiGale(Tipas tipas) {
        if (head == null) {
            sukurtiElementa(tipas);
            return;
        }
        Elementas laikinas = head;
        while (laikinas.sekantis != null) {
            laikinas = laikinas.sekantis;
        }
        laikinas.sekantis = new Elementas<>(tipas, null, laikinas);
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
        Elementas<Tipas> laikinas = head;
        while (laikinas.sekantis != null) {
            laikinas = laikinas.sekantis;
        }
        return laikinas.duom;
    }

    private Elementas<Tipas> gautiPaskutiniElem() {
        Elementas<Tipas> laikinas = head;
        while (laikinas.sekantis != null) {
            laikinas = laikinas.sekantis;
        }
        return laikinas;
    }

    public Tipas gautiPagalIndeksa(int index) {
        Elementas<Tipas> laikinas = this.head;
        for (int i = 0; i < index; i++) {
            laikinas = laikinas.sekantis;
        }
        return laikinas.duom;
    }

    public int gautiPagalReiksme(Tipas value) {
        Elementas<Tipas> laikinas = this.head;
        int index = 0;
        while (laikinas.sekantis != null) {
            if (laikinas.duom != value) {
                laikinas = laikinas.sekantis;
                index++;
            } else break;
        }
        return index;
    }

    private Elementas gautiPirmaElem() {
        return this.head;
    }

    public Elementas<Tipas> gautiElementaPagalReiksme(Tipas value) {
        Elementas<Tipas> laikinas = this.head;
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
    public void salinti(Tipas tipas) throws IOException {
        Elementas<Tipas> laikinas = this.head;
        if (laikinas != null) {
            while (laikinas.sekantis != null) {
                if (laikinas.duom.equals(tipas)) break;
                laikinas = laikinas.sekantis;
            }
            if(laikinas.duom instanceof Asmuo) apdorojimas.salinti((Asmuo) laikinas.duom);
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

    public void salinti(Predicate<Tipas> tikrinimas) throws IOException {
        Elementas<Tipas> laikinas = this.head;
        if (laikinas != null) {
            while (laikinas.sekantis != null) {
                if (tikrinimas.test(laikinas.duom)) break;
                laikinas = laikinas.sekantis;
            }
            if(laikinas.duom instanceof Asmuo) apdorojimas.salinti((Asmuo) laikinas.duom);
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
        Elementas<Tipas> laikinas = head;
        while (laikinas.sekantis != null) {
            laikinas = laikinas.sekantis;
        }
        laikinas.ankstesnis.sekantis = null;
    }

    public ElementuSarasas<Tipas> filtruoti(Predicate<Tipas> tikrinimas) {
        Elementas<Tipas> laikinas = head;
        ElementuSarasas<Tipas> elem = new ElementuSarasas<>();
        while (laikinas != null) {
            if(tikrinimas.test(laikinas.duom)) {
                elem.pridetiPriekyje(laikinas.duom);
            }
            laikinas = laikinas.sekantis;
        }
        return elem;
    }

    @Override
    public Iterator<Tipas> iterator() {
        return new ManoIterator();
    }

    public class ManoIterator implements Iterator {

        private Elementas<Tipas> laikinas = head;
        private Elementas<Tipas> temp = null;

        public boolean hasNext() {
            return laikinas.sekantis != null;
        }

        public Tipas next() {
            if(temp == null) {
                temp = laikinas;
                return temp.duom;
            } else {
                laikinas = laikinas.sekantis;
                return laikinas.duom;
            }

        }
    }
}
