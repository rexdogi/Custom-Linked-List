package Elementai;

/**
 * Created by Paulius on 10/13/2016.
 */
public class ElementuSarasas<Tipas> {

    private Elem<Tipas> head;

    public void isvestiVisus() {
        Elem laikinas = this.head;
        while (laikinas != null) {
            System.out.println(laikinas.duom);
            laikinas = laikinas.sekantis;
        }
        laikinas = laikinas.ankstesnis.ankstesnis;
        while (laikinas != null) {
            System.out.println(laikinas.duom);
            laikinas = laikinas.ankstesnis;
        }
    }

    public void prideti(Tipas tipas) {
        if(head == null) {
            sukurtiElementa(tipas);
            return;
        }
        if (tipas instanceof Integer) {
            pridetPagalSkaiciu(tipas);
        } else if(tipas instanceof String) {
            pridetPagalString(tipas);
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
                    if((Integer)laikinas.sekantis.duom > (Integer) tipas) {
                        break;
                    } else laikinas = laikinas.sekantis;
                } else break;
            }
            if(laikinas.sekantis == null) {
                pridetiGale(tipas);
            } else {
                laikinas.sekantis = new Elem<>(tipas, laikinas.sekantis, laikinas);
            }
        } else {
            this.head = new Elem<>(tipas, this.head, null);
        }
       // new FailoRasymas(next.duom.toString());
    }

    private void pridetPagalString(Tipas tipas) {
        Elem<Tipas> laikinas = this.head;

        if (Character.getNumericValue(laikinas.duom.toString().charAt(0)) < Character.getNumericValue(tipas.toString().charAt(0))) {
            while (laikinas.sekantis != null) {
                if (Character.getNumericValue(laikinas.duom.toString().charAt(0)) < Character.getNumericValue(tipas.toString().charAt(0))) {
                    if (Character.getNumericValue(laikinas.duom.toString().charAt(0)) > Character.getNumericValue(tipas.toString().charAt(0))) {
                        break;
                    } else laikinas = laikinas.sekantis;
                } else break;
            }
            if(laikinas.sekantis == null) {
                pridetiGale(tipas);
            } else {
                laikinas.sekantis = new Elem<>(tipas, laikinas.sekantis, laikinas);
            }
          //  new FailoRasymas(next.duom.toString());
        } else {
            this.head = new Elem<>(tipas, this.head, null);
           // new FailoRasymas(head.duom.toString());
        }
    }

    /**
     * Prideda bet kurį duomenu tipą sarašo priekyje
     */

    public void pridetiPriekyje(Tipas tipas) {
        this.head = new Elem<>(tipas, head, null);
    }

    /**
     * Prideda bet kurį duomenu tipą sarašo gale
     */

    public void pridetiGale(Tipas tipas) {
        if(head == null) {
            sukurtiElementa(tipas);
            return;
        }
        Elem laikinas = head;
        while (laikinas.sekantis != null) {
            laikinas = laikinas.sekantis;
        }
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

     public Tipas gautiPagalIndeksa(int index) {
        Elem<Tipas> laikinas = this.head;
        for(int i = 0; i < index; i++) {
            laikinas = laikinas.sekantis;
        }
        return laikinas.duom;
    }

    public int gautiPagalReiksme(Tipas value) {
        Elem<Tipas> laikinas = this.head;
        int index = 0;
        while (laikinas.sekantis != null) {
            if(laikinas.duom != value) {
                laikinas = laikinas.sekantis;
                index++;
            }
            else break;
        }
        return index;
    }

    public Elem<Tipas> gautiElementaPagalReiksme(Tipas value) {
        Elem<Tipas> laikinas = this.head;
        int index = 0;
        while (laikinas.sekantis != null) {
            if(laikinas.duom != value) {
                laikinas = laikinas.sekantis;
                index++;
            }
            else break;
        }
        return laikinas;
    }

    /**
     * Išema pirmą elementą iš sarašo
     */


    public void isimti(Tipas tipas) {
        Elem<Tipas> laikinas = this.head;
        int index = 0;
        while (laikinas.sekantis != null) {
            if(laikinas.duom != tipas) {
                laikinas = laikinas.sekantis;
                index++;
            } else {
                System.out.println(laikinas.sekantis.sekantis.duom);
                break;
            }
        }

    }
}
