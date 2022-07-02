package Recursion;

public class RecursionUsingBackTracking {

    /**
     * Input must be N
     * eg: 1toN f(N,N)
     * eg: Nto1 f(1,N)
     * BackTracking means :
     * we first do recursive calls till the base condition is hit
     * Return from base condition and perform logic
     * BackTrack in nutshell: We perform logic while returning back from recursive calls
     */
    public static void main(String args[])
    {
        print1toNWithBackTrack(5,5);
        System.out.println("---");
        printNto1WithBackTrack(1,5);
    }

    private static void printNto1WithBackTrack(int i, int n) {
        if(i>n)
            return;

        printNto1WithBackTrack(i+1,n);
        System.out.println(i);
    }

    private static void print1toNWithBackTrack(int i, int n) {

        if(i<1)
            return;
        //Move till the base condition  is hit
        print1toNWithBackTrack(i-1,n);
        //Print values while returning from next function call - This is called backtracking
        System.out.println(i);
    }
}
