package com.vmly.controller;


import com.vmly.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GameController {


    @Autowired
    private GameService gameService;


    @RequestMapping(method = RequestMethod.POST, name = "/wanttoplay")
    public Result wanttoplay(String player) {
        List<String> players = new ArrayList<String>();
        int playerSize = players.size();
        while (true) {
            if (playerSize == 2) {
                return new Result("ok");
            } else if (playerSize < 2) {
                players.add(player);
            }
        }
    }


    @RequestMapping(method = RequestMethod.POST, name = "/choice")
    public Result choice(int choice,String name) {
        return gameService.judge(param);
    }


}
