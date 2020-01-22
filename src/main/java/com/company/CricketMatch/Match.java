//operations that can be done on a team
package com.company.CricketMatch;
import java.lang.Math.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Match {
    Team team1;
    Team team2;

    Match(Team team1,Team team2){
        this.team1=team1;
        this.team2=team2;
    }

    public int Delivery() {
        return (int) (Math.random() * 8) - 1;
    }

//    public Bowler chooseBowler(ArrayList<Bowler> bowlingLineup){
//        Bowler curBowler = bowlingLineup.get(2);
//
//        return curBowler;
//    }

    public int oneOrZero(){ return (int) (Math.random() * 2) ;}


    public String conductToss(Team team1,Team team2){
//        System.out.println(team1.name+" "+team2.name);

        String tossResult = "";
        Team tempTeam;
        int temp = oneOrZero();

        if(temp==0){  //team 1 won toss
            tossResult = team1.name + " won the toss and elected to";
            temp = oneOrZero();
            if(temp == 0){ //chose to bat
                tossResult += " bat first";
            }
            else { //chose to field
                tossResult += " field first";
                tempTeam = team1;
                team1 = team2;
                team2 = tempTeam;
//                System.out.println(team1.name+" "+team2.name);
            }
        }
        else{ //team 2 won toss
            tossResult = team2.name + " won the toss and elected to";
            temp = oneOrZero();
            if(temp == 0){ //chose to bat
                tossResult += " bat first";
                tempTeam = team1;
                team1 = team2;
                team2 = tempTeam;
//                System.out.println(team1.name+" "+team2.name);
            }
            else {
                tossResult += " field first";
            }
        }
        System.out.println(team1.name+" "+team2.name);
        return tossResult;
    }



    public int Innings(Team battingTeam, Team bowlingTeam){


        ArrayList<Player> battingLineup = battingTeam.lineUp;
        ArrayList<Bowler> bowlingLineup = bowlingTeam.bowlers;



        Player striker, nonStriker,tempPlayer;
        Bowler curBowler = bowlingLineup.get(0);



        striker = battingLineup.get(0);
        nonStriker = battingLineup.get(1);


        int inAt = 2;
        int bowlerPosition = 0;
        int isMaiden = 1;

        int ball,i;
        for(i=1; i<=300;i++){
            ball = Delivery();
            if(ball == -1){
                curBowler.wickets++;
                battingTeam.wickets++;
                if(battingTeam.wickets == 10){

                    battingTeam.oversPlayed = (i/6)+"."+(i%6);
                    return battingTeam.score;
                }
                striker = battingLineup.get(inAt++);
            }
            else{

                isMaiden = 0;
                striker.ballsFaced++;
                striker.runsScored += ball;
                battingTeam.score += ball;
                curBowler.runsGiven += ball;
                if(ball==4 || ball==6)
                    striker.boundaries++;

                if(ball%2==1){
                    tempPlayer = striker;
                    striker = nonStriker;
                    nonStriker = tempPlayer;
                }
            }

            if(i%6==0){
                tempPlayer = striker;
                striker = nonStriker;
                nonStriker = tempPlayer;
                curBowler.oversBowled++;
                if(isMaiden == 1){
                    curBowler.maidens++;
                }
                else{
                    isMaiden = 1;
                }

                bowlerPosition = (bowlerPosition + 1)%5;
                curBowler = bowlingLineup.get(bowlerPosition);

            }

        }

        battingTeam.oversPlayed = (i/6)+"."+(i%6);
        return battingTeam.score;
    }


    public void Innings(Team battingTeam, Team bowlingTeam,int target){


        ArrayList<Player> battingLineup = battingTeam.lineUp;
        ArrayList<Bowler> bowlingLineup = bowlingTeam.bowlers;



        Player striker, nonStriker,tempPlayer;
        Bowler curBowler = bowlingLineup.get(0);



        striker = battingLineup.get(0);
        nonStriker = battingLineup.get(1);


        int inAt = 2;
        int bowlerPosition = 0;
        int isMaiden = 1;

        int ball,i;
        for(i=1; i<=300;i++){
            ball = Delivery();
            striker.ballsFaced++;
            if(ball == -1){
                curBowler.wickets++;
                battingTeam.wickets++;
                if(battingTeam.wickets == 10){

                    battingTeam.oversPlayed = (i/6)+"."+(i%6);
                    return;
                }
                striker = battingLineup.get(inAt++);
            }
            else{

                isMaiden = 0;
                striker.runsScored += ball;
                battingTeam.score += ball;
                curBowler.runsGiven += ball;
                if(ball==4 || ball==6)
                    striker.boundaries++;
                if(battingTeam.score>=target)
                    return;

                if(ball%2==1){
                    tempPlayer = striker;
                    striker = nonStriker;
                    nonStriker = tempPlayer;
                }
            }

            if(i%6==0){
                tempPlayer = striker;
                striker = nonStriker;
                nonStriker = tempPlayer;
                curBowler.oversBowled++;

                if(isMaiden == 1){
                    curBowler.maidens++;
                }
                else{
                    isMaiden = 1;
                }

                bowlerPosition = (bowlerPosition + 1)%5;
                curBowler = bowlingLineup.get(bowlerPosition);

            }

        }

        battingTeam.oversPlayed = (i/6)+"."+(i%6);
        return;
    }


    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }

}
