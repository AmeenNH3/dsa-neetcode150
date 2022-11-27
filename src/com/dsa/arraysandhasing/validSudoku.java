package com.dsa.arraysandhasing;

import java.util.Arrays;
import java.util.HashMap;

public class validSudoku {
    public static void main(String[] args) {
        char[][] arr =  {{'5','3','.','.','7','.','.','.','.'}
                        ,{'6','.','.','1','9','5','.','.','.'}
                        ,{'.','9','8','.','.','.','.','6','.'}
                        ,{'8','.','.','.','6','.','.','.','3'}
                        ,{'4','.','.','8','.','3','.','.','1'}
                        ,{'7','.','.','.','2','.','.','.','6'}
                        ,{'.','6','.','.','.','.','2','8','.'}
                        ,{'.','.','.','4','1','9','.','.','5'}
                        ,{'.','.','.','.','8','.','.','7','9'}};

        char[][] arr1 =  {{'8','3','.','.','7','.','.','.','.'}
                        ,{'6','.','.','1','9','5','.','.','.'}
                        ,{'.','9','8','.','.','.','.','6','.'}
                        ,{'8','.','.','.','6','.','.','.','3'}
                        ,{'4','.','.','8','.','3','.','.','1'}
                        ,{'7','.','.','.','2','.','.','.','6'}
                        ,{'.','6','.','.','.','.','2','8','.'}
                        ,{'.','.','.','4','1','9','.','.','5'}
                        ,{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(arr));
    }

    public static boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < board.length ;i++){
            HashMap<Character,Boolean> rowMap = new HashMap<>();
            for(int j = 0 ; j<board.length;j++){
                if(board[i][j] != '.'){
                    if(rowMap.get(board[i][j]) == null){
                        rowMap.put(board[i][j],true);
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        for(int j = 0; j < board.length ;j++){
            HashMap<Character,Boolean> colMap = new HashMap<>();
            for(int i = 0 ; i< board.length;i++){
                if(board[i][j] != '.'){
                    if(colMap.get(board[i][j]) == null){
                        colMap.put(board[i][j],true);
                    }
                    else{
                        return false;
                    }
                }

            }
        }
        int q = 0;
        int w = 0;
        for(int k = 0; k<9;k++) {
          HashMap<Character,Boolean> map = new HashMap<>();
          int i = q;
          int j = w;
          for (i = q; i < q + 3; i++) {
              for (j = w; j < w + 3; j++) {
                  if(board[i][j] != '.'){
                      if(map.get(board[i][j]) == null){
                          map.put(board[i][j],true);
                      }
                      else{
                          return false;
                      }
                  }
              }
          }

          w = w + 3;
          if(w == board.length){
              w = 0;
              q = q + 3;
          }

      }
        return true;
    }
}
