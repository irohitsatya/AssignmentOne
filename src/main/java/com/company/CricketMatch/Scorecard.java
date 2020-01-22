package com.company.CricketMatch;

import org.graalvm.compiler.replacements.StringIndexOfNode;

import java.util.ArrayList;

public class Scorecard {
    String tossResult;

    String teamBatFirst;
    ArrayList<Player> batFirst;
    ArrayList<Bowler> bowlFirst;
    String teamBowlFirst;
    ArrayList<Player> batSecond;
    ArrayList<Bowler> bowlSecond;

    String matchResult;

    Scorecard(MatchAdmin admin){
        tossResult = admin.tossResult;
        teamBatFirst = admin.team1.name;
        teamBowlFirst = admin.team2.name;
        batFirst = admin.team1.lineUp;
        bowlFirst = admin.team2.bowlers;

        batSecond = admin.team2.lineUp;
        bowlSecond = admin.team1.bowlers;

        matchResult = admin.matchResult;
    }

    public String getMatchResult() {
        return matchResult;
    }

    public ArrayList<Bowler> getBowlFirst() {
        return bowlFirst;
    }

    public ArrayList<Bowler> getBowlSecond() {
        return bowlSecond;
    }

    public ArrayList<Player> getBatFirst() {
        return batFirst;
    }

    public ArrayList<Player> getBatSecond() {
        return batSecond;
    }

    public String getTeamBatFirst() {
        return teamBatFirst;
    }

    public String getTeamBowlFirst() {
        return teamBowlFirst;
    }

    public String getTossResult() {
        return tossResult;
    }
}
