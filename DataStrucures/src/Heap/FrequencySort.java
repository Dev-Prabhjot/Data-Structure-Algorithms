package Heap;

import java.util.*;

public class FrequencySort {

    public static void main(String[] args) {
        String str = "codingsimplified";

        sortStringBasedOnFrequencyOfCharacters(str);
    }

    public static void sortStringBasedOnFrequencyOfCharacters(String str) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (n1, n2) -> n2.getValue() - n1.getValue());

        maxHeap.addAll(map.entrySet());


        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();

            System.out.println(entry.getKey() + " " + entry.getValue());

        }


    }


}
