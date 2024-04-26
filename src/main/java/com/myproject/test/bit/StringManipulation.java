package com.myproject.test.bit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringManipulation {

    public static void main(String[] args) {
        List<String> rs = StringManipulation.allPossibleStrings("abc");
        for(String s: rs){
            System.out.println(s);
        }
    }

    /**
     * print all Subsequence of the string in lexicographically-sorted order.
     *
     */
    public static List<String> allPossibleStrings(String s)
    {
        List<String> res = new ArrayList<>();
        int n = s.length();
        for(int i = 0 ; i <= ( 2 << n -1); i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0 ; j < n; j++){
                if(((1 << j) & i )!= 0){
                    sb.append(s.charAt(j));
                }
            }
            res.add(sb.toString());
        }
        Collections.sort(res);
        return res;
    }
}
