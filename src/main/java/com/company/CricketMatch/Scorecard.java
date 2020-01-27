package com.company.CricketMatch;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.graalvm.compiler.replacements.StringIndexOfNode;

import java.util.ArrayList;
//@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({"tossResult","teamBatFirst","firstRunsScored","firstWickets","firstOversPlayed","batFirst","bowlFirst","teamBowlFirst","secondRunsScored","secondWickets","secondOversPlayed","batSecond","bowlSecond","matchResult"})
public class Scorecard {
    String tossResult;

    String teamBatFirst;
    int firstRunsScored;
    int firstWickets;
    String firstOversPlayed;
    ArrayList<Player> batFirst;
    ArrayList<Bowler> bowlFirst;


    String teamBowlFirst;
    int secondRunsScored;
    int secondWickets;
    String secondOversPlayed;
    ArrayList<Player> batSecond;
    ArrayList<Bowler> bowlSecond;

    String matchResult;

    Scorecard(MatchAdmin admin){
        tossResult = admin.getTossResult();

        teamBatFirst = admin.getTeam1().getName();

        teamBowlFirst = admin.getTeam2().getName();

        firstRunsScored = admin.getTeam1().getScore();

        secondRunsScored = admin.getTeam2().getScore();

        firstWickets = admin.getTeam1().getWickets();

        secondWickets = admin.getTeam2().getWickets();

        firstOversPlayed = admin.getTeam1().getOversPlayed();

        secondOversPlayed = admin.getTeam2().getOversPlayed();

        batFirst = admin.getTeam1().getLineUp();

        bowlFirst = admin.getTeam2().getBowlers();

        batSecond = admin.getTeam2().getLineUp();

        bowlSecond = admin.getTeam1().getBowlers();

        matchResult = admin.getMatchResult();
    }

    @JsonProperty("Result")
    public String getMatchResult() {
        return matchResult;
    }

    @JsonProperty("First Innings Bowling")
    public ArrayList<Bowler> getBowlFirst() {
        return bowlFirst;
    }

    @JsonProperty("Second Innings Bowling")
    public ArrayList<Bowler> getBowlSecond() {
        return bowlSecond;
    }

    @JsonProperty("First Innings Batting")
    public ArrayList<Player> getBatFirst() {
        return batFirst;
    }

    @JsonProperty("Second Innings Batting")
    public ArrayList<Player> getBatSecond() {
        return batSecond;
    }

    @JsonProperty("Team Batting First")
    public String getTeamBatFirst() {
        return teamBatFirst;
    }

    @JsonProperty("Team Batting Second")
    public String getTeamBowlFirst() {
        return teamBowlFirst;
    }

    @JsonProperty(value = "Toss Result")
    public String getTossResult() {
        return tossResult;
    }

    @JsonProperty("First Innings Total")
    public int getFirstRunsScored() {
        return firstRunsScored;
    }

    @JsonProperty(value = "Overs",index=1)
    public String getFirstOversPlayed() {
        return firstOversPlayed;
    }

    @JsonProperty("Second Innings Total")
    public int getSecondRunsScored() {
        return secondRunsScored;
    }

    @JsonProperty(value = "Overs.",index = 0)
    public String getSecondOversPlayed() {
        return secondOversPlayed;
    }

    @JsonProperty(value = "Wickets")
    public int getFirstWickets() {
        return firstWickets;
    }

    @JsonProperty(value = "Wickets.")
    public int getSecondWickets() {
        return secondWickets;
    }
}
