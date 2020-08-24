package sr.unasat.verkeer.simulatie.services;

import sr.unasat.verkeer.simulatie.datastructures.PriorityQueue;
import sr.unasat.verkeer.simulatie.datastructures.Queue;
import sr.unasat.verkeer.simulatie.datastructures.Stack;
import sr.unasat.verkeer.simulatie.entities.Voertuig;

import static sr.unasat.verkeer.simulatie.util.Constants.WEGDEK;

import java.util.List;

public class VerkeersSimulatieService {
    PriorityQueue voertuigenSpeciaalQueue = new PriorityQueue();
    Queue voertuigenNoordQueue = new Queue();
    Queue voertuigenZuidQueue = new Queue();
    Queue voertuigenOostQueue = new Queue();
    Queue voertuigenWestQueue = new Queue();

    Stack stack = new Stack();

    public void prioritizeVoertuigen(List<Voertuig> voertuigeNoordList, List<Voertuig> voertuigenZuidList, List<Voertuig> voertuigenOostList, List<Voertuig> voertuigenWestList) {
        for (Voertuig voertuig : voertuigeNoordList) {
            if (voertuig.getType() == "Speciaal") {
                voertuigenSpeciaalQueue.insert(voertuig);
            } else {
                voertuigenNoordQueue.enqueue(voertuig);
            }
        }
        for (Voertuig voertuig : voertuigenZuidList) {
            if (voertuig.getType() == "Speciaal") {
                voertuigenSpeciaalQueue.insert(voertuig);
            } else {
                voertuigenZuidQueue.enqueue(voertuig);
            }
        }
        for (Voertuig voertuig : voertuigenOostList) {
            if (voertuig.getType() == "Speciaal") {
                voertuigenSpeciaalQueue.insert(voertuig);
            } else {
                voertuigenOostQueue.enqueue(voertuig);
            }
        }
        for (Voertuig voertuig : voertuigenWestList) {
            if (voertuig.getType() == "Speciaal") {
                voertuigenSpeciaalQueue.insert(voertuig);
            } else {
                voertuigenWestQueue.enqueue(voertuig);
            }
        }
        stoplichtRoulatie();
    }

    private void stoplichtRoulatie() {
        System.out.println("Speciale voertugen rijden op");
        while (!voertuigenSpeciaalQueue.isEmpty()) {
            Voertuig voertuig = voertuigenSpeciaalQueue.remove();
            stack.push(voertuig);
            System.out.println("Speciaal voertuig " + voertuig.getNaam() + " met als kentekennr " + voertuig.getKentekenNr() + " rijdt op");
        }
        System.out.println();

        int teller = 0;
        for (int wegdekIndex = 0; wegdekIndex < WEGDEK.length; wegdekIndex++) {
            if (voertuigenNoordQueue.isEmpty() && voertuigenZuidQueue.isEmpty() && voertuigenOostQueue.isEmpty() && voertuigenWestQueue.isEmpty()) {
                System.out.println("Alle wegdekken zijn al leeg");
                System.out.println("Aantal rondes om alle voertuigen op te laten rijden: " + Math.round(teller / 4));
                System.out.println();
                reversePlayback();
                break;
            } else {
                switch (WEGDEK[wegdekIndex].getWegdekNummer()) {
                    case 1:
                        sensorNoord();
                        System.out.println();
                        break;
                    case 2:
                        sensorZuid();
                        System.out.println();
                        break;
                    case 3:
                        sensorOost();
                        System.out.println();
                        break;
                    case 4:
                        sensorWest();
                        wegdekIndex = -1;
                        System.out.println();
                        break;
                    default:

                        break;
                }
            }
            teller++;
        }
    }

    private void normaleSituatie(Queue queue) {
        for (int i = 0; i < 5; i++) {
            if (!queue.isEmpty()) {
                oprijden(queue);
            } else {
                break;
            }
        }
    }

    private void oprijden(Queue queue) {
        Voertuig voertuig = queue.dequeue();
        System.out.println(voertuig.getNaam() + " met als kentekenNr " + voertuig.getKentekenNr() + " rijdt op");
        stack.push(voertuig);
    }

    private void sensorNoord() {
        int voertuigen = voertuigenNoordQueue.getnItems();
        if (!voertuigenNoordQueue.isEmpty()) {
            System.out.println("Sensor Noord wordt geactiveerd");
            if (voertuigen < 5) {
                System.out.println("Stoplicht Noord springt op groen");

                for (int voertuigenIndex = 0; voertuigenIndex < voertuigen; voertuigenIndex++) {
                    if (!voertuigenNoordQueue.isEmpty()) {
                        oprijden(voertuigenNoordQueue);
                    } else {
                        System.out.println("Stoplicht Noord springt op rood");
                        break;
                    }
                }
            } else {
                normaleSituatie(voertuigenNoordQueue);
            }
        } else {
            System.out.println("Wegdek Noord is leeg");
        }
    }

    private void sensorZuid() {
        if (!voertuigenZuidQueue.isEmpty()) {
            System.out.println("Sensor Zuid wordt geactiveerd");
            if (voertuigenZuidQueue.getnItems() > 10) {
                System.out.println("Stoplicht Zuid springt op groen");
                for (int voertuigenIndex = 0; voertuigenIndex < 10; voertuigenIndex++) {
                    if (!voertuigenZuidQueue.isEmpty()) {
                        oprijden(voertuigenZuidQueue);
                    } else {
                        System.out.println("Wegdek Zuid is leeg");
                        break;
                    }
                }
            } else {
                normaleSituatie(voertuigenZuidQueue);
            }
        } else {
            System.out.println("Wegdek Zuid is leeg");
        }
    }

    private void sensorOost() {
        System.out.println("Sensor Oost wordt geactiveerd");
        if (!voertuigenOostQueue.isEmpty()) {
            System.out.println("Stoplicht Oost springt op groen");
            normaleSituatie(voertuigenOostQueue);
        } else {
            System.out.println("Wegdek Oost is leeg");
        }
    }

    private void sensorWest() {
        System.out.println("Sensor West wordt geactiveerd");
        if (voertuigenWestQueue.getnItems() > 10) {
            System.out.println("Stoplicht West springt op groen");
            for (int voertuigenIndex = 0; voertuigenIndex < 10; voertuigenIndex++) {
                if (!voertuigenWestQueue.isEmpty()) {
                    oprijden(voertuigenWestQueue);
                } else {
                    System.out.println("Wegdek West is leeg");
                    break;
                }
            }
        } else {
            normaleSituatie(voertuigenWestQueue);
        }
    }

    private void reversePlayback() {
        System.out.println("De voertuigen rijden terug naar hun initiële positie");
        while (!stack.isEmpty()) {
            Voertuig voertuig = stack.pop();
            System.out.println(voertuig.getNaam() + " met als kentekenNr " + voertuig.getKentekenNr() + " rijdt terug naar wegdek " + voertuig.getWegdek().getWegdekNaam());
        }
    }
}
