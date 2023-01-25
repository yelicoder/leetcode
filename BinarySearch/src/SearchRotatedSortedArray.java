public class SearchRotatedSortedArray {
    /*
    There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1

     */

    public int search(int[] nums, int target) {

        if (target == nums[0]) return 0;

        int left = 0;
        int right = nums.length -1 ;


        if (target > nums[0]) {

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] == target) return mid;

                if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] >= nums[0]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }  else {
            while (left <= right) {
                int mid = left + (right-left)/2;

                if (nums[mid] == target) return mid;

                if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid]<nums[0]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return -1;
    }

    public static void main (String[] args) {
        SearchRotatedSortedArray o = new SearchRotatedSortedArray();
       int[] nums = {4,5,6,7,0,1,2};

        System.out.println(o.search(nums,0));

        nums = new int[] {4,5,6,7,0,1,2};
        System.out.println(o.search(nums,3));

        nums = new int[]{1};
        System.out.println(o.search(nums,0));
    }
}
