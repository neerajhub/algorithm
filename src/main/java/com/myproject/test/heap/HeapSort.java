package com.myproject.test.heap;

public class HeapSort {

    public static void heapSort1(int[] arr) {
            // Mutates elements in lst by utilizing the heap data structure
            for (int i = arr.length / 2 - 1; i >= 0; i--) {
                maxHeapify(arr, arr.length, i);
            }

            for (int i = arr.length - 1; i > 0; i--) {
                // swap last element with first element
                int temp = arr[i];
                arr[i] = arr[0];
                arr[0] = temp;
                // note that we reduce the heap size by 1 every iteration
                maxHeapify(arr, i, 0);
            }
        }
    public static int[] heapSort(int arr[]){

        int length = arr.length ;
        for(int i = length/2 - 1 ; i >= 0 ; i--){
            heapify(arr, arr.length, i);
        }

        for (int i = length ; i >= 0; i--){

            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            heapify(arr,i, 0);
        }
        return arr;
    }

        private static void maxHeapify(int[] arr, int heapSize, int index) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int largest = index;
            if (left < heapSize && arr[left] > arr[largest]) {
                largest = left;
            }
            if (right < heapSize && arr[right] > arr[largest]) {
                largest = right;
            }
            if (largest != index) {
                int temp = arr[index];
                arr[index] = arr[largest];
                arr[largest] = temp;
                maxHeapify(arr, heapSize, largest);
            }
        }



    public static void heapify2(int arr[], int heapSize, int index){
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int largest = index;
        if(left < heapSize && arr[largest] < arr[left]){
            largest = left;
        }
        if(right < heapSize && arr[largest] < arr[right]){
            largest = right;
        }

        if(index != largest){
            int temp = arr[largest];
            arr[largest]= arr[index];
            arr[index] = temp;
            heapify(arr,heapSize,largest);
        }

    }

    public static void heapify(int arr[], int heapSize, int index){
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int largest = index;
        if(left < heapSize && arr[largest] < arr[left]){
            largest = left;
        }
        if(right < heapSize && arr[largest] < arr[right]){
            largest = right;
        }

        if(index != largest){
            int temp = arr[largest];
            arr[largest]= arr[index];
            arr[index] = temp;
            heapify(arr,heapSize,largest);
        }

    }


    public static void main(String[] args) {
         int [] arr = new int[]{4,6,1,7,9,5};
         heapSort(arr);

         for(int i :arr){
             System.out.println(i);
         }
    }
}
