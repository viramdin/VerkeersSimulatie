package sr.unasat.verkeer.simulatie.entities;

public class Voertuig {
    private String naam;
    private String kentekenNr;
    private int priority;

    public Voertuig(String naam, String kentekenNr) {
        this.naam = naam;
        this.kentekenNr = kentekenNr;
    }

    public Voertuig(String naam, String kentekenNr, int priority) {
        this.naam = naam;
        this.kentekenNr = kentekenNr;
        this.priority = priority;
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

    @Override
    public String toString() {
        return "naam=" + naam + ", kentekenNr=" + kentekenNr;
    }
}
