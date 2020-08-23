package sr.unasat.verkeer.simulatie.app;

import sr.unasat.verkeer.simulatie.entities.Voertuig;
import sr.unasat.verkeer.simulatie.services.VerkeersSimulatieService;

import static sr.unasat.verkeer.simulatie.util.Constants.WEGDEK;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Voertuig> voertuigenNoordList = new ArrayList<>();
        List<Voertuig> voertuigenZuidList = new ArrayList<>();
        List<Voertuig> voertuigenOostList = new ArrayList<>();
        List<Voertuig> voertuigenWestList = new ArrayList<>();

        VerkeersSimulatieService verkeersSimulatieService = new VerkeersSimulatieService();
        voertuigenNoordList.add(new Voertuig(WEGDEK[0], 1));
        voertuigenNoordList.add(new Voertuig(WEGDEK[0], 2));
        voertuigenNoordList.add(new Voertuig(WEGDEK[0], 3, "Speciaal", "Ambulance met sirene", 3));
        voertuigenNoordList.add(new Voertuig(WEGDEK[0], 4));

        voertuigenZuidList.add(new Voertuig(WEGDEK[1], 1));
        voertuigenZuidList.add(new Voertuig(WEGDEK[1], 2));
        voertuigenZuidList.add(new Voertuig(WEGDEK[1], 3));
        voertuigenZuidList.add(new Voertuig(WEGDEK[1], 4));
        voertuigenZuidList.add(new Voertuig(WEGDEK[1], 5));
        voertuigenZuidList.add(new Voertuig(WEGDEK[1], 6));
        voertuigenZuidList.add(new Voertuig(WEGDEK[1], 7));
        voertuigenZuidList.add(new Voertuig(WEGDEK[1], 8));
        voertuigenZuidList.add(new Voertuig(WEGDEK[1], 9));
        voertuigenZuidList.add(new Voertuig(WEGDEK[1], 10));
        voertuigenZuidList.add(new Voertuig(WEGDEK[1], 11));
        voertuigenZuidList.add(new Voertuig(WEGDEK[1], 12));
        voertuigenZuidList.add(new Voertuig(WEGDEK[1], 13));
        voertuigenZuidList.add(new Voertuig(WEGDEK[1], 14));
        voertuigenZuidList.add(new Voertuig(WEGDEK[1], 15));
        voertuigenZuidList.add(new Voertuig(WEGDEK[1], 16));
        voertuigenZuidList.add(new Voertuig(WEGDEK[1], 17, "Speciaal", "Brandweer met sirene", 2));
        voertuigenZuidList.add(new Voertuig(WEGDEK[1], 18));

        voertuigenOostList.add(new Voertuig(WEGDEK[2], 1));
        voertuigenOostList.add(new Voertuig(WEGDEK[2], 2));
        voertuigenOostList.add(new Voertuig(WEGDEK[2], 3));
        voertuigenOostList.add(new Voertuig(WEGDEK[2], 4));
        voertuigenOostList.add(new Voertuig(WEGDEK[2], 5));

        voertuigenWestList.add(new Voertuig(WEGDEK[3], 1));
        voertuigenWestList.add(new Voertuig(WEGDEK[3], 2));
        voertuigenWestList.add(new Voertuig(WEGDEK[3], 3));
        voertuigenWestList.add(new Voertuig(WEGDEK[3], 4));
        voertuigenWestList.add(new Voertuig(WEGDEK[3], 5));
        voertuigenWestList.add(new Voertuig(WEGDEK[3], 6));
        voertuigenWestList.add(new Voertuig(WEGDEK[3], 7));
        voertuigenWestList.add(new Voertuig(WEGDEK[3], 8));
        voertuigenWestList.add(new Voertuig(WEGDEK[3], 9, "Speciaal", "Politie met sirene", 1));
        voertuigenWestList.add(new Voertuig(WEGDEK[3], 10));
        voertuigenWestList.add(new Voertuig(WEGDEK[3], 11));
        voertuigenWestList.add(new Voertuig(WEGDEK[3], 14));
        voertuigenWestList.add(new Voertuig(WEGDEK[3], 13));
        voertuigenWestList.add(new Voertuig(WEGDEK[3], 14));

        verkeersSimulatieService.prioritizeVoertuigen(voertuigenNoordList, voertuigenZuidList, voertuigenOostList, voertuigenWestList);
    }
}
