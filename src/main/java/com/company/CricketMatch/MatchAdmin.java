package com.company.CricketMatch;

public class MatchAdmin {
    String tossResult="";
    Team team1;
    Team team2;


    String matchResult;

    MatchAdmin(Team team1,Team team2){
        this.team1 = team1;
        this.team2 = team2;
    }


    void ConductMatch(){


        team1.setLineUp();  team2.setLineUp();
        team1.setTeam()  ;  team2.setTeam();

        tossResult = Match.conductToss(this);

        //team1 batting first
        int score = Match.Innings(team1,team2);
        Match.Innings(team2,team1,score+1);

        if(team1.score > team2.score){
            matchResult = team1.name+" won by "+ (team1.score - team2.score) + " runs";
        }
        else
            matchResult = team2.name+" won by "+ (10 - team2.wickets)+ " wickets";

    }

    public String getMatchResult() {
        return matchResult;
    }

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public String getTossResult() {
        return tossResult;
    }
}
