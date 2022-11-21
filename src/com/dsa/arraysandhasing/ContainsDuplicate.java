package com.dsa.arraysandhasing;

import java.util.HashMap;

public class ContainsDuplicate {
    public static void main(String[] args) {
        ContainsDuplicate c = new ContainsDuplicate();
        boolean result = c.containsDuplicate(new int[]{1, 2, 2, 3, 4, 5, 5});
        System.out.println(result);
    }


    public boolean containsDuplicate(int[] nums){
        if (nums.length <= 1) return false;

        //Brute Force
        //Sorting the array and iterating and counting the elements will take O(nlogn + n)
        //Current Solution
        //Iterating the array and storing them in hashmap simultaneously looking for duplicates will only take o(n)
        HashMap<Integer,Integer> map = new HashMap<>();

        for(Integer a : nums){
            if(map.containsKey(a)){
                map.replace(a,1 + map.get(a));
                if(map.get(a) > 1) return true;
            }
            else{
                map.put(a,1);
            }
        }
        return false;
    }
}