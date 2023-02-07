package com.dsa.slidingwindow;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
//        Input: s = "ADOBECODEBANC", t = "ABC"
//        Output: "BANC"
//        Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
        minWindow("babb","baba");
    }
    public static String minWindow(String s, String t) {
        if(t.length() > s.length() ) return "";
        HashMap<Character,Integer> map = new HashMap<>();

        String subStr = s;

        for (int i = 0;i<t.length();i++){
            Character c  = t.charAt(i);
            map.put(c,map.getOrDefault(c,0) + 1);
        }

        int left = 0;
        int right = 0;

        int minLength = s.length();

        boolean result  = false;

        while( right < s.length()){
            Character c = s.charAt(right);

            if(map.containsKey(c)){

                map.replace(c, map.get(c) - 1);

                while(isZero(map)){
                    result = true;
                    if(right - left + 1 < minLength){
                        minLength = right - left + 1;
                        subStr = s.substring(left,right + 1);
                    }

                    Character deleteChar = s.charAt(left);
                    if(map.containsKey(deleteChar)) {
                        map.replace(deleteChar, map.get(deleteChar) + 1);
                    }
                    left++;
                }

                right++;

            }
            else{
                right++;
            }


        }
        if(result == false){
            return "";
        }
        return subStr;
    }

    private static Boolean isZero(HashMap<Character,Integer> map){
        for(Map.Entry<Character,Integer> en: map.entrySet()){
            if(en.getValue() > 0) return false;
        }
        return true;
    }
}
