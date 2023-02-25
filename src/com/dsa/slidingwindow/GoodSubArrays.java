package com.dsa.slidingwindow;

import java.util.HashMap;

public class GoodSubArrays {
    public static void main(String[] args) {
//        System.out.println(
//                countGood(new int[] {3,1,4,3,2,2,4},2)
//        );
        System.out.println(
                countGood(new int[] {2,1,3,1,2,2,3,3,3},2)
        );
    }
    public static long countGood(int[] nums, int k) {
        HashMap<Integer,Integer> map  = new HashMap();

        int left = 0;
        int right = 0;

        int result = 0;

        long currentPairs = 0;

        while(right< nums.length){
            if(currentPairs >= k) result++;
            currentPairs = currentPairs - pairs(map.getOrDefault(nums[right], 0 ));
            map.put(nums[right], map.getOrDefault(nums[right],0) + 1);
            currentPairs = currentPairs + pairs(map.getOrDefault(nums[right], 0 ));
            right++;
        }


        while(left < right && currentPairs >= k){
                result++;
                currentPairs = currentPairs - pairs(map.getOrDefault(nums[left], 0 ));
                map.replace(nums[left], map.getOrDefault(nums[left],0) - 1);
                currentPairs = currentPairs + pairs(map.getOrDefault(nums[left], 0 ));

                left++;
            }





        return result;
    }
    public static long pairs(int n){
        if (n == 0 )return 0;
        return (n * (n-1))/2;
    }
}
