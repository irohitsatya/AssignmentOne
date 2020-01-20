//operations that can be done on a team
package com.company.CricketMatch;
import java.lang.Math.*;

public class Match {
    Team team1 = new Team();
    Team team2 = new Team();

    public int Delivery() {
        return (int) (Math.random() * 8) - 1;
    }

    public int Innings(Team team) {
        for (int i = 0; i < 300; i++) {
            int temp = Delivery();
            if (temp == -1) {
                team.wickets += 1;
                if (team.wickets == 10)
                {return team.score;}
            }else{
                team.score += temp;
            }
        }
        return team.score;

    }

    public void Innings(Team team, int target){
        for (int i = 0; i < 300; i++) {
            int temp = Delivery();
            if (temp == -1) {
                team.wickets += 1;
                if (team.wickets == 10)
                {return;}
            } else {
                team.score += temp;
            }

            if(team.score >= target){
                return;
            }
        }
        return;
    }

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }
}
