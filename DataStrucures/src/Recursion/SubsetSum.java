package Recursion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SubsetSum {

    public static void main(String args[]) {

        //Print subsquence with sum equal to K
        System.out.println("Executing print All Subset Sum");
        int[] arr2 = {3,1,2};
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        printSubsetSumI(0, list2, arr2, 0,list1);
       List<Integer> sortedList = list1.stream().sorted().collect(Collectors.toList());
       sortedList.forEach(System.out::println);
    }

    private static void printSubsetSumI(int i, List<Integer> res, int[] arr, int sum,List<Integer> subsetSumList) {

        if(i== arr.length){
            System.out.print("{");
            res.forEach(x -> System.out.print(x + " "));
            System.out.println("}");
            System.out.println("Sum: "+sum);
            subsetSumList.add(sum);
            return;
        }
        //Take
        res.add(arr[i]);
        sum+=arr[i];
        printSubsetSumI(i+1,res,arr,sum,subsetSumList);

        //Not Take
        res.remove(res.size()-1);
        sum-=arr[i];
        printSubsetSumI(i+1,res,arr,sum,subsetSumList);

    }
}
