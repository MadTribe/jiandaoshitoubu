package com.vmly.controller;


import com.vmly.model.Result;
import org.springframework.stereotype.Service;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.HashMap;
import java.util.Map;

@Service
public class GameService {


    private Map<String, Integer> map = new HashMap<String, Integer>();


    public Result choice(int choice, String name) {

        int size = map.size();

        //1:剪刀
        while (true) {
            if (size == 2) {
                break;
            } else if (size < 2) {
                map.put(name, choice);
            }
        }


        return new Result("ok");

    }


}
