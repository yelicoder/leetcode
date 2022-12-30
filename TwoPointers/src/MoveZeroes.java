import java.util.Arrays;

public class MoveZeroes {
    /*
    Given an integer array nums, move all 0's to the end of it while maintaining
    the relative order of the non-zero elements.

    Note that you must do this in-place without making a copy of the array.

        Example 1:
        Input: nums = [0,1,0,3,12]
        Output: [1,3,12,0,0]

        Example 2:
        Input: nums = [0]
        Output: [0]


        Constraints:

        1 <= nums.length <= 104
        -231 <= nums[i] <= 231 - 1


        Follow up: Could you minimize the total number of operations done?
     */
    public void moveZeroes(int[] nums) {

        int count = 0; // Count of non-zero elements

        // Traverse the array. If element encountered is
        // non-zero, then replace the element at index 'count'
        // with this element
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != 0)
                nums[count++] = nums[i]; // here count is
        // incremented

        // Now all non-zero elements have been shifted to
        // front and 'count' is set as index of first 0.
        // Make all elements 0 from count to end.
        while (count < nums.length)
            nums[count++] = 0;
    }


    public static void main (String[] args) {

        int[] nums = {0};
        MoveZeroes ob = new MoveZeroes();
        ob.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
