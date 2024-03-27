package com.myproject.test.array;

public class ComputeMaxWater {

    public static void main(String[] args) {
         int [] height = new int[]{1,8,6,2,5,4,8,3,7};
         int result = ComputeMaxWater.maxWater(height);
         System.out.println("max water " + String.valueOf(result));
    }

    public static int maxWater(int []height){
        if(height.length == 0 || height.length == 1)
            return 0;
        int last = height.length - 1;
        int first = 0 ;
        int maxArea = 0;
        while(first < last){
            if(height[first] > height[last] ){
                int tempArea = height[last] * (last-first);
                if(tempArea > maxArea)
                    maxArea = tempArea;
                last--;
            }else{
                int tempArea = height[first] * (last-first);
                if(tempArea > maxArea)
                    maxArea = tempArea;
                first++;
            }
        }
        return maxArea;
    }
}
