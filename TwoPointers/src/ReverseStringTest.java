import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReverseStringTest {

    @Test
    public void shouldReverseStringHello() {
        char[] s = {'h','e','l','l','o'};
        char[] expected = {'o','l','l','e','h'};
        ReverseString ob = new ReverseString();
        ob.reverseString(s);
        Assertions.assertArrayEquals(expected, s);
    }

    @Test
    public void shouldReverseStringHannah() {
        char[] s = {'H','a','n','n','a','h'};
        char[] expected = {'h','a','n','n','a', 'H'};
        ReverseString ob = new ReverseString();
        ob.reverseString(s);
        Assertions.assertArrayEquals(expected, s);
    }
}
