package com.myproject.test.array;

public class SlidingWindow {

    public static void main(String[] args) {
        String s = "abcdac";
        SlidingWindow sw = new SlidingWindow();
        int length = sw.lengthOfLongestSubstringOptimized(s);
        System.out.println("result " + length);
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
