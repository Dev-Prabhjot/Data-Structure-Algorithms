package String;

public class MinimumCharactersAddedFrontMakeStringPalindrome {
    /*
    *  Finally minimum number of character needed to make the string a palindrome is length of the input string minus last entry of our lps array.
    * */

    public static void main(String[] args) {
       String string = "AACECAAAA";

      System.out.println(minChar(string.toCharArray()));
    }

    public static int minChar(char[] str)
    {
        // Write your code here
        int n = str.length;
        int left = 0;
        int right = n - 1;
        int added = 0;
        while (left < right) {
            // if left and right characters are same increase
            // left and decrease right pointer
            if (str[left] == str[right]) {
                left++;
                right--;
            }
            // else think of adding some characters at front and
            // start comparing the elements again
            else {
                left = 0;
                added = n - right;
                if (str[left] == str[right]) {
                    added--;
                    left++;
                }
                right--;
            }
        }
        return added;
    }
}
