package com.company.CricketMatch;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;

public class Team {
    private String name = "";
    private int a,b;
    private int score = 0;
    private int wickets = 0;
    private String oversPlayed="";

    private ArrayList<Player> lineUp = new ArrayList<>(11);
    private ArrayList<Bowler> bowlers = new ArrayList<>();

    Team(String name,int a,int b) {
        this.name = name;
        this.a = a;
        this.b = b;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    public void setOversPlayed(String oversPlayed) {
        this.oversPlayed = oversPlayed;
    }

    public void setLineUp(){
        int i;
        for(i=0;i<a;i++){
            Player player = new Player(name+"-player"+(i+1),85,75,40);
            lineUp.add(player);
        }
        for(;i<a+b;i++){
            Player player = new Player(name +"-player"+(i+1),60,50,85);
            lineUp.add(player);
        }
        for(;i<11;i++){
            Player player = new Player(name+"-player"+(i+1),40,60,40);
            lineUp.add(player);
        }

    }

    public void setTeam(){
        for(int i=6;i<11;i++){
            Bowler bowler = new Bowler(lineUp.get(i));
            bowlers.add(bowler);
        }
    }
//    @JsonInclude(JsonInclude.Include.NON_DEFAULT)

    public ArrayList<Player> getinitLineUp(){
        return lineUp;
    }

    public ArrayList<Player> getLineUp() {
        ArrayList<Player> newLineUp = new ArrayList<>(11);
        for(int i=0;i<11;i++)
            if(lineUp.get(i).getBallsFaced()!=0)
                newLineUp.add(lineUp.get(i));
        return newLineUp;
    }

    public ArrayList<Bowler> getBowlers() {
        return bowlers;
    }

    public void setLineUp(ArrayList<Player> lineUp) {
        this.lineUp = lineUp;
    }

    public void setBowlers(ArrayList<Bowler> bowlers) {
        this.bowlers = bowlers;
    }
}
