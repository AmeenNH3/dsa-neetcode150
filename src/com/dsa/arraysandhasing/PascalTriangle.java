package com.dsa.arraysandhasing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }
    public static List<List<Integer>> generate(int numRows) {

        if(numRows == 0) return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> rowOne = List.of(1);
        result.add(rowOne);

        for(int i  = 1; i< numRows;i++){
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = result.get(i - 1);
            for(int j  = 0;j <=i; j++){
                if(j - 1 < 0 || j + 1 > prevRow.size()  - 1) row.add(1);
                else{
                    row.add(prevRow.get(j-1) + prevRow.get(j));
                }
            }
            result.add(row);
        }

        return result;
    }
}
