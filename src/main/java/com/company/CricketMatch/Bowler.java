package com.company.CricketMatch;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Bowler extends Player {
    int oversBowled;
    int wickets;
    int runsGiven;
    int maidens;

    Bowler(Player player){
        super(player.name);
        this.runsScored = player.runsScored;
        this.ballsFaced = player.ballsFaced;
    }

    @JsonIgnore
    public int getBallsFaced() {
        return ballsFaced;
    }
    @JsonIgnore
    public int getRunsScored() {
        return runsScored;
    }
    @JsonIgnore
    public int getBoundaries() {
        return boundaries;
    }

    public int getOversBowled() {
        return oversBowled;
    }

    public int getWickets() {
        return wickets;
    }

    public int getRunsGiven() {
        return runsGiven;
    }

    public int getMaidens() {
        return maidens;
    }

}
