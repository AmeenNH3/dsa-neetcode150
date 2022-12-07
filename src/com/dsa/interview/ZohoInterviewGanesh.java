package com.dsa.interview;

import java.util.*;

public class ZohoInterviewGanesh {
    public static void main(String[] args) {
        Integer[] arr1 = fillArray();
        Integer[] arr2 =  fillArray();
        interviewQuestion(arr1,arr2);
        interviewQuestion2(arr1,arr2);
    }
    public static Integer[] fillArray(){
        Integer[] out = new Integer[1000];
        for(int i = 0;i<out.length;i++){
            out[i] = (int) Math.floor( Math.random() * 1000);
        }
        return  out;
    }
    public static int[] interviewQuestion(Integer[] arr1, Integer[] arr2){
        long startTime = System.nanoTime();
        List<Integer> resultList  = new ArrayList<Integer>();
        Set<Integer> set1 = new HashSet<>(Arrays.asList(arr1));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(arr2));
        HashMap<Integer,Integer> map = new HashMap<>();
        set1.forEach(e -> map.put(e, map.getOrDefault(e,0) + 1 ));
        set2.forEach(e -> map.put(e, map.getOrDefault(e,0) + 1 ));
        map.entrySet().stream().filter(e -> e.getValue() == 1).forEach(e -> resultList.add(e.getKey()));
        System.out.println(resultList);
        long duration = (System.nanoTime() - startTime)/1000000;
        System.out.println("Running time of a program 1 " + duration + "ms");
        return new int[]{};
    }
    public static int[] interviewQuestion2(Integer[] arr1, Integer[] arr2) {
        long startTime = System.nanoTime();
        final List<Integer> list1 = new ArrayList<>(Arrays.asList(arr1));
        final Set<Integer> set1 = new HashSet<>(list1);
        final List<Integer> list2 = new ArrayList<>(Arrays.asList(arr2));
        final Set<Integer> set2 = new HashSet<>(list2);
        set1.retainAll(set2);
        list1.removeAll(set1);
        list2.removeAll(set1);
        list1.addAll(list2);
        System.out.println(new HashSet<>(list1));
        long duration = (System.nanoTime() - startTime)/1000000;
        System.out.println("Running time of a program 2 " + duration + "ms");
        return new int[]{};
    }
}
