public class FindMinRotatedSortedArrayWithDup {

    /*
    Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

You must write an algorithm that runs in O(log n) time.



Example 1:

Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.
Example 2:

Input: nums = [4,5,6,7,0,1,2]
Output: 0
Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
Example 3:

Input: nums = [11,13,15,17]
Output: 11
Explanation: The original array was [11,13,15,17] and it was rotated 4 times.
     */

    public int findMin(int[] nums) {

        /*
        Inflection point is where the sorted array changed from ascending order to a lower
        lower value. The right of the inflection point is where we want to return.

        The min element is smaller than its left element. Therefore:
        if an element is smaller than its left. It is the min element
        if an element is greater than its right. Its right is the min element.

        If an element is greater than the first element, the min element is on the right
        If an element is smaller than the first element, the min element is on the left

         */

        // If the list has just one element then return that element.
        if (nums.length==1) return nums[0];

        if (nums.length == 2) {
            if (nums[0] > nums[1]) {
                return nums[1];
            } else {
                return nums[0];
            }
        }

        int left = 0;
        int right = nums.length-1;
        int mid;

        if (nums[right] > nums[0]) {
            return nums[0];
        }

        while (right>=left) {
            mid = left + (right-left)/2;

            if (nums[mid]>nums[mid+1]) {
                return nums[mid+1];
            } else if (nums[mid] == nums[mid+1]) {
                if(nums[mid] < nums[0]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
                continue;
            }

            if(nums[mid]<nums[mid-1]) {
                return nums[mid];
            } else if (nums[mid]==nums[mid-1]) {
                if(nums[mid] < nums[0]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
                continue;
            }
        }

        return -1;

    }

    public static void main (String[] args) {
        int[] nums = {3,2};
        FindMinRotatedSortedArrayWithDup ob = new FindMinRotatedSortedArrayWithDup();

        /*
        System.out.println(ob.findMin(nums));

        nums = new int[] {2,2,2,0,1};
        System.out.println(ob.findMin(nums));

        nums = new int[] {4,5,6,7,0,1,4};
        System.out.println(ob.findMin(nums));

        nums = new int[] {0,1,4,4,5,6,7};
        System.out.println(ob.findMin(nums));
        */

        nums = new int[] {1,1,1};
        System.out.println(ob.findMin(nums));


    }
}
