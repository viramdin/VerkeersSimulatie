package sr.unasat.verkeer.simulatie.app;

import sr.unasat.verkeer.simulatie.datastructures.PriorityQueue;
import sr.unasat.verkeer.simulatie.datastructures.Queue;
import sr.unasat.verkeer.simulatie.datastructures.Stack;
import sr.unasat.verkeer.simulatie.entities.Voertuig;
import sr.unasat.verkeer.simulatie.services.VerkeersSimulatieService;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        VerkeersSimulatieService verkeersSimulatieService = new VerkeersSimulatieService();
        List<Voertuig> voertuigenSpeciaalList = verkeersSimulatieService.fillVoertuigArray("Special", 3);
        List<Voertuig> voertuigenNoordList = verkeersSimulatieService.fillVoertuigArray("Normal", 3);
        List<Voertuig> voertuigenZuidList = verkeersSimulatieService.fillVoertuigArray("Normal", 17);
        List<Voertuig> voertuigenOostList = verkeersSimulatieService.fillVoertuigArray("Normal", 5);
        List<Voertuig> voertuigenWestList = verkeersSimulatieService.fillVoertuigArray("Normal", 13);

        PriorityQueue voertuigenSpeciaalQueue = new PriorityQueue(3);
        Queue voertuigenNoordQueue = new Queue(3);
        Queue voertuigenZuidQueue = new Queue(17);
        Queue voertuigenOostQueue = new Queue(5);
        Queue voertuigenWestQueue = new Queue(13);

        Stack voertuigenSpeciaalStack = new Stack(3);
        Stack voertuigenNoordStack = new Stack(3);
        Stack voertuigenZuidStack = new Stack(17);
        Stack voertuigenOostStack = new Stack(5);
        Stack voertuigenWestStack = new Stack(13);

        for (Voertuig voertuig : voertuigenSpeciaalList) {
            voertuigenSpeciaalQueue.insert(voertuig);
        }
        for (Voertuig voertuig : voertuigenNoordList) {
            voertuigenNoordQueue.enqueue(voertuig);
        }
        for (Voertuig voertuig : voertuigenZuidList) {
            voertuigenZuidQueue.enqueue(voertuig);
        }
        for (Voertuig voertuig : voertuigenOostList) {
            voertuigenOostQueue.enqueue(voertuig);
        }
        for (Voertuig voertuig : voertuigenWestList) {
            voertuigenWestQueue.enqueue(voertuig);
        }

        while (!voertuigenSpeciaalQueue.isEmpty()) {
            Voertuig voertuig = voertuigenSpeciaalQueue.remove();
            voertuigenSpeciaalStack.push(voertuig.getNaam());
            System.out.println(voertuig.getNaam());
        }

        System.out.println();

        while (!voertuigenNoordQueue.isEmpty(voertuigenNoordQueue)) {
            Voertuig voertuig = voertuigenNoordQueue.dequeue();
            voertuigenNoordStack.push(voertuig.getNaam());
            System.out.println(voertuig.getNaam());
        }

        System.out.println();

        while (!voertuigenZuidQueue.isEmpty(voertuigenZuidQueue)) {
            Voertuig voertuig = voertuigenZuidQueue.dequeue();
            voertuigenZuidStack.push(voertuig.getNaam());
            System.out.println(voertuig.getNaam());
        }

        System.out.println();

        while (!voertuigenOostQueue.isEmpty(voertuigenOostQueue)) {
            Voertuig voertuig = voertuigenOostQueue.dequeue();
            voertuigenOostStack.push(voertuig.getNaam());
            System.out.println(voertuig.getNaam());
        }

        System.out.println();

        while (!voertuigenWestQueue.isEmpty(voertuigenWestQueue)) {
            Voertuig voertuig = voertuigenWestQueue.dequeue();
            voertuigenWestStack.push(voertuig.getNaam());
            System.out.println(voertuig.getNaam());
        }

        System.out.println();

        while (!voertuigenSpeciaalStack.isEmpty()) {
            String item = voertuigenSpeciaalStack.pop();
            System.out.println(item);
        }

        System.out.println();

        while (!voertuigenNoordStack.isEmpty()) {
            String item = voertuigenNoordStack.pop();
            System.out.println(item);
        }

        System.out.println();

        while (!voertuigenZuidStack.isEmpty()) {
            String item = voertuigenZuidStack.pop();
            System.out.println(item);
        }

        System.out.println();

        while (!voertuigenOostStack.isEmpty()) {
            String item = voertuigenOostStack.pop();
            System.out.println(item);
        }

        System.out.println();

        while (!voertuigenWestStack.isEmpty()) {
            String item = voertuigenWestStack.pop();
            System.out.println(item);
        }
    }
}
