package com.company.CricketMatch;

public class MatchAdmin {
    Match match = new Match();
    String result;


    void ConductMatch(){
        int score = match.Innings(match.team1);
        match.Innings(match.team2,score+1);

        if(match.team1.score > match.team2.score){
            result = "Team A won by "+ (match.team1.score - match.team2.score) + "runs";
        }
        else
            result = "Team B won by "+ (10 - match.team2.wickets)+ " wickets";
    }

    public Match getMatch() {
        return match;
    }

    public String getResult() {
        return result;
    }
}
