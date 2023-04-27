package com.dsa.arraysandhasing;

import java.util.HashMap;

public class IsomorphicStrings {
    public static void main(String[] args) {

    }
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character,Character> sourceToD = new HashMap<>();
        HashMap<Character,Character> dToSource = new HashMap<>();
        for (int i = 0;i<s.length();i++){
            Character c1 = s.charAt(i), c2 = t.charAt(i);
            Character cr1 = sourceToD.getOrDefault(c1, c2);
            if(cr1 !=  c2) return false;
            sourceToD.put(c1,c2);
            Character cr2 = dToSource.getOrDefault(c2,c1);
            if(cr2 != c1) return false;
            dToSource.put(c2,c1);
        }
        return true;
    }

}
