package org.example;

import entities.Match;
import entities.Times;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Match match = new Match();
        ArrayList<String> raffle = match.drawTimes();
        ArrayList<Times> octaves = match.octaves(raffle);
        ArrayList<Times> fourth = match.fourth(octaves);
        ArrayList<Times> semi = match.semiFinal(fourth);
        ArrayList<Times> finalist = match.finall(semi);
        Times win = match.winnerTeam(finalist.get(0), finalist.get(0));
        System.out.println("\n---------------------------------");
        System.out.print("A seleção que ganhou a copa foi: ");
        System.out.println(win.getHomeTeam());


    }
}
