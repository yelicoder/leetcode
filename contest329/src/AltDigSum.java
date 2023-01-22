import java.util.ArrayList;

public class AltDigSum {
    /*
    You are given a positive integer n. Each digit of n has a sign according to the following rules:

The most significant digit is assigned a positive sign.
Each other digit has an opposite sign to its adjacent digits.
Return the sum of all digits with their corresponding sign.



Example 1:

Input: n = 521
Output: 4
Explanation: (+5) + (-2) + (+1) = 4.
Example 2:

Input: n = 111
Output: 1
Explanation: (+1) + (-1) + (+1) = 1.
Example 3:

Input: n = 886996
Output: 0
Explanation: (+8) + (-8) + (+6) + (-9) + (+9) + (-6) = 0.


Constraints:

1 <= n <= 109
     */

    public int alternateDigitSum(int n) {
        int temp = n;
        ArrayList<Integer> array = new ArrayList<Integer>();
        do{
            array.add(temp % 10);
            temp /= 10;
        } while  (temp > 0);

        int sum = 0;
        int sign = 1;

        for (int i=array.size()-1; i>=0; i-- ) {
            sum = sum + sign* array.get(i);
            sign = sign* (-1);
        }

        return sum;
    }

    public static void main(String[] args) {
        AltDigSum o = new AltDigSum();
        System.out.println(o.alternateDigitSum(521));
        System.out.println(o.alternateDigitSum(111));
        System.out.println(o.alternateDigitSum(886996));
        System.out.println(o.alternateDigitSum(10));
    }
}
