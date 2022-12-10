package com.dsa.slidingwindow;

import java.util.*;
import java.util.stream.Collectors;

public class LongestSubString {
    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(lengthOfLongestSubstring("aab"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
    public static int lengthOfLongestSubstring(String s) {
        //abcabcbb
        int maxLength = 0;

        Set<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        while( i< s.length()){

            while(set.contains(s.charAt(i))){
                set.remove(s.charAt(j));
                j++;
            }
            set.add(s.charAt(i));

            maxLength = Math.max(set.size(), maxLength);

            i++;
        }


        return maxLength;
    }

}
