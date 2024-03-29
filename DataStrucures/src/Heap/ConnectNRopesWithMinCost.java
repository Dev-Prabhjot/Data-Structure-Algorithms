package Heap;

import java.util.PriorityQueue;

//https://www.youtube.com/watch?v=Eb1A6nm_Nic&list=PLUcsbZa0qzu3yNzzAxgvSgRobdUUJvz7p&index=35
public class ConnectNRopesWithMinCost {
    public static void main(String[] args) {
        int arr[] = {3, 4, 7, 2};
        System.out.println(connectRopeWithMinimumCost(arr));
    }

    ///Tc: nLogn
    //If would have done using normal sort then Tc : n (nLogn) = n^2Logn Hence usng heap Tc improves to nLogn
    public static int connectRopeWithMinimumCost(int[] ropes) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < ropes.length; i++) {
            minHeap.add(ropes[i]);
        }

        int totalMinCost = 0;

        while (minHeap.size() > 1) {

            int first = minHeap.poll();
            int second = minHeap.poll();
            int twoRopeSum = first + second;
            totalMinCost = totalMinCost + twoRopeSum;

            minHeap.add(twoRopeSum);
        }

        return totalMinCost;
    }


}
