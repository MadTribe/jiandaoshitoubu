package com.vmly.controller;

import com.vmly.model.Result;
import com.vmly.model.User;
import com.vmly.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController("/user")
public class UserController {

    @Autowired
    private GameService gameService;

    @RequestMapping(method = RequestMethod.POST, value = "users")
    public Set<User> wanttoplay(User user) {
        return gameService.getPlayers();
    }


}
