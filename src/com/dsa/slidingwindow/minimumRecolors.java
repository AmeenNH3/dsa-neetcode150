package com.dsa.slidingwindow;

public class minimumRecolors {
    public static void main(String[] args) {
        System.out.println( minimumRecolors("WBBWWBBWBW",7));
    }
    public static int minimumRecolors(String blocks, int k) {

        int whiteCount = 0;
        int left = 0;
        int right = 0;
        int minRecolorsNeeded =  blocks.length();
        while (right < k){
            if(blocks.charAt(right++) == 'W') whiteCount++;
        }
        minRecolorsNeeded = whiteCount;
        while(right < blocks.length()){
            if(blocks.charAt(left++) == 'W') whiteCount--;
            if(blocks.charAt(right++) == 'W') whiteCount++;
            if (whiteCount < minRecolorsNeeded) minRecolorsNeeded = whiteCount;

        }
        return minRecolorsNeeded;
    }
}
