package com.dsa.arraysandhasing.medium;

import java.util.*;

public class LongestConsecutiveSeq {
    public static void main(String[] args) {

        LongestConsecutiveSeq s = new LongestConsecutiveSeq();
//        s.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1});

//        s.longestConsecutive(new int[]{3,6,7,2,15,16,1,17,18,25,28,19,5,4});
        s.longestConsecutive(new int[]{9,1,4,7,3,-1,0,5,8,-1,6});

    }

    public int longestConsecutive(int[] nums) {

        Set<Integer> setIn = new TreeSet<>();
        for(Integer in : nums) setIn.add(in);

        PriorityQueue<Integer> queue= new PriorityQueue<>(Comparator.reverseOrder());
        Integer prev = null;
        int count = 0;
        for( Integer value : setIn){
           if(prev == null){
               count++;
               prev = value;
           }
           else{
               if(value - prev == 1){
                   count++;
                   prev = value;
               }
               else{
                   queue.add(count);
                   prev = value;
                   count = 0;
               }
           }
        }
        queue.add(count);
        return  queue.isEmpty() ? 0 : queue.poll();
    }
}
