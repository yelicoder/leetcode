import java.util.*;

public class FindKClosestElement {

    /*
    Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b


Example 1:

Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]
Example 2:

Input: arr = [1,2,3,4,5], k = 4, x = -1
Output: [1,2,3,4]


Constraints:

1 <= k <= arr.length
1 <= arr.length <= 10000
arr is sorted in ascending order.
-10000 <= arr[i], x <= 10000
     */

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        List<Integer> result = new ArrayList<Integer>();

        int left = 0, right = arr.length - 1, mid, targetIndex=0;
        boolean found = false;

        while (left<=right) {
            mid = left + (right-left)/2;

            if (arr[mid] == x) {
                targetIndex = mid;
                found = true;
                break;
            }

            if (arr[mid]>x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (!found) {
           targetIndex = right;
        }

        int leftIndex = targetIndex - 1;
        int rightIndex = targetIndex;

        while ((rightIndex - leftIndex < k) && (leftIndex > -1) && rightIndex<arr.length ) {

            if (Math.abs(arr[rightIndex] - x) < Math.abs(arr[leftIndex] - x)) {
                result.add(Integer.valueOf(arr[rightIndex]));
                rightIndex++;
            } else if (Math.abs(arr[rightIndex] - x) > Math.abs(arr[leftIndex] - x)) {
                result.add(Integer.valueOf(arr[leftIndex]));
                leftIndex--;
            } else if (arr[rightIndex] < arr[leftIndex]) {
                result.add(Integer.valueOf(arr[rightIndex]));
                rightIndex++;
            } else {
                result.add(Integer.valueOf(arr[leftIndex]));
                leftIndex--;
            }
        }

        if (leftIndex == -1) {
            for (int i = rightIndex; i< k; i++) {
                result.add(Integer.valueOf(arr[i]));
            }
        }

        if (rightIndex == arr.length) {
            for ( int i = left=1; i > arr.length +2 -k; i--) {
                result.add(0,Integer.valueOf(arr[i]));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindKClosestElement o = new FindKClosestElement();
        int[] arr = {1,2,3,4,5};

        System.out.println(o.findClosestElements(arr, 4,3).toString());

    }
}
