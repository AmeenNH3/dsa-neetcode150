package com.dsa.twopointers;

import java.util.Arrays;

public class TwoSumII {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[] {2,7,11,15},9)));
    }
    public static int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j){
            if(numbers[i] + numbers[j] < target)i++;
            else if (numbers[i] + numbers[j] > target)j--;
            else return new int[] {i+1 , j+1};
        }
        return new int[] {0 , 0};
    }
}
