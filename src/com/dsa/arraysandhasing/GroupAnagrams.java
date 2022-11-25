package com.dsa.arraysandhasing;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        GroupAnagrams gp = new GroupAnagrams();
        gp.groupAnagrams(new String[] {"eat","ate","ate","tea","tan","ant","eat","","boot","ootb","khan"});
    }
    public  List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();

      for (String s : strs) {
          char[] arr = new  char[26];
          for( char c : s.toCharArray()){
              arr[c - 'a']++;
          }

          String key = new String(arr);

          map.computeIfAbsent(key, a -> new ArrayList<>());
          map.get(key).add(s);

      }
        return new ArrayList<>(map.values());
    }

    }

