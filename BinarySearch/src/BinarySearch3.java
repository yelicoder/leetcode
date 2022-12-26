import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BinarySearch3 {

    public static void main(String args[])
    {

        // can not use Collections.binarySearch because the List must be sorted in order to use this approach
        BinarySearch ob = new BinarySearch();
        int arr[] = { -1,0,3,5,9,12 };
        int x = 9;

        List<Integer> targetList  = Arrays.stream( arr ).boxed().collect( Collectors.toList() );


        int result = Collections.binarySearch(targetList, x);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index "
                    + result);
    }

}
