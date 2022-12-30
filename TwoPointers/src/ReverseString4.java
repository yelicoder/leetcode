import java.util.Arrays;

public class ReverseString4 {
    /*
    Write a function that reverses a string. The input string is given as an array of
    characters s.

    You must do this by modifying the input array in-place with O(1) extra memory.

        Example 1:

        Input: s = ["h","e","l","l","o"]
        Output: ["o","l","l","e","h"]
        Example 2:

        Input: s = ["H","a","n","n","a","h"]
        Output: ["h","a","n","n","a","H"]


        Constraints:

        1 <= s.length <= 105
        s[i] is a printable ascii character.
     */

/*
performance 35. memory 67
use recursive
 */
    public void reverseString(char[] s) {
        helper(s, 0, s.length - 1);
      }

    public void helper(char[] s, int left, int right) {
        if (left >= right) return;
        char tmp = s[left];
        s[left++] = s[right];
        s[right--] = tmp;
        helper(s, left, right);
    }

    public static void main (String[] args) {
        char[] s = {'h','e','l','l','o'};
        char[] s1 = {'H','a','n','n','a','h'};

        ReverseString4 ob = new ReverseString4();
        System.out.println(Arrays.toString(s));
        System.out.println(Arrays.toString(s1));
        ob.reverseString(s);
        ob.reverseString(s1);
        System.out.println(Arrays.toString(s));
        System.out.println(Arrays.toString(s1));
    }
}
