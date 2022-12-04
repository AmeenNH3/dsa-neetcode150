package com.dsa.twopointers;

import java.util.Arrays;

public class TrapRainWater {
    public static void main(String[] args) {
        System.out.println( trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    public static int trap(int[] height) {
        int len = height.length;
        int[] maxLeft = new int[len];
        int[] maxRight = new int[len];

        maxLeft[0] = 0;
        for (int i = 1; i < len; i++) {
            int value = Math.max(height[i - 1], maxLeft[i - 1]);
            maxLeft[i] = value;
        }

        maxRight[len - 1] = 0;
        for (int i = len - 2; i >= 0; i--) {
            int value = Math.max(height[i + 1], maxRight[i + 1]);
            maxRight[i] = value;
        }

        int sum = 0;
        for(int i = 0;i<len;i++){
            int value = Math.min(maxLeft[i],maxRight[i]);
            value = Math.max(value - height[i],0);
            sum += value;
        }

        return sum;

    }
}
