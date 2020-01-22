package com.company.CricketMatch;

public class MatchAdmin {
    String tossResult;
    Team team1;
    Team team2;


    Match match ;
    String matchResult;

    MatchAdmin(Match match){
        this.team1 = match.team1;
        this.team2 = match.team2;
        this.match = match;
    }


    void ConductMatch(){
//        int score = match.Innings(match.team1);
//        match.Innings(match.team2,score+1);
//
//        if(match.team1.score > match.team2.score){
//            result = "Team A won by "+ (match.team1.score - match.team2.score) + " runs";
//        }
//        else
//            result = "Team B won by "+ (10 - match.team2.wickets)+ " wickets";


//        team1 = new Team();
//        team2 = new Team();
        team1.setLineUp();team2.setLineUp();
        team1.setTeam();team2.setTeam();

        tossResult = match.conductToss(team1,team2);
        System.out.println(match.team1.name+" "+match.team2.name+"-------");

        //team1 batting first
        int score = match.Innings(team1,team2);
        match.Innings(team2,team1,score+1);

          //int score1 = match.Innings(team1,team2);
//          System.out.println(score1);
//
//        int score2 = match.Innings(team2,team1);
        if(match.team1.score > match.team2.score){
            matchResult = team1.name+" won by "+ (match.team1.score - match.team2.score) + " runs";
        }
        else
            matchResult = team2.name+" won by "+ (10 - match.team2.wickets)+ " wickets";

    }

    public Match getMatch() {
        return match;
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
