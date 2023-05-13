package com.dsa.arraysandhasing.easy;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Entry{
    int key;
    int value;
    public Entry(int key,int value){
        this.key= key;
        this.value = value;
    }
}
public class MyHashMap {

    LinkedList<Entry>[] map;
    public static int SIZE = 1268;

    MyHashMap(){
        map = new LinkedList[SIZE];
    }
    public  void put (int key, int value){
        int bucketIndex = key % SIZE;
        if(map[bucketIndex] == null){
            LinkedList<Entry> entries = new LinkedList<>();
            entries.add(new Entry(key,value));
            map[bucketIndex] = entries;
        }
        else{
            LinkedList<Entry> entries = map[bucketIndex];
            for(Entry entry : entries){
                if(entry.key == key){
                    entry.value = value;
                    return;
                }
            }

            entries.add(new Entry(key,value));

        }
    }
    public int get(int key){
        int bucketIndex = key % SIZE;
        LinkedList<Entry> entries = map[bucketIndex];
        if(entries != null){
            for(Entry en: entries){
                if(key == en.key) return en.value;
            }
        }

        return -1;
    }
    public void remove(int key){
        int bucketIndex = key % SIZE;
        LinkedList<Entry> entries = map[bucketIndex];
        if(entries != null)
            entries.removeIf(en -> key == en.key);
    }

    public void printHashMap(){
        Arrays.stream(this.map).forEach( c -> c.forEach(entry -> {
            System.out.println("Key :" + entry.key + " Value :" + entry.value);
        }));
    }


//    public static void main(String[] args) {
//        LinkedList<Entry>[] newMap = new LinkedList[4];
//        newMap[0] = new LinkedList<>(List.of(new Entry(10,12), new Entry(10,12),new Entry(10,12)));
//
//        newMap[1] = new LinkedList<>(List.of(new Entry(11,12), new Entry(11,12),new Entry(11,12)));
//        newMap[2] = new LinkedList<>(List.of(new Entry(12,12), new Entry(12,12),new Entry(12,12)));
//        newMap[3] = new LinkedList<>(List.of(new Entry(13,12), new Entry(13,12),new Entry(13,12)));
//
//        Arrays.stream(newMap).forEach( c -> c.forEach(entry -> {
//            System.out.println("Key :" + entry.key + " Value :" + entry.value);
//        }));
//    }

}
