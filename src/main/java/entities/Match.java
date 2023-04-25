package entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class Match {

    public ArrayList<Times> octaves(ArrayList<String> sort) {
        ArrayList<Times> round1 = new ArrayList<Times>(); //oitavas
        System.out.println("Oitavas de Final da Copa");
        System.out.println("-------------------------");
        for (int i = 0; i < 8; i++) {
            sort.remove(i);
            sort.remove(i + 1);
            HashMap<String, Integer> gol = drawGols();
            round1.add(new Times(sort.get(i), sort.get(i + 1), gol.get("M"), gol.get("V")));
            System.out.println(round1.get(i).getHomeTeam() + "  " + round1.get(i).getHomeGoal()
                    + "  x  " + round1.get(i).getVisitingGoal() + "  " + round1.get(i).getVisitingTeam());
        }
        return round1;
    }

    public ArrayList<Times> fourth(ArrayList<Times> round1) {
        ArrayList<Times> round2 = new ArrayList<Times>(); //quartas
        for (int i = 0; i < round1.size(); i += 2) {
            Times teamOne, teamTwo;
            HashMap<String, Integer> goal = drawGols();
            teamOne = (winnerTeam(round1.get(i), round1.get(i)));
            teamTwo = (winnerTeam(round1.get(i + 1), round1.get(i + 1)));
            round2.add(new Times(teamOne.getHomeTeam(), teamTwo.getHomeTeam(), goal.get("M"), goal.get("V")));
        }
        System.out.println();
        System.out.println("Quartas de Final da Copa");
        System.out.println("---------------------------------");
        for (int i = 0; i < 4; i++) {
            System.out.println(round2.get(i).getHomeTeam() + "  " + round2.get(i).getHomeGoal() + "  x  " + round2.get(i).getVisitingGoal() + "  " + round2.get(i).getVisitingTeam());
        }
        return round2;
    }

    public ArrayList<Times> semiFinal(ArrayList<Times> round2) {
        ArrayList<Times> round3 = new ArrayList<Times>(); //semifinal
        for (int z = 0; z < round2.size(); z += 2) {
            Times teamOne, teamTwo;
            HashMap<String, Integer> goal = drawGols();
            teamOne = (winnerTeam(round2.get(z), round2.get(z)));
            teamTwo = (winnerTeam(round2.get(z + 1), round2.get(z + 1)));
            round3.add(new Times(teamOne.getHomeTeam(), teamTwo.getHomeTeam(), goal.get("M"), goal.get("V")));
        }
        System.out.println();
        System.out.println("SemiFinal da Copa do Mundo");
        System.out.println("---------------------------------");
        for (int i = 0; i < round3.size(); i++) {
            System.out.println(round3.get(i).getHomeTeam() + "  " + round3.get(i).getHomeGoal() + "  x  " + round3.get(i).getVisitingGoal() + "  " + round3.get(i).getVisitingTeam());
        }
        return round3;
    }

    public ArrayList<Times> finall(ArrayList<Times> round3) {
        ArrayList<Times> round4 = new ArrayList<Times>(); //final
        Times teamOne, teamTwo;
        HashMap<String, Integer> goal = drawGols();
        teamOne = (winnerTeam(round3.get(0), round3.get(0)));
        teamTwo = (winnerTeam(round3.get(1), round3.get(1)));
        round4.add(new Times(teamOne.getHomeTeam(), teamTwo.getHomeTeam(), goal.get("M"), goal.get("V")));

        System.out.println();
        System.out.println("Final da Copa do Mundo");

        System.out.println(round4.get(0).getHomeTeam() + "  " + round4.get(0).getHomeGoal() + "  x  " + round4.get(0).getVisitingGoal() + "  " + round4.get(0).getVisitingTeam());
        return round4;
    }

    public HashMap<String, Integer> drawGols() {
        Random rand = new Random();
        HashMap<String, Integer> result = new HashMap<String, Integer>();
        int homeGoal;
        int visitingGoal;
        boolean isGoalsOk;

        do {
            homeGoal = rand.nextInt(5);
            visitingGoal = rand.nextInt(5);
            isGoalsOk = homeGoal != visitingGoal;

        } while (!isGoalsOk);
        result.put("M", homeGoal);
        result.put("V", visitingGoal);

        return result;
    }

    public Times winnerTeam(Times home, Times visit) {
        int homeM = home.getHomeGoal();
        int visitV = visit.getVisitingGoal();
        HashMap<String, Integer> goal = drawGols();

        if (homeM > visitV) {
            home.homeTeam = home.getHomeTeam();
            home.homeGoal = goal.get("M");
            return home;
        } else {
            visit.homeTeam = visit.getVisitingTeam();
            visit.homeGoal = goal.get("V");
            return visit;
        }
    }

    public ArrayList<String> drawTimes() {
        ArrayList<String> sort = new ArrayList<String>();

        sort.add("Brasil");
        sort.add("Alemanha");
        sort.add("Espanha");
        sort.add("Argentina");
        sort.add("França");
        sort.add("Portugal");
        sort.add("Bélgica");
        sort.add("Inglaterra");
        sort.add("Uruguai");
        sort.add("Croácia");
        sort.add("México");
        sort.add("Suécia");
        sort.add("Suíça");
        sort.add("Dinamarca");
        sort.add("Senegal");
        sort.add("Irã");
        sort.add("Tunísia");
        sort.add("Marrocos");
        sort.add("Nigéria");
        sort.add("Japão");
        sort.add("Coreia do Sul");
        sort.add("Arábia Saudita");
        sort.add("Austrália");
        sort.add("Rússia");
        sort.add("Peru");
        sort.add("Costa Rica");
        sort.add("Sérvia");
        sort.add("Islândia");
        sort.add("Panamá");
        sort.add("Egito");
        sort.add("Catar");

        Collections.shuffle(sort);
        return sort;
    }

}
