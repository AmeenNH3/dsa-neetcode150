package com.ameen.dsa.recursion;

import  java.util.*;
public class CombinationSumTwo {
    public static void main(String[] args) {
        System.out.println(
        combinationSum2(new int[]{10,1,2,7,6,1,5},8 )
        );
    }


    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        func(candidates,target,0,new ArrayList<>(), result);
        return result;
    }



    private static void func2(int[] arr, int target, int idx, List<Integer> list,
                      List<List<Integer>> result){
        if(idx >= arr.length){
            if(target == 0){
                result.add(new ArrayList<>(list));
            }
            return;
        }
        if(arr[idx] <= target){
            list.add(arr[idx]);
            func2(arr, target - arr[idx], idx + 1, list,result);
            list.remove(list.size() - 1);
        }
        if(list.size() > 0 && list.get(list.size() - 1) == arr[idx]){
            return;
        }
        func2(arr,target, idx + 1, list, result);
    }
    private  static void func(int[] arr, int target, int idx,
                      List<Integer> list, List<List<Integer>> result){
        if(target < 0) return;
        if(target == 0){
            result.add(new ArrayList(list));
            return;
        }

        for(int i = idx; i< arr.length;i++){
            if(i > idx && arr[i] == arr[i - 1]) continue;
            if(arr[i] > target) break;
            list.add(arr[i]);
            func(arr,target - arr[i], i + 1, list,result);
            list.remove(list.size()- 1);
        }
    }
}
