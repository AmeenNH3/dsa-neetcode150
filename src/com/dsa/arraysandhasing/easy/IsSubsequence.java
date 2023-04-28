package com.dsa.arraysandhasing.easy;

public class IsSubsequence {
    public static void main(String[] args) {

        System.out.println(isSubsequence("abc","ahbgdc"));
    }

//    Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
//    A subsequence of a string is a new string
//    that is formed from the original string by deleting some (can be none)
//    of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

    public static boolean isSubsequence(String s, String t){
        int i = 0;
        int j = 0;
        int match = s.length();
        while(j < t.length()){

            if(s.charAt(i) ==  t.charAt(j)){
                i++;
                match--;
            }
            if(match == 0) return true;

            j++;
        }


        return match == 0;
    }
}
