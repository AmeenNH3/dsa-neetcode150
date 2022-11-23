package com.dsa.arraysandhasing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {
        GroupAnagrams gp  = new GroupAnagrams();

        gp.groupAnagrams(new String[] {"eat","ate","ate","tea","tan","ant","eat","","boot","ootb","khan"});

    }
    public  List<List<String>> groupAnagrams(String[] strs) {

//        Arrays.sort(strs);
        List<List<String>> result = new ArrayList<>();
        HashMap<String,Boolean> included = new HashMap<>();
        for(int i =0;i<strs.length;i++){
            String str  = strs[i];
            if(included.get(str + "" + i) != null){
                //do nothing and go to the next element(i++)
            }
            else{
                List<String> temp = new ArrayList<>();
                temp.add(str);
                included.put(str + "" + i,true);
                for(int j = i + 1 ; j< strs.length; j++){
                    String str2 = strs[j];
                    if(included.get(str2 + "" + j) != null){
                        //do nothing and go to the next element(j++)
                    }
                    else{
                        if(isAnagram(str,str2)){
                            temp.add(str2);
                            included.put(str2 + "" + j,true);
                        }
                    }
                }
                result.add(temp);
            }

        }
        return result;
    }

    private  boolean isAnagram(String str1,String str2){
        if(str1.length() != str2.length()) return false;
        int[] arr = new int[26];
        for(int i =0;i<str1.length();i++){
            arr[str1.charAt(i) - 97]++;
            arr[str2.charAt(i) - 97]--;
        }

        for(Integer i : arr) if(i!=0) return false;

        return true;

    }
}
