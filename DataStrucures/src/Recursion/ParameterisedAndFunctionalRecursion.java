package Recursion;

public class ParameterisedAndFunctionalRecursion {

    public static void main(String args[]){

        System.out.println(printSumToNFunctional(3));
        System.out.println(printFactorialToNFunctional(4));
        prinSumToNParameterized(1,0,4);
    }

    private static void prinSumToNParameterized(int i, int s, int n) {
        if(i>n) {
            System.out.println(s);
            return;
        }
        s=s+i;
        prinSumToNParameterized(i+1,s,n);
    }

    /**
     *
     * Functional starts from N and goes recursively till 0 (Base condition is hit)
     * Return answer from base condition and perform required logic in return statement of method
     */
    private static int printFactorialToNFunctional(int n) {
        if(n==0)
            return 1;

        return n*printFactorialToNFunctional(n-1);
    }

    private static int printSumToNFunctional(int n) {

        if(n==0)
            return 0;

        return n + printSumToNFunctional(n-1);
    }
}
