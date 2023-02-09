package com.dsa.slidingwindow;

import java.util.*;

//class Entry implements Comparable<Entry> {
//    Integer key;
//    Integer value;
//
//    public  Entry(Integer key, Integer value){
//        this.key  = key;
//        this.value = value;
//    }
//
//    @Override
//    public int compareTo(Entry o) {
//        return o.value.compareTo(this.value);
//    }
//}
public class maxSlidingWindow {
    public static void main(String[] args) {
        System.out.println(Arrays.toString( maxSlidingWindow2(new int[]{9,10,9,-7,-4,-8,2,-6}, 5)));
   ;
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {

        int[] result = new int[nums.length - k + 1];
        PriorityQueue<Entry> queue = new PriorityQueue<>();
        int leftPointer = 0;
        int rightPointer = 0;
        int resultPointer = 0;

        while(rightPointer<k){
            queue.add(new Entry(rightPointer, nums[rightPointer++]));
        }
        if (queue.peek()!=null)
         result[resultPointer++] = queue.peek().value;

        while(rightPointer < nums.length && !queue.isEmpty() ){
            int toBeRemoved = nums[leftPointer];
            PriorityQueue<Entry> queueTemp = new PriorityQueue<>();

            while(!queue.isEmpty()) {
                Entry addToNew = queue.poll();
                if(addToNew.key != leftPointer){
                    queueTemp.add(addToNew);
                }
            }
            queue = queueTemp;
            queue.add(new Entry(rightPointer, nums[rightPointer]));
            if (!queue.isEmpty())
                result[resultPointer++] = queue.peek().value;

            rightPointer++;
            leftPointer++;
        }

        return result;
    }
    public static int[] maxSlidingWindow2(int [] nums, int k){

        int[] result = new int[nums.length - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();

        int leftPointer = 0;
        int rightPointer = 0;

        while(rightPointer<k){

            while (deque.size() != 0 && deque.getLast() < nums[rightPointer]){
                deque.removeLast();
            }
            deque.addLast(nums[rightPointer]);
            rightPointer++;
        }

        int resultIndex = 0;

        result[resultIndex++] = deque.getFirst();

        while (rightPointer < nums.length){

            if (nums[leftPointer] == deque.getFirst()){
                deque.removeFirst();
            }

            while (deque.size() != 0 && deque.getLast() < nums[rightPointer]){
                deque.removeLast();
            }

            deque.addLast(nums[rightPointer]);

            result[resultIndex++] = deque.getFirst();

            leftPointer++;
            rightPointer++;
        }


        return result;
    }
}


class Entry implements Comparable<Entry> {
    Integer key;
    Integer value;

    public  Entry(Integer key, Integer value){
        this.key  = key;
        this.value = value;
    }

    @Override
    public int compareTo(Entry o) {
        return o.value.compareTo(this.value);
    }
}