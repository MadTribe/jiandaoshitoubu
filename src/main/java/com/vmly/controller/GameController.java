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


    @RequestMapping(method = RequestMethod.POST, value = "wanttoplay")
    public Result wanttoplay(String player) {
        return gameService.wanttopay(player);
    }


    @RequestMapping(method = RequestMethod.POST, value = "choice")
    public Result choice(int choice, String name) {
        return gameService.choice(choice, name);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/result")
    public String result(String name) {
        return gameService.judge(name);
    }


}
