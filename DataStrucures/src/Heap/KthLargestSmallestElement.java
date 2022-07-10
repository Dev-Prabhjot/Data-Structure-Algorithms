package Heap;

import java.util.*;

public class KthLargestSmallestElement {

    public static void main(String args[]) {
        int[] arr = {10, 7, 11, 5, 2, 13, 1, 45};

        Arrays.stream(arr).sorted().forEach(x->System.out.print(x+","));System.out.println();
        int k = 3;
        System.out.println("k:"+k);
        System.out.println("Kth Smallest element using MaxHeap");
       System.out.println(kthSmallestUsingMaxHeap(arr,k));
        System.out.println("Kth Largest element using MinHeap");
       System.out.println(kthLargestUsingMinHeap(arr,k));
        System.out.println("Kth Largest element using MaxHeap");
        System.out.println(kthLargestUsingMaxHeap(arr, k));
        System.out.println("Kth Smallest element using MinHeap");
        System.out.println(kthSmallestUsingMinHeap(arr, k));
    }


    private static Integer kthSmallestUsingMaxHeap(int[] arr, int k) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        addElementsToKIndex(arr, k, maxHeap);
        //Start from k index
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.add(arr[i]);
            }
        }

        return maxHeap.peek();
    }
    private static Integer kthLargestUsingMinHeap(int[] arr, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        addElementsToKIndex(arr, k, minHeap);
        //Start from k index
        for (int i = k; i < arr.length; i++) {
            if (arr[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }

        return minHeap.peek();
    }

    public static void addElementsToKIndex(int[] arr, int k, PriorityQueue heap) {

        for (int i = 0; i < k; i++) {
            heap.add(arr[i]);
        }
    }

    private static Integer kthLargestUsingMaxHeap(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        addAllElementsToHeap(arr, maxHeap);

        for (int i = 0; i < k - 1; i++) {
            maxHeap.poll();
        }

        return maxHeap.peek();
    }

    private static Integer kthSmallestUsingMinHeap(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        addAllElementsToHeap(arr, minHeap);
        for (int i = 0; i < k - 1; i++) {
            minHeap.poll();
        }

        return minHeap.peek();
    }

    public static void addAllElementsToHeap(int[] arr, PriorityQueue heap) {

        for (int i = 0; i < arr.length; i++) {
            heap.add(arr[i]);
        }
    }
}
