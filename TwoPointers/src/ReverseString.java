import java.util.Arrays;

public class ReverseString {
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
performance 99. memory 77
 */
    public void reverseString(char[] s) {
        int l =0;
        int r = s.length-1;
        while (l<r) {
            swap(s,l,r);
            l++;
            r--;
        }
    }

    public void swap(char[] s, int l, int r) {
        char tmp = s[l];
        s[l] = s[r];
        s[r] = tmp;
    }

    public static void main (String[] args) {
        char[] s = {'h','e','l','l','o'};
        char[] s1 = {'H','a','n','n','a','h'};

        ReverseString ob = new ReverseString();
        System.out.println(Arrays.toString(s));
        System.out.println(Arrays.toString(s1));
        ob.reverseString(s);
        ob.reverseString(s1);
        System.out.println(Arrays.toString(s));
        System.out.println(Arrays.toString(s1));
    }
}
