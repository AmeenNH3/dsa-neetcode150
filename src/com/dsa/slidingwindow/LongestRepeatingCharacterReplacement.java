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
        while( right < s.length()){
            Character c = s.charAt(right);
            countsMap.put(c,countsMap.getOrDefault(c,0) + 1);
            if(countsMap.get(c) > maxCount) {
                maxCount = countsMap.get(c);
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
    public static int characterReplacement2(String s, int k) {
        int len = s.length();
        int[] charCounts = new int[26];
        int leftPointer = 0;
        int maxLength = 0;
        int maxCount = 0;
        //"ABABBACC", 1
        for(int rightPointer = 0; rightPointer < len ; rightPointer++){
            int currentCharCount =  charCounts[s.charAt(rightPointer) - 'A']++;
            maxCount =  Math.max(currentCharCount,maxCount);
            //3 - 0 - 2 = 1
            // Length of the window will always be +1 to rightPointer - leftPointer because we start from 0th
            //index so for a string say "AMEEN" length is 5, but when you use zero index it will be 4
            // coz 4(rightPointer) - 0(leftPointer) => 4 which is incorrect and the length is actually 5
            int windowLength = rightPointer - leftPointer + 1;
            if(windowLength - maxCount  > k){
                charCounts[s.charAt(leftPointer) - 'A']--;
                leftPointer++;
            }

            maxLength = Math.max(maxLength , windowLength);


        }

        return maxLength;
    }

}
