package com.dsa.arraysandhasing;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        majorityElementV2(new int[]{5,1,5,1,5,1,5});
    }
    public static int majorityElement(int[] nums) {
        if(nums.length == 0) return 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }
        int count = 0;
        int max = nums[0];
        for(Map.Entry<Integer,Integer> en: map.entrySet()){
            if(en.getValue() >= count){
                max = en.getKey();
                count = en.getValue();
            }

        }
        return max;
    }
    public static int majorityElementV2(int[] nums){
        int res = 0, count = 0;
        //this solution works because of the assumption, that there will always be a majority element in the array.
        for(int i = 0;i<nums.length;i++){
            if(count == 0) res = nums[i];
            if(nums[i] == res)
                count++;
            else
                count--;
        }
        return res;
    }
}
