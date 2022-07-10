package Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class TopKLargestSmallestElement {
    public static void main(String args[]) {
        int[] arr = {10, 7, 11, 5, 2, 13, 1, 45};
        int k = 3;
        System.out.println("Top K Smallest elements");
        kSmallest(arr, k).forEach(x->System.out.print(x+","));
        System.out.println();
        System.out.println("Top K Largest elements");
        kLargest(arr, k).forEach(x->System.out.print(x+","));
    }
    //Use MinHeap to find K Largest elements

    private static List<Integer> kLargest(int[] arr, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        addElementsToKIndex(arr, k, minHeap);
        //Start from k index
        for (int i = k; i < arr.length; i++) {
            if (arr[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            res.add(minHeap.poll());
        }
        return res;
    }

//Use MaxHeap to find K Smallest elements

    private static List<Integer> kSmallest(int[] arr, int k) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        addElementsToKIndex(arr, k, maxHeap);
        //Start from k index
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.add(arr[i]);
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            res.add(maxHeap.poll());
        }
        return res;
    }

    public static void addElementsToKIndex(int[] arr, int k, PriorityQueue heap) {

        for (int i = 0; i < k; i++) {
            heap.add(arr[i]);
        }
    }

}
