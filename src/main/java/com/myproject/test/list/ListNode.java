package com.myproject.test.list;

public class ListNode {
    int val;
    ListNode next;

    public ListNode(){

    }

    public ListNode(int data) {
        this.val = data;
    }

    public ListNode(int data, ListNode next) {
        this.val = data;
        this.next = next;
    }
}
