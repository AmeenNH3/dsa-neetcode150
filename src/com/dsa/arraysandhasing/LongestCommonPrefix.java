package com.dsa.arraysandhasing;

public class LongestCommonPrefix {
    public static void main(String[] args) {

        longestCommonPrefix(new String[]{"flower","flow","flight"});
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
}
