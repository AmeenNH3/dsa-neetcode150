package com.dsa.twopointers;

public class ValidPalindrome {
    public static void main(String[] args) {
        boolean palindrome = isPalindrome("A man, a plan, a canal: Panama A man, a plan, a canal: Panama A man, a plan, a canal: Panama A man, a plan, a canal: Panama A man, a plan, a canal: Panama A man, a plan, a canal: Panama A man, a plan, a canal: Panama");
        boolean palindrome1 = isPalindromeV2("A man, a plan, a canal: Panama A man, a plan, a canal: Panama A man, a plan, a canal: Panama A man, a plan, a canal: Panama A man, a plan, a canal: Panama A man, a plan, a canal: Panama A man, a plan, a canal: Panama");
    }
    public static boolean isPalindrome(String s) {
        System.out.println("Palindrome  v1 ");
        long startTime = System.nanoTime();
        int len = s.length();
        if(len <= 1) return true;

        String str = s.toLowerCase();
        StringBuilder newStr = new StringBuilder();

        for(int i = 0 ;i <len;i++){
            char c = str.charAt(i);
            if(Character.isLetter(c) || Character.isDigit(c)) newStr.append(c);
        }

        int i = 0;
        int j = newStr.length() - 1;

        while (i<j){
            char c1 = newStr.charAt(i);
            char c2 = newStr.charAt(j);
            if(c1 != c2) return false;
            i++;
            j--;
        }
        long duration = (System.nanoTime() - startTime);
        System.out.println("Running time of a program " + duration + "ns");
        return true;
    }
    public static boolean isPalindromeV2(String s) {
        System.out.println("Palindrome  v2 ");

        long startTime = System.nanoTime();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {

            char start = s.charAt(i);
            char end = s.charAt(j);

            if (!Character.isLetterOrDigit(start)) {
                i++;
                continue;
            }

            if (!Character.isLetterOrDigit(end)) {
                j--;
                continue;
            }

            if (Character.toLowerCase(start) != Character.toLowerCase(end)) {
                return false;
            }

            i++;
            j--;
        }
        long duration = (System.nanoTime() - startTime);
        System.out.println("Running time of a program " + duration + "ns");
        return true;
    }
}
