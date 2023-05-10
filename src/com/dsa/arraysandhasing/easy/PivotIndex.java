package com.dsa.arraysandhasing.easy;

public class PivotIndex {
    //If we know the left sum of an array at an index and total sum of the array ->
    // we can find out the right sum x + y = total;    total - x = y ;
    // Once we have the right Sum and left Sum we can just return the index where Right Sum and Left Sum are equal

    public int pivotIndex(int[] nums) {
        int sum = 0;
        for(int i = 0; i< nums.length ;i++)
            sum += nums[i];
        int leftSum = 0;
        for(int i = 0;i<nums.length;i++){
            if(i > 0) leftSum = leftSum + nums[i - 1];
            if(leftSum == (sum - nums[i] - leftSum)) return i;
        }
        return -1;
    }
}
