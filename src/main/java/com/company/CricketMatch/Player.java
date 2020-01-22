//info abt player
package com.company.CricketMatch;

public class Player {
    String name;
    int runsScored,ballsFaced,boundaries;

    Player(String name){
        this.name=name;

    }

    public String getName() {
        return name;
    }

    public int getBallsFaced() {
        return ballsFaced;
    }

    public int getRunsScored() {
        return runsScored;
    }

    public int getBoundaries() {
        return boundaries;
    }
}
