package sr.unasat.verkeer.simulatie.entities;

import java.util.Random;

public class Voertuig {
    Wegdek wegdek;
    private int nummer;
    private String type;
    private String naam;
    private String kentekenNr;
    private int priority;

    public Voertuig(Wegdek wegdek, int nummer) {
        this.wegdek = wegdek;
        this.nummer = nummer;
        this.naam = "Auto" + nummer;
        this.kentekenNr = generateKentekenNr();
    }

    public Voertuig(Wegdek wegdek, int nummer, String type, String naam, int priority) {
        this.wegdek = wegdek;
        this.nummer = nummer;
        this.type = type;
        this.naam = naam;
        this.kentekenNr = generateKentekenNr();
        this.priority = priority;
    }

    private String generateKentekenNr() {
        Random randNum = new Random();
        String letters = "ABCDEFGHJKL";
        char letter = letters.toCharArray()[randNum.nextInt(letters.toCharArray().length)];
        String numberOne = String.format("%02d", randNum.nextInt(100 - 0));
        String numberTwo = String.format("%02d", randNum.nextInt(100 - 0));
        String kenteken = "P" + letter + " " + numberOne + "-" + numberTwo;
        return kenteken;
    }

    public Wegdek getWegdek() {
        return wegdek;
    }

    public void setWegdek(Wegdek wegdek) {
        this.wegdek = wegdek;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getKentekenNr() {
        return kentekenNr;
    }

    public void setKentekenNr(String kentekenNr) {
        this.kentekenNr = kentekenNr;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
