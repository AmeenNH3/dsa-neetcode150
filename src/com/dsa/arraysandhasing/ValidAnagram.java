package com.dsa.arraysandhasing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static void main(String[] args) {
        ValidAnagram v = new ValidAnagram();
        System.out.println(v.isAnagram("ameen","nemea"));
    }
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] arr = new int[26];

        for(int i = 0;i<s.length();i++){
            arr[ s.charAt(i) - 97 ]++;
            arr[ t.charAt(i) - 97 ]--;
        }

        for(int i = 0;i<arr.length;i++){
            if(arr[i]  != 0) return false;
        }
        return true;
    }
//    public boolean isAnagram(String s, String t) {
//        if(s.length() != t.length()) return false;
//        HashMap<Character,Integer> map  = new HashMap<>();
//        for(int i =0;i<s.length();i++){
//            Character c = s.charAt(i);
//            if(map.containsKey(c)){
//                map.replace(c,map.get(c) + 1);
//            }
//            else{
//                map.put(c,1);
//            }
//        }
//
//        for(int i = 0;i<t.length();i++){
//                Character c = t.charAt(i);
//                if(map.containsKey(c)){
//                    map.replace(c,map.get(c) - 1);
//                }
//                else{
//                   return false;
//                }
//        }
//
//        for(Map.Entry<Character, Integer> v : map.entrySet()){
//            if(v.getValue() > 0) return false;
//        }
//
//        return true;
//
//    }
//    public boolean isAnagram(String s, String t) {
//        HashMap<Character,Integer> map  = new HashMap<>();
//        if(s.length() > t.length()){
//            addToHashMap(map,s);
//            for(int i = 0;i<t.length();i++){
//                Character c = t.charAt(i);
//                if(map.containsKey(c)){
//                    map.replace(c,map.get(c) - 1);
//                }
//                else{
//                   return false;
//                }
//            }
//        }
//        else{
//            addToHashMap(map,t);
//            for(int i = 0;i<s.length();i++){
//                Character c = s.charAt(i);
//                if(map.containsKey(c)){
//                    map.replace(c,map.get(c) - 1);
//                }
//                else{
//                    return false;
//                }
//            }
//        }
//
//        for(Map.Entry<Character, Integer> v : map.entrySet()){
//            if(v.getValue() > 0) return false;
//        }
//
//        return true;
//    }
//
//    private void addToHashMap(HashMap<Character,Integer> map, String str){
//        for(int i =0;i<str.length();i++){
//            Character c = str.charAt(i);
//            if(map.containsKey(c)){
//                map.replace(c,map.get(c) + 1);
//            }
//            else{
//                map.put(c,1);
//            }
//        }
//    }
}
