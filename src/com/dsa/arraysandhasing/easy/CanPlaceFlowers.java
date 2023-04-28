package com.dsa.arraysandhasing.easy;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        if(n == 0) return true;
        if(n == 1 && len == 1 ) return (flowerbed[0] == 0);
        if( n > (len/2 + 1)) return false;
        for(int i = 0;i<len;i++){
            if(n <= 0) return true;
            if(flowerbed[i] == 1) continue;
            else {
                if(i - 1 < 0){
                    if(flowerbed[i+1] == 0){
                        flowerbed[i] = 1;
                        n--;
                    }
                }
                else if(i + 1 >= len){
                    if(flowerbed[i-1] == 0){
                        flowerbed[i] = 1;
                        n--;
                    }
                }
                else if(flowerbed[i - 1] == 0 && flowerbed[i+1] == 0){
                    flowerbed[i] = 1;
                    n--;
                }
            }
        }

        return n <= 0;
    }

    //Same logic but an improved and elegent solution.
    public boolean canPlaceFlowersV2(int[] flowerbed, int n) {
        int len = flowerbed.length;
        if(n == 0) return true;
        for(int i = 0;i<len;i++){
            if(flowerbed[i] == 0 && (i == 0 || flowerbed[i-1] == 0) && ( i == len - 1  || flowerbed[i+1] == 0 )) {
                flowerbed[i] = 1;
                n--;
            }
            if(n == 0) return true;
        }
        return false;
    }
}
