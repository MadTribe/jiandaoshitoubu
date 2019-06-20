package com.vmly.controller;


import com.vmly.model.JudgeResult;
import com.vmly.model.Result;
import com.vmly.model.User;
import com.vmly.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController("/")
public class GameController {

    @Autowired
    private GameService gameService;


    @RequestMapping(method = RequestMethod.POST, value = "wanttoplay")
    public Result wanttoplay(@RequestBody  User user) {
        return gameService.wanttopay(user);
    }


    @RequestMapping(method = RequestMethod.POST, value = "choice")
    public Result choice(int choice, User user) {
        return gameService.choice(choice, user);
    }


    @RequestMapping(method = RequestMethod.GET, value = "result")
    public JudgeResult result() {
        return gameService.judge();
    }


}
