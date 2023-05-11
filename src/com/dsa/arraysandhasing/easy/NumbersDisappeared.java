package com.dsa.arraysandhasing.easy;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NumbersDisappeared {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> output = new ArrayList<>();
             for(int i = 0;i<nums.length;i++){
                 int numAtIndex = Math.abs(nums[i]);
                 nums[ numAtIndex - 1] = -1 * Math.abs( nums[numAtIndex - 1] );
             }
              for(int i = 0;i<nums.length;i++){
                 if(nums[i] >= 1) output.add(i + 1);
             }
             return output;
    }

    public static void main(String[] args) {
        findDisappearedNumbers(new int[] {4,3,2,7,8,2,3,1});
    }
}
