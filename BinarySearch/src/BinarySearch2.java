import java.util.Arrays;

public class BinarySearch2 {

    /*
    can not use Arrays.binarySearch because the array must be sorted to use this API
     */

    public int search(int[] nums, int target) {
        return Arrays.binarySearch(nums, target);
    }

    public static void main(String args[])
    {
        BinarySearch2 ob = new BinarySearch2();
        int arr[] = { -1,0,3,5,9,12 };
        int x = 2;

        int result = ob.search(arr, x);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index "
                    + result);
    }
}
