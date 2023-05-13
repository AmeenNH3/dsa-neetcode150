package com.dsa.arraysandhasing.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxNoBalloons {
    //nlaebolko
    public static int maxNumberOfBalloons(String text) {
        String balloon = "balloon";
        HashMap<Character,Integer> textMap = new HashMap<>();
        HashMap<Character,Integer> balloonMap = new HashMap<>();

        for(int i  =0;i< balloon.length();i++){
            Character c = balloon.charAt(i);
            balloonMap.put(c, balloonMap.getOrDefault(c,0) + 1 );
        }

        for(int i  =0;i< text.length();i++){
            Character c = text.charAt(i);
            if(balloonMap.containsKey(c))
                textMap.put(c, textMap.getOrDefault(c,0) + 1 );
        }

        for(Map.Entry<Character,Integer> entry:balloonMap.entrySet()){
            Character key = entry.getKey();
            Integer val = entry.getValue();
            if(textMap.containsKey(key)){
                Integer postDiv =  textMap.get(key)/val;
                textMap.replace(key, postDiv);
            }
            else{
                return 0;
            }
        }

        int min = Integer.MAX_VALUE;

        for(Map.Entry<Character,Integer> en: textMap.entrySet()){
            if(en.getValue() < min)
            {
                min = en.getValue();
            }

        }

        return min;
    }

    public static void main(String[] args) {
        maxNumberOfBalloons("nlaebolko");
    }
}
