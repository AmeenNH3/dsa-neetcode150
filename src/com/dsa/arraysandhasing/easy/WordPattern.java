package com.dsa.arraysandhasing.easy;

import java.util.HashMap;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] strs = s.split(" ");
        Character[] ptr =  toCharacterArray(pattern);
        if(strs.length != ptr.length) return false;
        HashMap<String,Character> mapStringToPattern = new HashMap<>();
        HashMap<Character,String> mapPatternToString = new HashMap<>();
        for(int i = 0;i<ptr.length;i++){
            Character patternChar = ptr[i];
            String substr = strs[i];
            if(mapStringToPattern.get(substr) == null){
                if(mapPatternToString.get(patternChar) == null){
                    mapStringToPattern.put(substr,patternChar);
                    mapPatternToString.put(patternChar,substr);
                }
                else {
                    return false;
                }
            }
            else{
                if(mapStringToPattern.get(substr) != patternChar) return false;
            }

        }

        return true;
    }
    public Character[] toCharacterArray( String s ) {

        if ( s == null ) {
            return null;
        }

        int len = s.length();
        Character[] array = new Character[len];
        for (int i = 0; i < len ; i++) {
            array[i] = s.charAt(i);
        }

        return array;
    }
}
