package com.dsa.slidingwindow;

import java.util.HashMap;

public class PermutationInString {
    public static void main(String[] args) {

        System.out.println( checkInclusion2("cat","attractive"));
    }
    public static boolean checkInclusion(String s1, String s2) {

        HashMap<Character,Integer> map_s1 = new HashMap<>();

        for(int i = 0 ;i<s1.length();i++){
            map_s1.put(s1.charAt(i), map_s1.getOrDefault(s1.charAt(i),0) + 1);
        }

        HashMap<Character,Integer> map_s2 = new HashMap<>();
        int s2Count = 0;
        int startPointer = 0;
        for(int i = 0; i<s2.length();i++){

            map_s2.put(s2.charAt(i), map_s2.getOrDefault(s2.charAt(i),0) + 1);
            s2Count++;

            if(s2Count == s1.length()){
                if(map_s1.equals(map_s2)) return true;
                else{
                    map_s2.replace(s2.charAt(startPointer), map_s2.get(s2.charAt(startPointer)) - 1);
                    if(map_s2.get(s2.charAt( startPointer )) <= 0){
                        map_s2.remove(s2.charAt(startPointer));
                    }
                    s2Count--;
                    startPointer++;
                }

            }

        }


        return false;
    }

    public static boolean checkInclusion2(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        if (len1 > len2) return  false;

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for(int i = 0;i<len1;i++){
            arr1[s1.charAt(i) - 'a']++;
            arr2[s2.charAt(i) - 'a']++;
        }

        int windowStart = 0;
        int windowEnd = len1;

        while(windowEnd < len2){
            if(doesMatch(arr1,arr2)) return  true;

            arr2[s2.charAt(windowStart) - 'a']--;
            arr2[s2.charAt(windowEnd) - 'a']++;

            windowStart++;
            windowEnd++;
        }
        return doesMatch(arr1, arr2);
    }

    public static boolean doesMatch(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}
