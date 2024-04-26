package com.myproject.test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestClass {

    public  TestClass(){
        System.out.println("in constructor");
    }
    static{
        System.out.println("in static block");
    }

    public static void main(String[] args) {
        System.out.println("in main block");
        //TestClass t = new TestClass();

    }


    public int numSteps(String s) {
        BigInteger b = new BigInteger(s, 2);
        int steps = 0;
        while(!b.equals(BigInteger.ONE)) {
            if(b.testBit(0)) {
                b = b.add(BigInteger.ONE);
            } else {
                b = b.shiftRight(1);
            }
            steps++;
        }
        return steps;
    }

   /* public List<Integer> majorityElement(int[] nums) {
        Integer c1;
        Integer c2 ;
        int cc1= 0;
        int cc2= 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            Integer val = nums[i];
            if(cc1 == 0 && cc2 == 0) c1 = val;
            if(cc1 == 0)c1 = val;
            if(cc2 == 0) c2 = val;

            if(val == c1){
                cc1++;
            }else if(val ==c2){
                cc2++;
            }else{
                if(cc1 > cc2) cc1--;
                if(cc2 > cc1) cc2--;
                else cc1--;
            }
        }
        list.add(c1);list.add(c2);return list;
      //  return list;
    }*/


}
