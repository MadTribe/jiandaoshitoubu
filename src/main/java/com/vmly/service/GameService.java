package com.vmly.service;


import com.vmly.model.Result;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class GameService {


    private Map<String, Integer> map = new HashMap<String, Integer>();


    public Result choice(int choice, String name) {

        int size = map.size();

        if(!map.containsKey(name)){
            if (size < 2) {
                map.put(name, choice);
            }
        }

        return new Result("ok");

    }


    /**
     * choice=jiandao=1
     * choice=shitou=2
     * choice=bu=3
     *
     * @param name
     * @return
     */
    public String judge(String name) {

        Set<String> players = map.keySet();

        List<String> list = CollectionUtils.arrayToList(players);
        String player1 = list.get(0);
        String player2 = list.get(1);


        Integer choice1 = map.get(player1);
        Integer choice2 = map.get(player2);

        if (choice1 == 1 && choice2 == 2) {
            return player1 + "win";
        }

        if (choice1 == 1 && choice2 == 3) {
            return player2 + "win";
        }

        if (choice1 == 2 && choice2 == 3) {
            return player2 + "win";
        }

        return " please choice again !";


    }


}
