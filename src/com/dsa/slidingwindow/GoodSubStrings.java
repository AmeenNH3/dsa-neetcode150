package com.dsa.slidingwindow;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GoodSubStrings {
    public static void main(String[] args) {



    }

    public int countGoodSubstrings(String s) {
        // we do this using hashmap but it's not needed and prefer using arr whenever possible. 3ms vs 1ms
        int[] arr = new int[26];

        int left = 0;
        int right = 0;
        int unique = 0;
        int result = 0;


        while (right < 3) {
            int c = s.charAt(right++) - 'a';
            arr[c]++;
            if (arr[c] == 1) unique++;
            else if (arr[c] > 1) unique--;
        }
        if (unique == 3) result++;

        while (right < s.length()) {
            int del = s.charAt(left) - 'a';
            if(arr[del] == 1) unique--;
            arr[del]--;
            if(arr[del] == 1) unique++;
            int c = s.charAt(right) - 'a';

            arr[c]++;

            if(arr[c] == 1) unique++;
            else if(arr[c] > 1 && unique>0) unique--;

            if (unique == 3) result++;

            right++;
            left++;
        }

        return result;
    }

}
