package com.dsa.arraysandhasing;

public class LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
    }

    public static int lengthOfLastWord(String s) {
        int result = 0;


        int n = s.length() - 1;

        while(n >= 0){

            if(s.charAt(n) != ' '){

                while ( n >=0 && s.charAt(n) != ' ') {
                    n--;
                    result++;
                }


                return result;

            }


            n--;
        }

        return result;
    }
}
