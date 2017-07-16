package Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ciphers Utilities.java (UTF-8) Utils
 *
 * @author Gareth Clabon.
 */
public class Utilities
{

    public static final String LETTERS_26 = "abcdefghijklmnopqrstuvwxyz";
    public static final String LETTERS_47 = "!\"#$%&'()*+,-./0123456789:"
            + ";<=>?@ABCDEFGHIJKLMNOPQRST"
            + "UVWXYZ\\[\\]^_`abcdefghijklm"
            + "nopqrstuvwxyz{|}~";

    /**
     * Randomly shuffles characters in a string.
     *
     * @param aString The String to be shuffled.
     * @return A String containing shuffled characters of aString
     */
    public static String shuffleString(String aString)
    {
        List<Character> l = new ArrayList<>();
        for (char c : aString.toCharArray())
        {
            l.add(c);
        }
        Collections.shuffle(l);
        StringBuilder sb = new StringBuilder();
        for (char c : l)
        {
            sb.append(c);
        }
        return sb.toString();
    }

}
