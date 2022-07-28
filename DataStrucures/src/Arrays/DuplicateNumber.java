package Arrays;

public class DuplicateNumber {


    public static void main(String args[]) {
        int arr[] = {1, 3, 4, 2, 3};
        System.out.println("The duplicate element is " + findDuplicate(arr));
    }

    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        //Move slow by 1 and Fast by 2,if intersect then duplicate exists
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        //Reset fast to 1 posn and move slow,fast both by 1
        //Point where slow==fast is duplicate number

        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;  //Duplicate number
    }


}
