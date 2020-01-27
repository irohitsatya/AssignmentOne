//operations required to have a match
package com.company.CricketMatch;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatchController {

    @GetMapping("/cricket")
    public Scorecard admin(){
        Team t1 =  new Team("IND",3,4);
        Team t2 = new Team("AUS",3,4);


        MatchAdmin admin = new MatchAdmin(t1,t2);
        admin.ConductMatch();

        Scorecard scorecard = new Scorecard(admin);

        return scorecard;
    }


}
