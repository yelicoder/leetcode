import java.util.Arrays;

public class RotateArray {

    /*
    Given an array, rotate the array to the right by k steps, where k is non-negative.

        Example 1:

        Input: nums = [1,2,3,4,5,6,7], k = 3
        Output: [5,6,7,1,2,3,4]
        Explanation:
        rotate 1 steps to the right: [7,1,2,3,4,5,6]
        rotate 2 steps to the right: [6,7,1,2,3,4,5]
        rotate 3 steps to the right: [5,6,7,1,2,3,4]
        Example 2:

        Input: nums = [-1,-100,3,99], k = 2
        Output: [3,99,-1,-100]
        Explanation:
        rotate 1 steps to the right: [99,-1,-100,3]
        rotate 2 steps to the right: [3,99,-1,-100]


        Constraints:

        1 <= nums.length <= 105
        -231 <= nums[i] <= 231 - 1
        0 <= k <= 105
     */

    public void rotate(int[] nums, int k) {
        int[] result = new int[nums.length];

        for (int i=0; i<nums.length; i++) {
            int index = (i+k) % (nums.length);
            result[index] = nums[i];
        }

        for (int i=0; i<nums.length; i++) {
            nums[i] = result[i];
        }
    }

    public static void main (String[] args) {
        RotateArray ob = new RotateArray();

        int[]nums = {-1,-100,3,99};
        int k = 2;
        ob.rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
