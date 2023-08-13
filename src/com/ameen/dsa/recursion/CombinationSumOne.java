package com.ameen.dsa.recursion;

import java.util.*;

public class CombinationSumOne {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2,3,6,7},7));
    }

    //Problem statement:
    //Given an array, print all combinations whose sum is equal to k
    // Array has only unique elements
    // We are allowed to pick the same element infinite number of times

    // Eg., {2,3,4} target = 7
    // [2,2,3] [3,4] Are valid combinations

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        funcV2(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }


    //using pick and skip instead of for loop
    private static void funcV1(int[]  arr, int target, int idx,
                        List<Integer> list, List<List<Integer>> result){

        /*
            Base condition will always be reached because
                1. We stop calling with the same idx if target < arr[idx], this condition prevents infinite function call
                2. And once we're at target 0 and idx < arr.length we go the next index without adding to the list or reducing target.
                    for example
                    input:    {2,3,4} target = 7
                    At one point of recursion, list will be [2,2,3] and idx = 1 target = 0
                    when we reach such a point we don't add anything to list or call recur func with same index,
                    but we go to the next idx with the same list and target like [2,2,3] idx = 2 target = 0 and so on till we reach idx = arr.length
         */


        if(idx == arr.length){
            if(target == 0) result.add(new ArrayList<>(list));
            return;
        }

        if(arr[idx] <= target){
            list.add(arr[idx]);
            funcV1(arr, target - arr[idx], idx , list,result);
            list.remove(list.size() - 1);
        }

        funcV1(arr,target,idx + 1, list,result);

    }

    private static void funcV2(int[]  arr, int target, int idx,
                        List<Integer> list, List<List<Integer>> result){
        if(target < 0) return;
        if(target == 0)
        {
            result.add(new ArrayList<>(list));
            return;
        }


        for(int i = idx ; i < arr.length ;i++){
            if(arr[i] <= target){
                list.add(arr[i]);
                funcV2(arr, target - arr[i], i , list,result);
                list.remove(list.size() - 1);
            }
        }

    }
}
