package com.myproject.test.heap;

public class MinHeap {

    int heapSize = 0;
    int realSize = 0;
    int arr[] ;

    public MinHeap(int size){
        this.heapSize = size;
        this.arr= new int[this.heapSize + 1];
        this.arr[0] = 1;
    }

    public void add(int num){
        realSize++;
        if(realSize < heapSize){
            return;
        }
        arr[realSize] = num;
        int parent = realSize/2;
        int curr = realSize;
        while(arr[parent] > arr[curr] && parent > 1){
            int temp = arr[parent];
            arr[parent]= arr[curr];
            arr[curr] = temp;
            curr = parent;
            parent = curr/2;
        }
    }

    public int peek(){
        if(realSize < 1)
            return -1;
        return arr[1];
    }


    public int pop() {
        // If the number of elements in the current Heap is 0,
        // print "Don't have any elements" and return a default value
        if (realSize < 1) {
            System.out.println("Don't have any element!");
            return Integer.MAX_VALUE;
        } else {
            // When there are still elements in the Heap
            // realSize >= 1
            int removeElement = arr[1];
            // Put the last element in the Heap to the top of Heap
            arr[1] = arr[realSize];
            realSize--;
            int index = 1;
            // When the deleted element is not a leaf node
            while (index <= realSize / 2) {
                // the left child of the deleted element
                int left = index * 2;
                // the right child of the deleted element
                int right = (index * 2) + 1;
                // If the deleted element is larger than the left or right child
                // its value needs to be exchanged with the smaller value
                // of the left and right child
                if (arr[index] > arr[left] || arr[index] > arr[right]) {
                    if (arr[left] < arr[right]) {
                        int temp = arr[left];
                        arr[left] = arr[index];
                        arr[index] = temp;
                        index = left;
                    } else {
                        // maxHeap[left] >= maxHeap[right]
                        int temp = arr[right];
                        arr[right] = arr[index];
                        arr[index] = temp;
                        index = right;
                    }
                } else {
                    break;
                }
            }
            return removeElement;
        }

    }


    public static void main(String[] args) {
        // Test case
        MinHeap minHeap = new MinHeap(3);
        minHeap.add(3);
        minHeap.add(1);
        minHeap.add(2);
        // [1,3,2]
        System.out.println(minHeap.toString());
        // 1
        System.out.println(minHeap.peek());
        // 1
        System.out.println(minHeap.pop());
        // [2, 3]
        System.out.println(minHeap.toString());
        minHeap.add(4);
        // Add too many elements
        minHeap.add(5);
        // [2,3,4]
        System.out.println(minHeap.toString());
    }


}
