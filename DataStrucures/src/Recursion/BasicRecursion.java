package Recursion;

import org.omg.Messaging.SyncScopeHelper;

public class BasicRecursion {

    public static void main(String args[])
    {
        printNumbers(1,5);
        printName(1,5);
        printNto1(5,5);
    }

    private static void printNumbers(int i,int n) {
        //Base condition - Specified condition
        //There can be single or multiple base condition
        if (i > n) {
            return;
        }
        //Logic or operation to perform
        System.out.println(i);

        //perform it for next number
        printNumbers(i+1,n);
    }
    static final String name= "Prabhjot";
    private static void printName(int cnt,int x)
    {
        if(cnt>x)
            return;

        System.out.println(name);
        printName(cnt+1,x);
    }

    private static void printNto1(int i,int n)
    {
        if(i<1)
            return;

        System.out.println(i);
        printNto1(i-1,n);
    }


}
