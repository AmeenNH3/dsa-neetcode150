package com.dsa.arraysandhasing;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {

    }
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            int reqValue = target - nums[i];
            if(map.get(reqValue) != null) return  new int[]{map.get(reqValue),i};
            else{
                map.put(nums[i],i);
            }
        }
        return new int[]{0,0};
    }
}
