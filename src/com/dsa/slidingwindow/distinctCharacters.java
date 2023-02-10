package com.dsa.slidingwindow;

import java.util.HashMap;

public class distinctCharacters {
    public static void main(String[] args) {
        System.out.println(countGoodSubstrings("ghhhcvuagiicrbujm"));
    }
    public static int countGoodSubstrings(String s) {

        HashMap<Character,Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;
        int unique = 0;
        int result = 0;
        while(right<3){
            Character c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if(map.get(c) == 1) unique++;
            else if(map.get(c) > 1)unique--;
            System.out.println(s.substring(left,right));
            right++;
        }

        if(unique == 3) result++;
        while(right<s.length()){
            Character charDel = s.charAt(left);
            if(map.get(charDel) == 1) unique--;
            map.replace(charDel, map.get(charDel) - 1);
            if(map.get(charDel) <= 0) {
                map.remove(charDel);
            }
            else if (map.get(charDel) == 1) unique++;
            Character charAdd = s.charAt(right);
            map.put(charAdd, map.getOrDefault(charAdd, 0) + 1);
            if(map.get(charAdd) == 1) unique++;
            else if(map.get(charAdd) > 1 && unique >0) unique--;
            if(unique == 3) result++;
            right++;
            left++;
        }

        return result;

    }
}
