package com.myproject.test.array;

import java.util.HashSet;
import java.util.Set;

public class SlidingWindow {
   // Set<Character> digitSet = new HashSet<Character>().addAll(0,1,2,3,4,5,6,7,8,9);
    public static void main(String[] args) {
        String s = "42";
        SlidingWindow sw = new SlidingWindow();
        int length = sw.myAtoi(s);
        System.out.println("result " + length);
    }

    public int myAtoi(String s) {
        if(s== null)
            return 0;
        String str = s.trim();
        char[] arr = str.toCharArray();
        int length = arr.length;
        int sum = 0;
        int first = 0;
        if(arr[0] == '-')
            first = 1;

        for(int i = first; i < length; i++){
            int c = Integer.valueOf(arr[i] - '0');
            int loop = length - 1 - i;
            double result = Math.pow(10, loop);
            c = c * (int)result;
            sum = sum + c;
        }
        if(first != 0)
            sum = sum * (-1);
        return sum;

    }
    public String getDigitValue(String str){
        StringBuilder sb = new StringBuilder();
        boolean zeroFlag = false;
        boolean digitFlag = false;

        /*for(char c : str.toCharArray()){
            if()
        }*/
        return sb.toString();
    }
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int right = 0;
        int left = 0;
        int[] chars =  new int[128];
        while(right < s.length()){
            char var = s.charAt(right);
            while(chars[var] > 0){
                char l = s.charAt(left);
                chars[l]--;
                left++;
            }
            chars[var]++;
            right++;
            res = Math.max(res, right-left);
        }
        return res;
    }

    public int lengthOfLongestSubstringOptimized(String s) {
        int res = 0;
        int right = 0;
        int left = 0;
        int[] chars =  new int[128];
        while(right < s.length()){
            char r = s.charAt(right);
            Integer index = chars[r];
            if(index != null && index >= left  && index < right)
                left = index + 1;
            res = Math.max(res, right-left+1);
            chars[r] = right;
            right++;
        }
        return res;
    }
}
