package com.dsa.interview;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairsDivisibleByK {
    public static void main(String[] args) {

        System.out.println(getOrderedPairsDivisibleByK(new Integer[]{1,3,4},3));
        System.out.println(getOrderedPairsDivisibleByK(new Integer[]{2,3,4,1,2,3},3 ));
        System.out.println(getOrderedPairsDivisibleByK(new Integer[]{8,10,2,5,9,6,3,8,2},6 ));

    }
    public static int getOrderedPairsDivisibleByK ( Integer[] arr, int k){
//        List<ArrayList<Integer>>
        int len = arr.length;
        HashMap<Integer,Integer> mapOfDivs = new HashMap<>();

        for (Integer integer : arr) {
            if (integer % k == 0) {
                mapOfDivs.put(integer, mapOfDivs.getOrDefault(integer, 0) + 1);
            }
        }

//        System.out.println(mapOfDivs);

        int result = 0;

        for(Map.Entry<Integer,Integer> en : mapOfDivs.entrySet()){
            int i = 1;
            int v = en.getValue();
            while(v>0){
                result = result + (len - i) ;
                v--;
                i++;
            }
        }
        result = result - (mapOfDivs.size()/2);
//        System.out.println(result);
        // (i * j) % 3 == 0;
        //
        return result;
    }
}
