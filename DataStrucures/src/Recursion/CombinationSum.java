package Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String args[]) {
        //Print all Subsequences of array
        System.out.println("Executing print All combinations equal to Target with repeating any element :");
        int[] arr1 = {2, 3, 6, 7};
        int target = 7;
        List<Integer> list1 = new ArrayList<>();
        List<List<Integer>> combinationList = new ArrayList<>();
        findAllCombinationSum(0, arr1, list1, target, combinationList);
        print(combinationList);

        System.out.println("Executing print All combinations equal to Target with unique element :");
        int[] arr2 = {2, 3, 6, 7};
        int target2 = 7;
        List<Integer> list2 = new ArrayList<>();
        List<List<Integer>> combinationListUnique = new ArrayList<>();
        findAllCombinationSum(0, arr2, list2, target2, combinationListUnique);
        print(combinationListUnique);
    }

    private static void print(List<List<Integer>> combinationList) {
        for (List<Integer> l1 : combinationList) {
            for (Integer n: l1) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    private static void findAllCombinationSum(int i, int[] arr1, List<Integer> list1, int target, List<List<Integer>> combinationList) {

        if (i == arr1.length) {
            if (target == 0) {
                combinationList.add(new ArrayList<>(list1));
            }
            return;
        }
//element is less tha or equal to tarke then only TAKE
        if (arr1[i] <= target) {
            //take or pick
            list1.add(arr1[i]);
            findAllCombinationSum(i, arr1, list1, target - arr1[i], combinationList);
            list1.remove(list1.size() - 1);
        }
        //else Not Takes
        findAllCombinationSum(i + 1, arr1, list1, target, combinationList);
    }
}
