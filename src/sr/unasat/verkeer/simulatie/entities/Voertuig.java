package sr.unasat.verkeer.simulatie.entities;

public class Voertuig {
    private int volgNr;
    private String kentekenNr;
    private int priority;

    public Voertuig(int volgNr, String kentekenNr, int priority) {
        this.volgNr = volgNr;
        this.kentekenNr = kentekenNr;
        this.priority = priority;
    }

    public int getVolgNr() {
        return volgNr;
    }

    public void setVolgNr(int volgNr) {
        this.volgNr = volgNr;
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
        return "Voertuig{" +
                "volgNr=" + volgNr +
                ", kentekenNr='" + kentekenNr + '\'' +
                ", priority=" + priority +
                '}';
    }
}
