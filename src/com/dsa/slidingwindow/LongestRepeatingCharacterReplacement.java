package com.dsa.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        System.out.println(characterReplacement("ABABBACC",2));
//        System.out.println(characterReplacement("ABAABBBBBBBBBBBBB",1));
//        System.out.println(characterReplacement("ABBABBBBBBBBBBBBB",1));
//        System.out.println(characterReplacement("ZXZXZXZXZXZXZXZXZXABCDEFIHIIGKLN",1));
    }
    public static int characterReplacement(String s, int k) {

        int result = 0;
        int left = 0;
        int right = 0;

        HashMap<Character,Integer> countsMap = new HashMap<>();
        int maxCount = 0;
        char maxChar;

        while( right < s.length()){

            Character c = s.charAt(right);

            countsMap.put(c,countsMap.getOrDefault(c,0) + 1);
            if(countsMap.get(c) > maxCount) {
                maxCount = countsMap.get(c);
                maxChar = c;
            }


            if(right - left - maxCount <= k){
                if(right -left > result) result = right - left;
                right++;
            }else{
                left++;

            }

        }

        System.out.println(countsMap);
        return 0;
    }


}
