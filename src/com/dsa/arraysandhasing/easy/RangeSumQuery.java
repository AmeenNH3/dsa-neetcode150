package com.dsa.arraysandhasing.easy;

public class RangeSumQuery {

    //Instead of recalculating everytime we need a sum range. We can have right and left sum of the array prepared as the array is not dynamic and
    // we can calculate the sum in range using those left and right sum arrays.
    //Here we don't need right sum array too, since if we know the total sum and left sum we can determine the right sum
    private static class NumArray {
        private int totalSum = 0;
        private int[] nums = null;
        private int[] leftSum = null;
        public NumArray(int[] nums) {
            this.nums = nums;
            this.leftSum = new int[nums.length];
            this.calculateSums();
        }
        public int sumRange(int left, int right) {
            return totalSum - leftSum[left] - ( totalSum - leftSum[right] - nums[right]);
        }
        private void calculateSums(){
            int i = 0;
            while( i < this.nums.length){
                this.totalSum += nums[i];
                if(i == 0) this.leftSum[i] = 0;
                else{
                    this.leftSum[i] = this.leftSum[i - 1] + this.nums[i - 1];
                }
                i++;
            }
        }
    }

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{1,2,3,4,5});
        System.out.println(numArray.sumRange(1,6));
        System.out.println(numArray.sumRange(1,6));

    }
}
