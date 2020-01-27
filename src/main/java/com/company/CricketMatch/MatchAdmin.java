package com.company.CricketMatch;

public class MatchAdmin {
    private String tossResult="";
    private Team team1;
    private Team team2;
    private  String matchResult;

    MatchAdmin(Team team1,Team team2){
        this.team1 = team1;
        this.team2 = team2;
    }


    void ConductMatch(){


        team1.setLineUp();  team2.setLineUp();
        team1.setTeam()  ;  team2.setTeam();

        tossResult = Match.conductToss(this);

        //team1 batting first
        Match.Innings(true,team1,team2);
        Match.Innings(false,team2,team1);

        System.out.println(team1.getName()+" " +team1.getScore()+" "+team1.getWickets());
        System.out.println(team2.getName()+" " +team2.getScore()+" "+team2.getWickets());

        if(team1.getScore() > team2.getScore()){
            matchResult = team1.getName()+" won by "+ (team1.getScore() - team2.getScore()) + " runs";
        }
        else
            //matchResult = team2.getName()+" won by "+ (10 - team2.getWickets())+ " wickets";
            matchResult = team2.getName()+" won by "+ ((10-team2.getWickets()==1)?"1 wicket":10-team2.getWickets()+" wickets");



    }

    public String getMatchResult() {
        return matchResult;
    }

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public String getTossResult() {
        return tossResult;
    }

    public void setTossResult(String tossResult) {
        this.tossResult = tossResult;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public void setMatchResult(String matchResult) {
        this.matchResult = matchResult;
    }
}
