package com.dsa.arraysandhasing;

public class RemoveElement {
    public static void main(String[] args) {


    }

    public int removeElement(int[] nums, int val) {

        int i = 0;
        int boundary = nums.length - 1; //

        while(i <= boundary){
            if(nums[i] == val){
                int temp = nums[i];
                nums[i] = nums[boundary];
                nums[boundary] = temp;

                boundary--;
            }
            else{
                i++;
            }
        }

        return boundary+1; // return i will also work
    }
}
