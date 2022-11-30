package com.dsa.twopointers;

public class ContainerWithMostWater {
    public static void main(String[] args) {

//        Input: height = [1,8,6,2,5,4,8,3,7]
//        Output: 49
//        Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
//        In this case, the max area of water (blue section) the container can contain is 49.
        maxArea(new int[]{1,8,6,2,5,4,8,3,7});
    }
    public static int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = Integer.MIN_VALUE;
        while(i<j){
            int min = Math.min(height[i],height[j]);
            int res = min * (j - i) ;
            if(height[i] < height[j]) i++;
            else j--;
            if(res > max) max = res;
        }
        return max;
    }
}
