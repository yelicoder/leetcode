import java.util.Scanner;

public class RomanToInteger {

    /*
    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
    Symbol       Value
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000

    For example, 2 is written as II in Roman numeral, just two ones added together.
    12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

    Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.
    Given a roman numeral, convert it to an integer.

    Example 1:

    Input: s = "III"
    Output: 3
    Explanation: III = 3.

    Example 2:

    Input: s = "LVIII"
    Output: 58
    Explanation: L = 50, V= 5, III = 3.

    Example 3:

    Input: s = "MCMXCIV"
    Output: 1994
    Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.


    Constraints:

    1 <= s.length <= 15
    s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
    It is guaranteed that s is a valid roman numeral in the range [1, 3999].

     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        char[] tmp = input.toCharArray();

        int number =0;
        String explanation = "";

        for (int i = 0; i<tmp.length; i++) {
            char char1 = tmp[i];

            switch (char1) {
                case 'M':
                    number = number + 1000;
                    explanation = explanation + "M = 1000, ";
                    break;
                case 'D':
                    number = number + 500;
                    explanation = explanation + "D = 500, ";
                    break;
                case 'C':
                    if ( (i<tmp.length-1) && (tmp[i+1] =='M')) {
                        number = number + 900;
                        explanation = explanation + "CM = 900, ";
                        i++;
                    } else if ((i<tmp.length-1) && (tmp[i+1] =='D')) {
                        number = number + 400;
                        explanation = explanation + "CD = 400, ";
                        i++;
                    } else {
                        number = number + 100;
                        explanation = explanation + "C = 100, ";
                    }
                    break;
                case 'L':
                    number = number + 50;
                    explanation = explanation + "L = 50, ";
                    break;
                case 'X':
                    if ((i<tmp.length-1) && (tmp[i+1] =='C')) {
                        number = number + 90;
                        explanation = explanation + "XC = 90, ";
                        i++;
                    } else if ((i<tmp.length-1) && (tmp[i+1] =='L')) {
                        number = number + 40;
                        explanation = explanation + "XL = 40, ";
                        i++;
                    } else {
                        number = number + 10;
                        explanation = explanation + "X = 10, ";
                    }
                    break;
                case 'V':
                    number = number + 5;
                    explanation = explanation + "V = 5, ";
                    break;
                case 'I':
                    if ((i<tmp.length-1) && (tmp[i+1] =='X')) {
                        number = number + 9;
                        explanation = explanation + "IX = 9 , ";
                        i++;
                    } else if ((i<tmp.length-1) && (tmp[i+1] =='V')) {
                        number = number + 4;
                        explanation = explanation + "IV = 4, ";
                        i++;
                    } else if ((i<tmp.length-2) && (tmp[i+1] =='I') && (tmp[i+2] =='I')){
                        number = number + 3;
                        explanation = explanation + "III = 3";
                        i=i+2;
                    } else if ((i<tmp.length-1) && (tmp[i+1] =='I') ) {
                        number = number + 2;
                        explanation = explanation + "II = 2";
                        i++;
                    } else {
                        number = number + 1;
                        explanation = explanation + "I = 1";
                    }
                    break;
            }
        }
        System.out.println("Input: s = " + input);
        System.out.println("Output: " + number);
        System.out.println("Explanation: " + explanation);
    }
}
