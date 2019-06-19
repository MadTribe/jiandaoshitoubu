package com.vmly.service;


import com.vmly.model.Result;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class GameService {


    private Map<String, Integer> map = new HashMap<String, Integer>();

    private Set<String> players = new HashSet<>();

    public Set<String> getPlayers() {
        return players;
    }


    public Result wanttopay(String player) {
        int playerSize = players.size();
        if (playerSize == 2) {
            return new Result("you are ready");
        } else if (playerSize < 2) {
            players.add(player);
            return new Result("ok");
        }

        return null;
    }


    public Result choice(int choice, String name) {

        int size = map.size();

        if (!map.containsKey(name)) {
            if (size < 2) {
                map.put(name, choice);
            }
        }

        return new Result("ok");

    }


    /**
     * choice=jiandao=1 jay
     * choice=shitou=2 jay1
     * choice=bu=3
     *
     * @param name
     * @return
     */
    public String judge(String name) {

        if (map.size() < 2) {
            return "please join the game!";
        }


        Set<String> players = map.keySet();


        Object[] objects = players.toArray();


        String player1 = (String) objects[0];
        String player2 = (String) objects[1];


        Integer choice1 = map.get(player1);
        Integer choice2 = map.get(player2);

        if (choice1 == 1 && choice2 == 2) {
            return player2 + "win";
        }

        if (choice1 == 1 && choice2 == 3) {
            return player1 + "win";
        }

        if (choice1 == 2 && choice2 == 3) {
            return player2 + "win";
        }


        if (choice1 == 3 && choice2 == 2) {
            return player1 + "win";
        }


        if (choice1 == 3 && choice2 == 1) {
            return player2 + "win";
        }

        return " please choice again !";


    }


}
