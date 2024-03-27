package com.myproject.test.array;
/*
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the
signed 32-bit integer range [-231, 231 - 1], then return 0.
Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21
 */
public class ReverseInteger {

    public static void main(String[] args) {
        int x = 123456;
        int val = 0;
        for(int i = 0 ; x != 0; i++){
            int rm =  x % 10;
            x = x / 10;
            val = val * 10 + rm;
        }
        System.out.println(val);
    }
}
