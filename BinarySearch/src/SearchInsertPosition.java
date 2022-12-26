import java.util.Arrays;

public class SearchInsertPosition {

    /*
    Given a sorted array of distinct integers and a target value,
    return the index if the target is found.
    If not, return the index where it would be if it were inserted in order.

    You must write an algorithm with O(log n) runtime complexity.



        Example 1:

        Input: nums = [1,3,5,6], target = 5
        Output: 2
        Example 2:

        Input: nums = [1,3,5,6], target = 2
        Output: 1
        Example 3:

        Input: nums = [1,3,5,6], target = 7
        Output: 4


        Constraints:

        1 <= nums.length <= 104
        -104 <= nums[i] <= 104
        nums contains distinct values sorted in ascending order.
        -104 <= target <= 104
     */

    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length-1, target);
    }

    public int binarySearch(int arr[], int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the
            // middle itself
            if (arr[mid] == x)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x) {
                return binarySearch(arr, l, mid - 1, x);
            } else {
                // Else the element can only be present in right subarray
                return binarySearch(arr, mid + 1, r, x);
            }
        }
        // We reach here when element is not present
        // in array
        return l;
    }


    public static void main (String[] args) {

        int[] nums = {1,3,5,6};
        int target = 7;
        SearchInsertPosition ob = new SearchInsertPosition();
        System.out.println(ob.searchInsert(nums, target));
    }
}
