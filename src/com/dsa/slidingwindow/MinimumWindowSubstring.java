package com.dsa.slidingwindow;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
//        Input: s = "ADOBECODEBANC", t = "ABC"
//        Output: "BANC"
//        Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
        minWindow2("ADOBECODEBANC","ABC");
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

    public static String minWindow2(String s, String t) {
        if(t.length() > s.length() ) return "";
        HashMap<Character,Integer> map = new HashMap<>();
        String subStr = s;
        for (int i = 0;i<t.length();i++){
            Character c  = t.charAt(i);
            map.put(c,map.getOrDefault(c,0) + 1);
        }

        int left = 0;
        int right = 0;

        int matched = 0;

        int minLength = s.length();

        boolean result  = false;
        //int minLength = s.length() + 1

        while( right < s.length()){
            Character c = s.charAt(right);
            if(map.containsKey(c)){
                map.replace(c, map.get(c) - 1);
                if(map.get(c) == 0) matched++;
                while(matched == map.size()){
                    result = true;
                    if(right - left + 1 < minLength){
                        minLength = right - left + 1;
                        subStr = s.substring(left,right + 1);
                    }
                    Character deleteChar = s.charAt(left);
                    if(map.containsKey(deleteChar)) {
                        map.replace(deleteChar, map.get(deleteChar) + 1);
                        if(map.get(deleteChar) > 0) matched--;
                    }
                    left++;
                }
            }
            right++;
        }
        if(!result){
            return "";
        }
        return subStr;
    }

    public static String minWindow3(String s, String t) {
        if(t.length() > s.length() ) return "";
        HashMap<Character,Integer> map = new HashMap<>();

        //iterate string t and store it hashmap
        //A - 1
        //B - 1
        //C - 1
        for (int i = 0;i<t.length();i++){
            Character c  = t.charAt(i);
            map.put(c,map.getOrDefault(c,0) + 1);
        }

        int left = 0;
        int right = 0;

        //Instead of re-seeing the hashmap for every character for it's current state, we use this
        //matched variable to keep track of its state.
        int matched = 0;

        // you can use the minLength variable to know if it was ever modified or not by making some
        // other value that is not possible for it to be s.length() for example you can just make it s.length() + 1
        int minLength = s.length() + 1;

        int start = 0;
        int size = map.size();

        //iterate  over s with two pointers(sliding window)
        //1. keep incrementing right and check if it's part of t if it's add it to the
        // hashmap and check if hashmap satisfies our condition(all chars in t) that all entries should be zero
        //denoting we've got all the characters we need
        //2. After hashmap condition is true, try to reduce window by increasing left pointer through this we can discard the front-of the substring
        //that didn't help us satisfy the condition for example if we want ABC in "QWQEQCSDFAB". we only need "CSDFAB" and we can remove "QWQEQ"
        // by reducing our window size from the left(increment left pointer)P
        //3. While doing all this keep checking for a minimum length substring in the current window

        while( right < s.length()){
            Character c = s.charAt(right);
            if(map.get(c) != null){
                map.replace(c, map.get(c) - 1);
                if(map.get(c) == 0) matched++;
                while(matched == size){
                    if(right - left + 1 < minLength){
                        minLength = right - left + 1;
                        start = left;
                    }
                    Character deleteChar = s.charAt(left++);
                    if(map.get(deleteChar)!= null) {
                        map.replace(deleteChar, map.get(deleteChar) + 1);
                        if(map.get(deleteChar) > 0) matched--;
                    }
                }
            }
            right++;
        }
        //if minlength was unchanged condition will be true, and we return
        // empty string since we didn't find any substring with all characters from t
        return  minLength > s.length() ? "" :  s.substring(start,start+minLength);
    }
    public static String minWindow4(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char x : t.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int matched = 0;
        int leftPointer = 0;
        int minLen = s.length() + 1;
        int start = 0;
        for (int rightPointer = 0; rightPointer < s.length(); rightPointer++) {
            char right = s.charAt(rightPointer);
            if (map.containsKey(right)) {
                map.put(right, map.get(right) - 1);
                if (map.get(right) == 0) matched++;
            }
            while (matched == map.size()) {
                if (minLen > rightPointer - leftPointer + 1) {
                    minLen = rightPointer - leftPointer + 1;
                    start = leftPointer;
                }
                char deleted = s.charAt(leftPointer++);
                if (map.containsKey(deleted)) {
                    if (map.get(deleted) == 0) matched--;
                    map.put(deleted, map.get(deleted) + 1);
                }
            }
        }
        return minLen > s.length() ? "" : s.substring(start, start + minLen);
    }

    private static Boolean isZero(HashMap<Character,Integer> map){
        for(Map.Entry<Character,Integer> en: map.entrySet()){
            if(en.getValue() > 0) return false;
        }
        return true;
    }
}
