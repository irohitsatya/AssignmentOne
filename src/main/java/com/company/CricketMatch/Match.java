//operations that can be done on a team
package com.company.CricketMatch;
import java.lang.Math.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Match {
    // wickets 3 8 12
    static int target;
    static int ballOutcomes[] = { 0, 1, 2, 3, 4, 5, 6, -1 };

//    static int topOrderFreq[] =  { 1, 140, 40, 20, 10, 20, 1, 6};
//    static int middleOrderFreq[]= {6, 60, 7, 5 , 2, 18, 1, 7};
//    static int lowerOrderFreq[] = {12, 80, 10, 5, 2, 4, 1, 2};

    public static int Delivery() {
        return (int) (Math.random() * 8) - 1;
    }

    public static int findCeil (int arr[], int r, int l, int h)
    {
        int mid;
        while (l < h)
        {
            mid = l + ((h - l) >> 1);	// Same as mid = (l+h)/2
            if (r > arr[mid])
                l = mid + 1;
            else
                h = mid;
        }
        return (arr[l] >= r) ? l : -1;
    }

    static int Delivery ( int frequencyArray[])
    {
        int n=8;
        // Create and fill prefix array
        int prefix[] = new int[n];
        prefix[0] = frequencyArray[0];
        for (int i = 1; i < n; ++i)
            prefix[i] = prefix[i - 1] + frequencyArray[i];

        // prefix[n-1] is sum of all frequencies.
        // Generate a random number with
        // value from 1 to this sum

        int r = (int)(Math.random () * prefix[n - 1]);
        // Find index of ceiling of r in prefix array
        int index = findCeil (prefix, r, 0, n - 1);
        return ballOutcomes[index];
    }

    public static int oneOrZero() {
        return (int) (Math.random() * 2);
    }

    public static String conductToss(MatchAdmin admin) {
        String tossResult = "";
        Team tempTeam;
        int temp = oneOrZero();

        if (temp == 0) {  //team 1 won toss
            tossResult = admin.getTeam1().getName() + " won the toss and elected to";
            temp = oneOrZero();
            if (temp == 0) { //chose to bat
                tossResult += " bat first";
            } else { //chose to field
                tossResult += " field first";
                tempTeam = admin.getTeam1();

                admin.setTeam1(admin.getTeam2());

                admin.setTeam2(tempTeam);
            }
        } else { //team 2 won toss
            tossResult = admin.getTeam2().getName() + " won the toss and elected to";
            temp = oneOrZero();
            if (temp == 0) { //chose to bat
                tossResult += " bat first";
                tempTeam = admin.getTeam1();

                admin.setTeam1(admin.getTeam2());

                admin.setTeam2(tempTeam);
            } else {
                tossResult += " field first";
            }
        }
        return tossResult;
    }

    public static void Innings(boolean isFirst,Team battingTeam, Team bowlingTeam) {


        ArrayList<Player> battingLineup = battingTeam.getinitLineUp();
        ArrayList<Bowler> bowlingLineup = bowlingTeam.getBowlers();


        Player striker, nonStriker, tempPlayer;
        Bowler curBowler = bowlingLineup.get(0);


        striker = battingLineup.get(0);
        nonStriker = battingLineup.get(1);


        int inAt = 2;
        int bowlerPosition = 0;
        int isMaiden = 1;

        int ball, i;
        for (i = 1; i <= 300; i++) {
            ball = Delivery(striker.getFrequencyTable());
            if (ball == -1) {
                striker.setBallsFaced(striker.getBallsFaced()+1);
                striker.setStrikeRate(Math.round(striker.getRunsScored()*100.0/striker.getBallsFaced()*100.0)/100.0);
                //curBowler.setWickets(curBowler.getWickets()+1);
                //call dismissal
                striker.setDismissal(Match.dismissal(curBowler,bowlingTeam.getinitLineUp()));
                battingTeam.setWickets(battingTeam.getWickets()+1);
                if (battingTeam.getWickets() == 10) {
                    if(nonStriker.getBallsFaced()!=0)
                        nonStriker.setStrikeRate(Math.round(nonStriker.getRunsScored()*100f/nonStriker.getBallsFaced()*100.0)/100.0);
                    battingTeam.setOversPlayed((i / 6) + "." + (i % 6));
                    target = battingTeam.getScore();
                    return;
                }
                striker = battingLineup.get(inAt++);
            } else {

                isMaiden = 0;
                striker.setBallsFaced(striker.getBallsFaced() + 1);
                striker.setRunsScored(striker.getRunsScored() + ball);
                battingTeam.setScore(battingTeam.getScore()+ball);
                curBowler.setRunsGiven(curBowler.getRunsGiven()+ball);

                if (ball == 4 || ball == 6)
                    striker.setBoundaries(striker.getBoundaries() + 1);

                if(isFirst == false && battingTeam.getScore() > target){
                    battingTeam.setOversPlayed((i / 6) + "." + (i % 6));
                    striker.setStrikeRate(Math.round(striker.getRunsScored()*100.0/striker.getBallsFaced()*100.0)/100.0);
                    if(nonStriker.getBallsFaced()!=0)
                        nonStriker.setStrikeRate(Math.round(nonStriker.getRunsScored()*100f/nonStriker.getBallsFaced()*100.0)/100.0);
                    return;
                }
                if (ball % 2 == 1) {
                    tempPlayer = striker;
                    striker = nonStriker;
                    nonStriker = tempPlayer;
                }
            }

            if (i % 6 == 0) {
                tempPlayer = striker;
                striker = nonStriker;
                nonStriker = tempPlayer;
                curBowler.setOversBowled(curBowler.getOversBowled()+1);
                curBowler.setEconomy(Math.round((double)curBowler.getRunsGiven()/curBowler.getOversBowled()*100.0)/100.0);
                if (isMaiden == 1) {
                    curBowler.setMaidens(curBowler.getMaidens()+1);
                } else {
                    isMaiden = 1;
                }

                bowlerPosition = (bowlerPosition + 1) % 5;
                curBowler = bowlingLineup.get(bowlerPosition);

            }

        }
        battingTeam.setOversPlayed("50.0");

        striker.setStrikeRate(Math.round(striker.getRunsScored()*100.0/striker.getBallsFaced()*100.0)/100.0);
        if(nonStriker.getBallsFaced()!=0)
            nonStriker.setStrikeRate(Math.round(nonStriker.getRunsScored()*100f/nonStriker.getBallsFaced()*100.0)/100.0);
        target = battingTeam.getScore();

        return;
    }

    public static String dismissal(Bowler bowler, ArrayList<Player>fieldingEleven ){
        String batsmanDismissal ="";
        int dismissalType = (int)(Math.random()*5);
        int player;
        switch(dismissalType){
            case 0: batsmanDismissal = "b "+bowler.getName();
                    bowler.setWickets(bowler.getWickets()+1);
                    break;
            case 1: batsmanDismissal = "lbw "+bowler.getName();
                    bowler.setWickets(bowler.getWickets()+1);
                    break;
            case 2: batsmanDismissal = "st "+fieldingEleven.get(5).getName() + " b " +bowler.getName() ;
                    bowler.setWickets(bowler.getWickets()+1);
                    break;
            case 3: player = (int)(Math.random()*11);
                    if(bowler.getName().equals(fieldingEleven.get(player).getName()))
                        {batsmanDismissal = "c & b "+bowler.getName();}
                    else
                        batsmanDismissal = "c "+fieldingEleven.get(player).getName() + " b " +bowler.getName();
                    bowler.setWickets(bowler.getWickets()+1);
                    break;
            case 4: player = (int)(Math.random()*11);
                    batsmanDismissal = "run out("+fieldingEleven.get(player).getName()+")";
                    break;
            default: break;

        }
        return batsmanDismissal;
    }
}


