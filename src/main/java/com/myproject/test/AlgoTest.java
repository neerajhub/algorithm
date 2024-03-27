package com.myproject.test;

import java.util.HashMap;
import java.util.Map;

public class AlgoTest {

    public static void main(String[] args) {
        String s = args[0];
        char arr[] = s.toCharArray();
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i = 0 ; i < arr.length; i++){
            char c = arr[i];
            if(map.containsKey(c)){
                map.put( c , map.get(c) + 1);
            }else{
                map.put(c,1);
            }
        }

        int max = maxUsingIteration(map);
        int min = 0;
      //  while(map.keySet())
    }


    public static <K, V extends Comparable<V>> V maxUsingIteration(Map<K, V> map) {
        Map.Entry<K, V> maxEntry = null;
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (maxEntry == null || entry.getValue()
                    .compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }
        return maxEntry.getValue();
    }
}
