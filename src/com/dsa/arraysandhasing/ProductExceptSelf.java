package com.dsa.arraysandhasing;

public class ProductExceptSelf {
    public static void main(String[] args) {
        productExceptSelf(new int[] { 3,4,5,6});
    }
    public static int[] productExceptSelf(int[] nums) {

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        int i = 0;
        int j = nums.length - 1;
        left[i] =  1;
        right[j] = 1;

        i++;
        j--;
        while(i < nums.length && j>=0){

            left[i] = left[i-1] * nums[i - 1];
            right[j] = right[j+1] * nums[j + 1];
            i++;
            j--;
        }

        int[] res = new int[nums.length];
        for(int k = 0;k<res.length;k++){
            res[k] = left[k] * right[k];
        }
        return res;
    }

}
