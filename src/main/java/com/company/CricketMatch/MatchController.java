//operations required to have a match
package com.company.CricketMatch;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatchController {

    @GetMapping("/cricket")
    public MatchAdmin admin(){
        Team t1 =  new Team("IND");
        Team t2 = new Team("AUS");
        Match match = new Match(t1,t2);


        MatchAdmin admin = new MatchAdmin(match);
        admin.ConductMatch();

        Scorecard scorecard = new Scorecard(admin);
        //return admin;

        return admin;
    }


}
