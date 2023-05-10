package com.dsa.arraysandhasing.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementOne {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] result = new int[nums1.length];
        int k = 0;
            for(int i = 0;i<nums1.length;i++){

                int j = 0;
                while(nums2[j] != nums1[i]) j++;

                while(j < nums2.length){

                    if(j == nums2.length - 1){
                        if(nums2[j] > nums1[i])
                            result[k++] = nums2[j];
                        else
                            result[k++] = -1;
                    }
                    else if (nums2[j] > nums1[i]) {
                        result[k++] = nums2[j];
                    }

                    j++;
                }

            }
            return result;
    }
    public int[] nextGreaterElement2(int[] nums1,int[] nums2){
        int[] result = new int[nums1.length];
        Arrays.fill(result, -1);
        HashMap<Integer,Integer> map = new HashMap<>();

        Stack<Integer> stack = new Stack<>();

        for(int i = 0;i<nums1.length;i++){
            map.put(nums1[i],i);
        }
        for (Integer val : nums2) {
            while (!stack.isEmpty() && stack.peek() < val) {
                Integer popped = stack.pop();
                result[map.get(popped)] = val;
            }
            if (map.get(val) != null) stack.push(val);

        }
        return result;
    }
}
