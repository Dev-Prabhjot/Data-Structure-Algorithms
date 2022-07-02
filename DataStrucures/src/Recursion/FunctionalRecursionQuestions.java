package Recursion;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class FunctionalRecursionQuestions {
    public static void main(String args[]) {

        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Prabhjot:");
        reverseArray(0, arr, 5);
        System.out.println();
        reverseArrayStriver(0, arr, 5);
        System.out.println("Striver:");
        for (int x : arr) {
            System.out.print(x + ",");
        }


        boolean isPalindrome = checkPalindrome(0, "MADAM".toCharArray());
        System.out.println(isPalindrome);
    }


    //In case of boolean
    //Return true from base case
    //Return false from failing condition in LOGIC part
    private static boolean checkPalindrome(int i, char[] arr) {

        if (i > arr.length / 2)
            return true;

        if (arr[i] != arr[arr.length - i - 1])
            return false;

        return checkPalindrome(i + 1, arr);
    }

    //My way using BackTrack
    private static int reverseArray(int i, int[] arr, int n) {

        if (i == n) {
            return arr[n - 1];
        }
        int rev = reverseArray(i + 1, arr, n);
        int temp = arr[n - i - 1];
        arr[n - i - 1] = arr[i];
        arr[i] = temp;

        if ((n % 2 == 0 && i == n / 2) || (n % 2 != 0 && i - 1 == n / 2)) {
            for (int i1 : arr) {
                System.out.print(i1 + ",");
            }
        }
        return arr[n - temp - 1];
    }

    //Striver way No back Track Better

    private static void reverseArrayStriver(int i, int[] arr, int n) {
        if (i >= n / 2)
            return;
        int temp = arr[n - i - 1];
        arr[n - i - 1] = arr[i];
        arr[i] = temp;
        reverseArrayStriver(i + 1, arr, n);
    }
}
