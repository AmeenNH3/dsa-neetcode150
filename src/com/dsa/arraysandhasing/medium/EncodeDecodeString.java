package com.dsa.arraysandhasing.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecodeString {
    public static void main(String[] args) {

//       String str =  encode(Arrays.asList("lint","code","love","you"));
       String str =  encode(Arrays.asList("","","",""));
        List<String> out = decode(str);
        System.out.println(out);
    }
    public static String encode(List<String> strs) {
        StringBuilder stringBuilder = new StringBuilder();
        for(String str:strs){
            stringBuilder.append(str).append(":;");
        }
        return stringBuilder.toString();

    }

    public static List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        String[] c = str.split(":;");
        return Arrays.asList(c);
    }
}
