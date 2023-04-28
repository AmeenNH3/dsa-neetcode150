package com.dsa.arraysandhasing.medium;

import java.util.*;

class Store {
    Integer key;
    Integer count;
    public Store(Integer key, Integer count) {
        this.key = key;
        this.count = count;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
public class TopKFrequentElements {
    public static void main(String[] args) {

        //Brute force solution o(nlogn)
        System.out.println(Arrays.toString(topKFrequent(new int[]{2, 3, 3, 1, 1, 1, 5, 5, 7, 7, 1, 1, 4, 4}, 2)));
        //o(klogn) solution
        System.out.println(Arrays.toString(topKFrequentV2(new int[]{2, 3, 3, 1, 1, 1, 5, 5, 7, 7, 1, 1, 4, 4}, 2)));
        //o(n)
        System.out.println(Arrays.toString(topKFrequentV3(new int[]{-1,-1}, 1)));

    }
    public static int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer,Integer> map = new HashMap<>();
        for(Integer i : nums){
            if(map.get(i) !=null){
                map.replace(i,map.get(i) + 1);
            }
            else{
                map.put(i,1);
            }
        }

        List<Store> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> en : map.entrySet()){
            list.add( new Store(en.getKey(),en.getValue()));
        }//n
        Comparator<Store> cm = (a,b) -> {
            if(a.getCount() == b.getCount()) return a.getKey().compareTo(b.getKey());
            else return a.getCount().compareTo(b.getCount());
        };

        list.sort(cm);

        int size = list.size() - 1;
        int[] result = new int[k];
        for(int i = 0 ; i<k ;i++){
            result[i] = list.get(size).getKey();
            size--;
        }
        return result;
    }

    public static int[] topKFrequentV2(int[] nums,int k){

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int key : nums) {
           map.put(key,map.getOrDefault(key,0) + 1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>( (a, b) -> b.getValue() - a.getValue());

        queue.addAll(map.entrySet());

        System.out.println(queue);
        int[] res = new int[k];
        int i = 0;
        while(!queue.isEmpty()){
            res[i++] = queue.poll().getKey();
            if(i == k) break;
        }
        return res;
    }

    public static int[] topKFrequentV3(int[] nums,int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int key : nums) {
            map.put(key,map.getOrDefault(key,0) + 1);
        }
        ArrayList<ArrayList<Integer>> bucket = new ArrayList<>();
        for(int i = 0 ; i<= map.size() + 1;i++){
            bucket.add(new ArrayList<>());
        }

        for( Map.Entry<Integer,Integer> en : map.entrySet()){
            bucket.get(en.getValue()).add(en.getKey());
        }

        int i = 0;
        int[] res = new int[k];

        for(int y = bucket.size() - 1 ; y>=0 ;y--){
            ArrayList<Integer> list = bucket.get(y);
            if(list.size() > 0){
                for( Integer z : list){
                    if(i < k){
                        res[i++] = z;
                    }
                }
            }
        }
        return res;
    }


}
