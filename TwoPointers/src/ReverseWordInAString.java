import java.util.StringTokenizer;

public class ReverseWordInAString {
    /*
    Given a string s, reverse the order of characters in each word within a
    sentence while still preserving whitespace and initial word order.

        Example 1:

        Input: s = "Let's take LeetCode contest"
        Output: "s'teL ekat edoCteeL tsetnoc"
        Example 2:

        Input: s = "God Ding"
        Output: "doG gniD"


        Constraints:

        1 <= s.length <= 5 * 104
        s contains printable ASCII characters.
        s does not contain any leading or trailing spaces.
        There is at least one word in s.
        All the words in s are separated by a single space.
     */
/*
run 58 mem 74
 */
    public String reverseWords(String s) {
        StringBuffer newSb = new StringBuffer();
        String[] tmp = s.split("\\s");

        for (int i=0; i<tmp.length; i++){
            StringBuffer sb = new StringBuffer(tmp[i]);
            newSb.append(sb.reverse());
            newSb.append(" ");
        }
        return newSb.toString().trim();
    }

    public static void main (String[] args) {
        String s = "Let's take LeetCode contest";
        String s1 = "God Ding";
        ReverseWordInAString ob = new ReverseWordInAString();
        System.out.println(ob.reverseWords(s));
        System.out.println(ob.reverseWords(s1));
    }
}
