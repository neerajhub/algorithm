package com.myproject.test.list;

public class ListMaxSum {

    private static int count =0;

    public static void main(String[] args) {
        System.out.println("Hello, World!");

        int [] arr = {1,2,9,9};
        ListNode head = new ListNode();
        head.val = arr[0];
        ListNode input = head;
        for(int i = 1 ; i < arr.length ; i++){
            ListNode node = new ListNode();
            node.val = arr[i];
            head.next = node;
            head = node;
        }

       /* while(input != null){
            System.out.println(input.val);
            input =input.next;
        }*/
        System.out.println(maxSum(input));

        //Node {int data; Node next;}

        //1->2->3->9->null output: 10
       //  9->3>2>1
        //1->6->4->2->null output: 10
        //1->6->3->4->2->null output: 10
        //1->6->11->4->2->null output: 11
    }

    private static int maxSum(ListNode head){
        if(head == null)
          return -1;

        int maxSum = 0;
        ListNode reversedHead = reverseList(head);

        if(count % 2 !=  0)
            count = count/2 + 1;

        for(int i = 1; i < count; i++){
            int sum = reversedHead.val + head.val;
            if(sum > maxSum){
                maxSum = sum;
            }
            head = head.next;
            reversedHead = reversedHead.next;

        }
        return maxSum;
    }


    private static ListNode reverseList(ListNode node){
         ListNode current = node;
         ListNode prev = null;
         while(current != null){
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
         }
        return prev;
    }
}
