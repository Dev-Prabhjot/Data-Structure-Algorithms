package Recursion;


import java.util.ArrayList;
import java.util.List;

/*
* Take or Not Take Approach
*
* /

/*
 * Subsequence -> can be contigious or non-contigious(continuous or non continuous) sequence,which follows the order of array.
 * Subarrray -> Always contigious(continuous)
 */
/*
 * Solution -
 * 1.) Power Set
 * 2.) Recursive way
 *
 * */
public class AllSubsequences {
    public static void main(String args[]) {
        //Print all Subsequences of array
        System.out.println("Executing print All Subsequences of Array in order of Array:");
        int[] arr1 = {3, 1, 2};
        List<Integer> list1 = new ArrayList<>();
        printAllSubsequences(0, list1, arr1, 3);


        int k = 2;
        //Print subsquence with sum equal to K
        System.out.println("Executing print All Sum Equals To K : " + k);
        int[] arr2 = {1, 2, 1};
        List<Integer> list2 = new ArrayList<>();
        printSumEqualsToK(0, list2, arr2, 0, 3, k);

        //Print First sum equal to K
        //Dont use any flag as global variable as it leads to unnecessary recursions
        //Used New approach to find first occurrence

        //Algo:

        //From baseCase
        //return true if found else return false

        //From recursive call (Take case)
        //if base case return true then return true from recursive call
        //else move to Not Take part

        //From recursive call (Not Take case)
        //if base case return true then return true from recursive call
        //else return false from method
        System.out.println("Executing print First Sum Equals To K : " + k);
        int[] arr3 = {1, 2, 1};
        List<Integer> list3 = new ArrayList<>();
       printFirstSumEqualsToK(0, list3, arr3, 0, 3, k);

        System.out.println("Executing print Count Subsequences With Sum Equals To K : " + k);
        System.out.println(printCountSubsequencesWithSumEqualsToK(0,  arr3, 0, 3, k));

    }

    private static void printAllSubsequences(int i, List<Integer> res, int[] arr, int n) {
        if (i == n) {
            System.out.print("{");
            res.forEach(item -> System.out.print(item + ","));
            System.out.println("}");

            if (res.size() == 0) {
                System.out.println("{}");
            }
            return;
        }

        //take
        res.add(arr[i]);
        printAllSubsequences(i + 1, res, arr, n);
        //first remove then not take
        res.remove(Integer.valueOf(arr[i]));// or  res.removeAll(DuplicateNumber.DuplicateNumber.asList(arr[i])) issue: res.remove(arr[i]) tries to remove value at arr[i] index
        printAllSubsequences(i + 1, res, arr, n);

    }

    private static void printSumEqualsToK(int i, List<Integer> res, int[] arr, int sum, int n, int k) {
        if (i == n) {
            if (sum == k) {
                System.out.print("{");
                res.forEach(x -> System.out.print(x + " "));
                System.out.println("}");
            }
            return;
        }
        //take
        res.add(arr[i]);
        sum += arr[i];
        printSumEqualsToK(i + 1, res, arr, sum, n, k);

        //not take
        res.remove(Integer.valueOf(arr[i]));
        sum -= arr[i];
        printSumEqualsToK(i + 1, res, arr, sum, n, k);
    }

    //print only first occurence with sum equal to K
    private static boolean printFirstSumEqualsToK(int i, List<Integer> res, int[] arr, int sum, int n, int k) {
        if (i == n) {
            if (sum == k) {
                System.out.print("{");
                res.forEach(x -> System.out.print(x + " "));
                System.out.println("}");
                return true;
            }
            return false;
        }

        //take
        res.add(arr[i]);
        sum += arr[i];
        // if sum found then return true to avoid future recursions
        if (true == printFirstSumEqualsToK(i + 1, res, arr, sum, n, k)) {
            return true;
        }

        //else go with not Take case

        res.remove(Integer.valueOf(arr[i]));
        sum -= arr[i];
        // if sum found in not Take case then return true to avoid future recursions
        if (true == printFirstSumEqualsToK(i + 1, res, arr, sum, n, k)) {
            return true;
        }
        // If sum equal to K not found then return False
        return false;
    }

    /*
     *
     * Recursion or DP COUNT occurrence problem Algorithm to follow:
     *
     * From Base case
     * Return 1 if condition is true
     * Return 0 if condition false
     *
     * l=f()  left recursive call(Take)
     * r=f()  Right recursive call (Not Take)
     *return l+r;
     *
     *
     * */
    public static int printCountSubsequencesWithSumEqualsToK(int i, int[] arr, int sum, int n, int k) {
        if (i == n) {
            if (sum == k) {
                return 1;
            }
            return 0;
        }

        //Take
        sum += arr[i];
        int left = printCountSubsequencesWithSumEqualsToK(i + 1,  arr, sum, n, k);

        //Not Take
        sum -= arr[i];
        int right = printCountSubsequencesWithSumEqualsToK(i + 1,  arr, sum, n, k);

        return left + right;
    }

}
