package com.dsa.slidingwindow;

import java.util.HashMap;

public class PermutationInString {
    public static void main(String[] args) {
        System.out.println( checkInclusion("abb","eidbbaooo"));
        System.out.println( checkInclusion("abb","eidbboaooo"));
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
}
