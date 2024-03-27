package com.myproject.test.list;

import java.util.Arrays;
import java.util.List;

/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order,
and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class AddTwoNumber {
   /* public static void main(String[] args) ()

    }*/
   public int[] solution(int[] A, int F, int M) {
       int knownSize = A.length;
       int totalLength = knownSize + F;
       int totalSum = M * totalLength;
       int knownSum = 0;
       for(int i = 0; i < knownSize; i++){
           knownSum = knownSum + A[i];
       }

       int remainingSum = totalSum - knownSum;

       int[] ans = new int[F];

       if (remainingSum > F * 6 || remainingSum < F) {
           return new int[0];
       }

       for(int i = 0; i< ans.length ; i++){
           ans[i] = remainingSum / F;
       }

       Arrays.fill(ans, remainingSum / F);
       for (int i = 0; i < remainingSum % F; ++i) {
           ++ans[i];
       }
       return ans;
   }


    public int solution(int[] A) {

        int[] result = new int[A.length];
        int arrSize = A.length;

        for (int i = 0; i < arrSize ; i += 2) {

            int [] tempValue = new int[result.length];

            for(int k = 0 ; i < result.length ; k++){
                tempValue[k] = result[k];
            }

            for (int j = 0; j < 6; ++j) {
                int t = tempValue[A[i + 1] - 1];
                t =  Math.max(t, result[A[i] - 1] + 1);
                tempValue[A[i+1] - 1] = t;
            }
            result = tempValue;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < result.length; i++) {
            if (result[i] > max) {
                max = result[i];
            }
        }
        return arrSize / 2 - max;

    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null){
            return new ListNode(0);
        }else if(l1 != null && l2 == null){
            return l1;
        }else if(l1 == null && l2 != null){
            return l2;
        }

        ListNode node = new ListNode();
        ListNode currNode = new ListNode();
        node = currNode;
        int carry = 0;
        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val + carry;
            int res = sum % 10;
            carry = sum / 10;
            ListNode tempNode = new ListNode();
            tempNode.val = res;
            currNode.next= tempNode;
            currNode = currNode.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1 == null  && l2 != null){
            while(l2 !=null){
                int sum = l2.val + carry;
                int res = sum % 10;
                carry = sum / 10;
                ListNode tempNode = new ListNode();
                tempNode.val = res;
                currNode.next= tempNode;
                currNode = currNode.next;
                l2 = l2.next;
            }
        }
        if(l1 != null  && l2 == null){
            while(l1 !=null){
                int sum = l1.val + carry;
                int res = sum % 10;
                carry = sum / 10;
                ListNode tempNode = new ListNode();
                tempNode.val = res;
                currNode.next= tempNode;
                currNode = currNode.next;
                l1 = l1.next;
            }
        }
        if(carry > 0){
            ListNode tempNode = new ListNode();
            tempNode.val = carry;
            currNode.next= tempNode;
            currNode = currNode.next;
        }
        return node.next;
    }
}
