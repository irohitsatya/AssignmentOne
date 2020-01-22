package com.company.CricketMatch;

import java.util.ArrayList;

public class Team {
    String name = "";

    int score = 0;
    int wickets = 0;
    String oversPlayed="";

    ArrayList<Player> lineUp = new ArrayList<>(11);
    ArrayList<Bowler> bowlers = new ArrayList<>();

    Team(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public int getWickets() {
        return wickets;
    }

    public String getOversPlayed() {
        return oversPlayed;
    }
    public String getName() {
        return name;
    }

    public void setLineUp(){
        for(int i=0;i<11;i++){
            Player player = new Player("player"+(i+1));
            lineUp.add(player);
        }
    }

    public void setTeam(){
//        int numberOfBowlers = 0;
//        int temp;

        for(int i=6;i<11;i++){
            Bowler bowl = new Bowler(lineUp.get(i));
            bowlers.add(bowl);
//            numberOfBowlers++;
        }
    }

    public ArrayList<Player> getLineUp() {
        return lineUp;
    }

    public ArrayList<Bowler> getBowlers() {
        return bowlers;
    }


}
