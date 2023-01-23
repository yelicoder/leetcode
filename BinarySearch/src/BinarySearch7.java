import java.util.Arrays;

public class BinarySearch7 {

    /*
            Given an array of integers nums which is sorted in ascending order,
            and an integer target, write a function to search target in nums. If target exists,
            then return its index. Otherwise, return -1.

        You must write an algorithm with O(log n) runtime complexity.

        Example 1:

        Input: nums = [-1,0,3,5,9,12], target = 9
        Output: 4
        Explanation: 9 exists in nums and its index is 4
        Example 2:

        Input: nums = [-1,0,3,5,9,12], target = 2
        Output: -1
        Explanation: 2 does not exist in nums so return -1


        Constraints:

        1 <= nums.length <= 104
        -104 < nums[i], target < 104
        All the integers in nums are unique.
        nums is sorted in ascending order.

        */

    /*
    Binary Search Algorithm: The basic steps to perform Binary Search are:

    Begin with the mid element of the whole array as a search key.
    If the value of the search key is equal to the item then return an index of the search key.
    Or if the value of the search key is less than the item in the middle of the interval,
    narrow the interval to the lower half.
    Otherwise, narrow it to the upper half.
    Repeatedly check from the second point until the value is found or the interval is empty.
     */

    int binarySearch(int[] nums, int target) {

        /*
        Arrays.binary(nums, target) returns index of the search key, if it is contained in the array;
        otherwise, (-(insertion point) - 1). The insertion point is defined as the point at which the
        key would be inserted into the array: the index of the first element greater than the key,
        or a.length if all elements in the array are less than the specified key.
        Note that this guarantees that the return value will be >= 0 if and only if the key is found.
         */

        return Arrays.binarySearch(nums, target);
    }

    // Driver method to test above
    public static void main(String args[])
    {
        BinarySearch7 ob = new BinarySearch7();
        int arr[] = { -1,0,3,5,9,12 };
        int x = 2;

        int result = ob.binarySearch(arr, x);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index "
                    + result);
    }
}



