package sr.unasat.verkeer.simulatie.services;

import sr.unasat.verkeer.simulatie.entities.Voertuig;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VerkeersSimulatieService {
    static Random randNum = new Random();

    public List<Voertuig> fillVoertuigArray(String type, int size) {
        List<Voertuig> voertuigList = new ArrayList<>();
        if (type == "Normal") {
            for (int i = 0; i <= size; i++) {
                char letter = "ABCDEFGHIJKLMNOPQRSTUVWZYZ".toCharArray()[randNum.nextInt("ABCDEFGHIJKLMNOPQRSTUVWZYZ".toCharArray().length)];
                voertuigList.add(new Voertuig("Voertuig" + Integer.toString(i + 1), "P" + letter + " " + randNum.nextInt(100 - 0) + "-" + randNum.nextInt(100 - 0)));
            }
            return voertuigList;
        } else if (type == "Special") {
            char letter = "ABCDEFGHIJKLMNOPQRSTUVWZYZ".toCharArray()[randNum.nextInt("ABCDEFGHIJKLMNOPQRSTUVWZYZ".toCharArray().length)];
            voertuigList.add(new Voertuig("Politie met sirene", "P" + letter + " " + randNum.nextInt(100 - 0) + "-" + randNum.nextInt(100 - 0), 1));
            voertuigList.add(new Voertuig("Brandweer met sirene", "P" + letter + " " + randNum.nextInt(100 - 0) + "-" + randNum.nextInt(100 - 0), 2));
            voertuigList.add(new Voertuig("Ambulance met sirene", "P" + letter + " " + randNum.nextInt(100 - 0) + "-" + randNum.nextInt(100 - 0), 3));
            return voertuigList;
        } else {
            return null;
        }
    }
}
