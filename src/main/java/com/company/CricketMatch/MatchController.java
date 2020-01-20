//operations required to have a match
package com.company.CricketMatch;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatchController {

    @GetMapping("/cricket")
    public MatchAdmin admin(){
        MatchAdmin admin = new MatchAdmin();
        admin.ConductMatch();
        return admin;



    }


}
