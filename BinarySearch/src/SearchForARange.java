import java.util.Arrays;

public class SearchForARange {
    /*
    Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]


Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109
     */

    public int[] searchRange(int[] nums, int target) {

        if (nums == null || nums.length == 0) return new int[] {-1,-1};

        int beginIndex = findTargetPosition(nums, target, true);
        int endIndex = findTargetPosition(nums, target, false);

        return new int[] {beginIndex, endIndex };
    }

    public int findTargetPosition(int[]nums, int target, boolean isFirst) {

        int left = 0, right = nums.length-1, mid;

        while (left <= right) {
            mid = left + (right-left)/2;

            if (nums[mid] == target) {

                if (isFirst) {
                    if (mid == 0) return mid;

                    if (nums[mid] > nums[mid - 1]) {
                        return mid;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    if ( mid == nums.length - 1) return mid;
                    if (nums[mid] < nums[mid+1]) {
                        return mid;
                    } else {
                        left = mid + 1;
                    }
                }

            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main (String[] args) {
        SearchForARange o = new SearchForARange();

        int[] nums = {5,7,7,8,8,10};

        //[3,4]
        System.out.println(Arrays.toString(o.searchRange(nums,8)));

        nums = new int[] {5,7,7,8,8,10};
        System.out.println(Arrays.toString(o.searchRange(nums,6)));

        nums = new int[]{};
        System.out.println(Arrays.toString(o.searchRange(nums,0)));

    }
}
