package com.myproject.test.tree;

public class AverageSubTree {

    static int count  = 0;
    static class Pair{
        int sum;
        int count;
        Pair(int root_val,int cnt){
            this.sum = root_val;
            this.count=cnt;
        }
    }
    public int averageOfSubtree(TreeNode root) {
        count=0;
        averageOfSubtreeHelper(root);
        int temp=count;
        return temp;
    }

    public Pair averageOfSubtreeHelper(TreeNode node){
        if(node == null)
            return new Pair(0,0);
        Pair lPair = averageOfSubtreeHelper(node.left);
        Pair rPair = averageOfSubtreeHelper(node.right);
        int tempCount = lPair.count + rPair.count + 1;
        int sum = lPair.sum + rPair.sum + node.val;
        if(sum/tempCount == node.val)
            count++;
        return  new Pair(sum , tempCount);
    }
}
