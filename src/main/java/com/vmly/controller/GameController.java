package com.vmly.controller;


import com.vmly.service.GameService;
import com.vmly.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@RestController("/")
public class GameController {


    @Autowired
    private GameService gameService;

    private static Set<String> players = new HashSet<>();


    @RequestMapping(method = RequestMethod.POST, value = "wanttoplay")
    public Result wanttoplay(String player) {

        int playerSize = players.size();
        if (playerSize == 2) {
            return new Result("you are ready");
        } else if (playerSize < 2) {
            players.add(player);
            return new Result("ok");
        }

        return null;

    }


    @RequestMapping(method = RequestMethod.POST, value = "choice")
    public Result choice(int choice, String name) {
        return gameService.choice(choice, name);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/result")
    public String result(String name) {
        return gameService.judge(name);
    }

}
