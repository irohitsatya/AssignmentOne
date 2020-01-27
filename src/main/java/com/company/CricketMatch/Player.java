//info abt player
package com.company.CricketMatch;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Player {
    private String name="";
    private int runsScored,ballsFaced,boundaries;
    private double strikeRate;
    private int defenceRating,attackRating,rotateRating;
    private String dismissal = "not out";
    private int[] frequencyTable;

    Player(String name, int defenceRating, int attackRating, int rotateRating){
        this.name = name;
        this.attackRating = attackRating;
        this.defenceRating = defenceRating;
        this.rotateRating = rotateRating;
        frequencyTable = new int[8];
        createFrequencyTable();


    }
    public void createFrequencyTable(){

        frequencyTable[0]=defenceRating+20;
        frequencyTable[1]= (int) Math.ceil(0.52*rotateRating-4.32);
        frequencyTable[2]= (int) Math.ceil(frequencyTable[1]/2.0);
        frequencyTable[3]= (int) Math.ceil(frequencyTable[1]/4.0);
        frequencyTable[4]= (int) Math.ceil(0.26*attackRating-2.25);
        frequencyTable[5]=1;
        frequencyTable[6]= (int) Math.ceil(frequencyTable[4]/2.0);
        frequencyTable[7]= (int) Math.ceil(18.1-0.18*defenceRating);

//        return frequencyTable;

    }

    public void setRunsScored(int runsScored) {
        this.runsScored = runsScored;
    }

    public void setBallsFaced(int ballsFaced) {
        this.ballsFaced = ballsFaced;
    }

    public void setBoundaries(int boundaries) {
        this.boundaries = boundaries;
    }

    public void setStrikeRate(double strikeRate) {
        this.strikeRate = strikeRate;
    }

    public void setDismissal(String dismissal) {
        this.dismissal = dismissal;
    }

    @JsonIgnore
    public int[] getFrequencyTable() {
        return frequencyTable;
    }

    @JsonProperty("Dismissal")
    public String getDismissal() {
        return dismissal;
    }

    @JsonProperty("Player Name")
    public String getName() {
        return name;
    }
    @JsonProperty("Balls")
    public int getBallsFaced() {
        return ballsFaced;
    }

    @JsonProperty("Runs")
    public int getRunsScored() {
        return runsScored;
    }

    @JsonProperty("Boundaries")
    public int getBoundaries() {
        return boundaries;
    }

    @JsonProperty("S/R")
    public double getStrikeRate() {
        return strikeRate;
    }

    @JsonIgnore
    public int getDefenceRating() {
        return defenceRating;
    }

    @JsonIgnore
    public int getAttackRating() {
        return attackRating;
    }

    @JsonIgnore
    public int getRotateRating() {
        return rotateRating;
    }
}
