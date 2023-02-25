package com.dsa.interview;

import java.util.ArrayList;

public class NearestGreaterNumber {
    public static void main(String[] args) {
        //
        int[] arr = new int[]{4,12,7,9,1,25};
        int[] arr1 = new int[]{28, 8, 6, 11, 35, 22, 2, 1, 9, 38};
        int[] arr2 = new int[]{33, 23, 11, 13, 33, 18, 24, 32, 39, 0};
        int[] arr3 = new int[]{29, 38, 19, 32, 2, 28, 33, 23, 33, 32};

        System.out.println(
                nearestGreater(arr)
        );
        System.out.println(
                nearestGreater(arr1)
        );
        System.out.println(
                nearestGreater(arr2)
        );
        System.out.println(
                nearestGreater(arr3)
        );
    }

        //Brute Force Solution
    public static ArrayList<ArrayList<Integer>> nearestGreater(int[] arr){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int i= 0;i<arr.length;i++){

            int nearestGreater = Integer.MAX_VALUE; //80182239812038
            for(int j = i+1;j<arr.length;j++){
                if( arr[j] > arr[i] && arr[j] < nearestGreater){
                  nearestGreater = arr[j];
                }
            }


            ArrayList<Integer> tempRes = new ArrayList<>();
            if(arr[i]!=nearestGreater && nearestGreater != Integer.MAX_VALUE){
                tempRes.add(arr[i]);
                tempRes.add(nearestGreater);
                res.add(tempRes);
            }




        }
        return res;

    }
}
