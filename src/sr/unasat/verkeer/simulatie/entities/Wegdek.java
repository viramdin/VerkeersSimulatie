package sr.unasat.verkeer.simulatie.entities;

public class Wegdek {
    private int wegdekNummer;
    private String wegdekNaam;

    public Wegdek(int wegdekCode) {
        this.wegdekNummer = wegdekCode;
    }

    public Wegdek(int wegdekCode, String wegdekNaam) {
        this.wegdekNummer = wegdekCode;
        this.wegdekNaam = wegdekNaam;
    }

    public int getWegdekNummer() {
        return wegdekNummer;
    }

    public void setwegdekNummer(int wegdekNummer) {
        this.wegdekNummer = wegdekNummer;
    }

    public String getWegdekNaam() {
        return wegdekNaam;
    }

    public void setWegdekNaam(String wegdekNaam) {
        this.wegdekNaam = wegdekNaam;
    }
}
