package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class Heap {

    /*
     * Adding values to minHeap and showing element at Top to verify minHeap working (min Element at Top)
     *
     * Adding values to maxHeap and showing element at Top to verify maxHeap working (max element at Top)
     *
     * */
    public static void main(String args[]) {
        int[] arr = {10, 7, 11, 5, 2, 13, 1, 45};

        minHeap(arr);
        maxHeap(arr);
    }

    public static void minHeap(int[] arr) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        System.out.println("MinHeap value at Top while adding");
        for (int i = 0; i < arr.length; i++) {
            heap.add(arr[i]);
            System.out.print(heap.peek() + " ");
        }

        System.out.println();
        System.out.println("MinHeap value at Top while removing");
        for (int i = 0; i < arr.length; i++) {

           int x=heap.poll();
            System.out.print("Removed: "+x+" ,");
            System.out.print(heap.peek() + " ");
            System.out.println(heap);
        }

        System.out.println();
    }


    public static void maxHeap(int[] arr) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        System.out.println("MaxHeap value at Top while adding");
        for (int i = 0; i < arr.length; i++) {
            heap.add(arr[i]);
            System.out.print(heap.peek() + " ");
            System.out.println(heap);
        }

        System.out.println();
        System.out.println("MaxHeap value at Top while removing");
        for (int i = 0; i < arr.length; i++) {

           int x= heap.poll();
            System.out.print("Removed: "+x+" ,");
            System.out.print(heap.peek() + " ");
            System.out.println(heap);
        }

        System.out.println();
    }
}
