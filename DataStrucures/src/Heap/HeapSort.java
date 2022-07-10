package Heap;

import java.util.PriorityQueue;

public class HeapSort {

    //Time complexity: O(nLogn) best,average, worst
    //Space complexity: O(1 worst)
    public static void main(String[] args) {
        int[] arr = {10, 7, 11, 30, 8, 38, 2, 45};

        heapSort(arr);

        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
    public static void heapSort(int[] arr) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i = 0; i < arr.length; i++) {
            minHeap.add(arr[i]);
        }

        for(int i = 0; i < arr.length; i++) {
            arr[i] = minHeap.poll();
        }
    }


}
