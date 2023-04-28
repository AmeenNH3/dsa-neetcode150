package com.dsa.arraysandhasing.easy;

public class LongestCommonPrefix {
    public static void main(String[] args) {

        longestCommonPrefixV2(new String[]{"flower","f","fli"});
    }

    public static String longestCommonPrefix(String[] strs) {


        String result = "";
        int i = 0;
        int lengthOftheShortestString = Integer.MAX_VALUE;

        for(int k = 0 ; k < strs.length;k++){
            if(strs[k].length() < lengthOftheShortestString){
                lengthOftheShortestString = strs[k].length();
            }
        }


        while(i< lengthOftheShortestString){
            Character same = strs[0].charAt(i);
            for(int k = 1 ; k< strs.length ;k++){

                if(strs[k].charAt(i) != same) return result;

            }

            result  = result + same;
            i++;

        }


        return result;

    }
    public static String longestCommonPrefixV2(String[] strs) {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < strs[0].length(); i++) {
            for(String s: strs)
                if(i == s.length() || s.charAt(i) != strs[0].charAt(i))
                    return res.toString();
            res.append(strs[0].charAt(i));
        }
        return res.toString();
    }
}
