package Heap;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair> {
    int val;
    int diff;

    Pair(int val, int diff) {
        this.val = val;
        this.diff = diff;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public int getDiff() {
        return diff;
    }

    public void setDiff(int diff) {
        this.diff = diff;
    }

    @Override
    public int compareTo(@NotNull Pair o) {
        if (this.diff == o.diff) {
            return this.val - o.val;
        } else {
            return this.diff - o.diff;
        }
    }

}

public class KClosestElementsToX {


    public static void main(String[] args) {
        int[] arr = {10, 7, 11, 30, 8, 38, 2, 45};
        int x = 25;
        int k = 4;

        findKClosestNumbersToX(arr, x, k);
//        Arrays.sort(arr);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
    }

    private static void findKClosestNumbersToX(int[] arr, int x, int k) {


        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            int d = Math.abs(arr[i] - x);
            maxHeap.add(new Pair(arr[i], d));
        }

        for (int i = k; i < arr.length; i++) {
            if (maxHeap.peek().diff > Math.abs(arr[i] - x)) {
                maxHeap.poll();
                maxHeap.add(new Pair(arr[i], Math.abs(arr[i] - x)));
            }
        }

        maxHeap.forEach(e -> System.out.println(e.val));

    }
}
