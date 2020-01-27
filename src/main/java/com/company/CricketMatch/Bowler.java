package com.company.CricketMatch;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Bowler extends Player {
    private int oversBowled, wickets, runsGiven, maidens;
    private double economy;

    Bowler(Player player){
        super(player.getName(),player.getDefenceRating(),player.getAttackRating(),player.getRotateRating());
        this.setRunsScored(player.getRunsScored());
        this.setBallsFaced(player.getBallsFaced());
        this.setBoundaries(player.getBoundaries());
    }

    @JsonIgnore
    public int getBattingRating() {
        return this.getBattingRating();
    }

    @JsonIgnore
    public String getDismissal() {
        return this.getDismissal();
    }


    @JsonIgnore
    public double getStrikeRate() {
        return this.getStrikeRate();
    }

    @JsonIgnore
    public int getBallsFaced() {
        return this.getBallsFaced();
    }
    @JsonIgnore
    public int getRunsScored() {
        return this.getRunsScored();
    }
    @JsonIgnore
    public int getBoundaries() {
        return this.getBoundaries();
    }

    @JsonProperty("Economy")
    public double getEconomy() {
        return economy;
    }

    @JsonProperty("Overs")
    public int getOversBowled() {
        return oversBowled;
    }

    @JsonProperty("Wickets")
    public int getWickets() {
        return wickets;
    }

    @JsonProperty("Runs")
    public int getRunsGiven() {
        return runsGiven;
    }

    @JsonProperty("Maidens")
    public int getMaidens() {
        return maidens;
    }


    public void setOversBowled(int oversBowled) {
        this.oversBowled = oversBowled;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    public void setRunsGiven(int runsGiven) {
        this.runsGiven = runsGiven;
    }

    public void setMaidens(int maidens) {
        this.maidens = maidens;
    }

    public void setEconomy(double economy) {
        this.economy = economy;
    }


}
