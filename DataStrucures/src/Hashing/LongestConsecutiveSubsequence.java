package Hashing;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubsequence {
    public static void main(String args[]) {

        int[] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {

        Set<Integer> hs = new HashSet<>();
        for (Integer i : nums) {
            hs.add(i);
        }

        int longStreak = 0;
        for (Integer i : hs) {
            if (!hs.contains(i - 1)) {
                int currNum = i;
                int count = 1;
                while (hs.contains(currNum + 1)) {
                    currNum += 1;
                    count += 1;
                }
                longStreak = Math.max(longStreak, count);
            }


        }

        return longStreak;

    }

}
