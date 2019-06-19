package com.vmly.service;


import com.vmly.model.JianDaoShiTouBuEnum;
import com.vmly.model.JudgeResult;
import com.vmly.model.Result;
import com.vmly.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class GameService {


    private static Map<String, Integer> map = new HashMap<String, Integer>();

    private static Set<User> players = new HashSet<>();

    public Set<User> getPlayers() {
        return players;
    }


    public Result wanttopay(User player) {
        players.add(player);
        int playerSize = players.size();
        if (playerSize == 1) {
            return Result.WAITING;
        } else {
            return Result.OK;
        }

    }


    public Result choice(int choice, User user) {

        String name = user.getName();
        map.put(name, choice);


        return Result.OK;

    }


    /**
     * choice=jiandao=1 jay
     * choice=shitou=2 jay1
     * choice=bu=3
     *
     * @return
     */
    public JudgeResult judge() {

        if (map.size() < 2) {
            return null;
        }

        Set<String> players = map.keySet();

        Object[] objects = players.toArray();


        String player1 = (String) objects[0];
        String player2 = (String) objects[1];


        Integer choice1 = map.get(player1);
        Integer choice2 = map.get(player2);

        JudgeResult judgeResult = new JudgeResult();
        judgeResult.setResult(JudgeResult.Result.WIN);

        int jianDao = JianDaoShiTouBuEnum.JIANDAO.ordinal();
        int shiTou = JianDaoShiTouBuEnum.SHITOU.ordinal();
        int bu = JianDaoShiTouBuEnum.BU.ordinal();

        if (choice1 == jianDao && choice2 == shiTou) {
            judgeResult.setName(player2);

        }

        if (choice1 == jianDao && choice2 == bu) {
            judgeResult.setName(player1);
        }

        if (choice1 == shiTou && choice2 == bu) {
            judgeResult.setName(player2);
        }

        if (choice1 == shiTou && choice2 == jianDao) {
            judgeResult.setName(player1);
        }


        if (choice1 == bu && choice2 == shiTou) {
            judgeResult.setName(player1);
        }


        if (choice1 == bu && choice2 == jianDao) {
            judgeResult.setName(player2);
        }



        return judgeResult;

    }


}
