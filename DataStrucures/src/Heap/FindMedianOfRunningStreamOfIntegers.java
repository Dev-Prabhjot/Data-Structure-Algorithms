package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

//Educative.io Anuj channel video
//https://www.youtube.com/watch?v=Yv2jzDzYlp8&list=PLUcsbZa0qzu3yNzzAxgvSgRobdUUJvz7p&index=36
//LC:Hard
class MedianofaStream {


    public static void main(String[] args) {
        MedianofaStream median0fAStream = new MedianofaStream();
        median0fAStream.insertNum(3);
        median0fAStream.insertNum(1);
        System.out.println("The median is: " + median0fAStream.findMedian());
        median0fAStream.insertNum(5);
        System.out.println("The median is: " + median0fAStream.findMedian());
        median0fAStream.insertNum(4);
        System.out.println("The median is: " + median0fAStream.findMedian());
    }

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); //containing first
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(); //containing second half of numbers

    public void insertNum(int num) {
        if (maxHeap.isEmpty() || maxHeap.peek() >= num)
            maxHeap.add(num);
        else
            minHeap.add(num);
// either both the heaps will have equal number of elements or max-heap will have one
// more element than the min-heap
        if (maxHeap.size() > minHeap.size() + 1)
            minHeap.add(maxHeap.poll());
        else if (maxHeap.size() < minHeap.size())
            maxHeap.add(minHeap.poll());
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
// we have even number of elements, take the average of middle two elements
            return maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
        }
// because max-heap will have one more element than the min-heap
        return maxHeap.peek();
    }
}
