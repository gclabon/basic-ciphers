package cipher;

/**
 * Simple abstract class to implement basic substitution ciphers
 * (Caesar/Rot13/Rot47)
 *
 * SubstitutionCiphers.java (UTF-8) cipher
 *
 * @author Gareth Clabon
 */
public abstract class SubstitutionCiphers
{

    static final String LETTERS_26 = "abcdefghijklmnopqrstuvwxyz";
    static final String LETTERS_47 = "!\"#$%&'()*+,-./0123456789:"
            + ";<=>?@ABCDEFGHIJKLMNOPQRST"
            + "UVWXYZ\\[\\]^_`abcdefghijklm"
            + "nopqrstuvwxyz{|}~";

    /**
     * Encodes a String using a simple alphabetical shift/substitution
     *
     * @param useExtendedCharSet Boolean whether extended character set is
     * needed for rot47
     * @param plainText String containing plaintext to be encoded
     * @param shiftBy int number of Characters to shift by
     * @return cipherText String containing the encoded plainText
     */
    private static String getSubstitutionCipher(String plainText, int shiftBy,
            boolean useExtendedCharSet)
    {
        try
        {
            String baseChars;
            char[] oArray;

            //If Rot47 use extended character set, otherwise use lower case
            if (useExtendedCharSet)
            {
                baseChars = LETTERS_47;
                oArray = plainText.toCharArray();
            }
            else
            {
                baseChars = LETTERS_26;
                oArray = plainText.toCharArray();
            }

            return getSubstitution(oArray, baseChars, shiftBy,
                    useExtendedCharSet);

        }
        catch (Exception e)
        {
            throw new IllegalArgumentException(shiftBy
                    + "is not a valid shift");
        }
    }

    /**
     * Performs character by character substitution on a char[]
     *
     * @throws IllegalArgumentException If shiftBy < 0
     * @param oArray char[] original array
     * @param baseChars String containing base characters to shift on
     * @param shiftBy int number of places to shift to find char to substitute
     * @return substitutedString String containing substituted chars
     */
    static String getSubstitution(char[] oArray, String baseChars,
            int shiftBy, Boolean usingExtended) throws IllegalArgumentException
    {
        if (shiftBy < 0)
        {
            throw new IllegalArgumentException("Cannot shift by < 0");
        }
        else
        {
            String substitutedString = "";
            for (char c : oArray)
            {
                int cPosition = baseChars.indexOf(c);
                int lALength = baseChars.length();
                char nextChar;
                if (c == ' ')
                {
                    nextChar = c;
                }
                else if (!usingExtended && c == '.')
                {
                    nextChar = c;
                }
                else if ((cPosition + shiftBy) >= lALength)
                {
                    nextChar = baseChars.charAt(
                            (cPosition + shiftBy) - lALength);
                }
                else
                {
                    nextChar = baseChars.charAt(cPosition + shiftBy);
                }
                substitutedString += nextChar;
            }
            return substitutedString;
        }

    }

    /**
     * Encodes a String using a simple Caesar Substitution Ciphers
     *
     * @throws IllegalArgumentException If plainText does not contain only
     * alphabetical chars.
     * @param plainText String containing plaintext to be encoded
     * @param shiftBy int Number of Characters to shift by
     * @return cipherText String containing the encoded plainText
     */
    public static String getCaesarCipher(String plainText, int shiftBy)
            throws IllegalArgumentException
    {
        String lowerCasePT = plainText.toLowerCase();
        //Check plaintext contains only alphabetical chars
        if (!lowerCasePT.matches("^[" + LETTERS_26 + "[ ]]*$"))
        {
            throw new IllegalArgumentException(
                    "Caesar Cipher cannot contain non-alphabetical characters");
        }
        else
        {
            return getSubstitutionCipher(lowerCasePT, shiftBy, false);
        }
    }

    /**
     * Encodes a String using a simple Rot13 alphabetical shift/substitution
     *
     * @throws IllegalArgumentException If plainText does not contain only
     * alphabetical chars.
     * @param plainText String containing plaintext to be encoded
     * @return cipherText String containing the encoded plainText
     */
    public static String getRot13(String plainText)
            throws IllegalArgumentException
    {
        String lowerCasePT = plainText.toLowerCase();
        //Check plainText contains only alphabetical chars
        if (!lowerCasePT.matches("^[" + LETTERS_26 + "[ ]]*$"))
        {
            throw new IllegalArgumentException(
                    "Caesar Cipher cannot contain non-alphabetical characters");
        }
        else
        {
            return getSubstitutionCipher(lowerCasePT, 13, false);
        }
    }

    /**
     * Encodes a String using a simple Rot47 ASCII shift/substitution
     *
     * @throws IllegalArgumentException If plainText does not contain only
     * ASCII[33, 126] chars.
     * @param plainText String containing plaintext to be encoded
     * @return cipherText String containing the encoded plainText
     */
    public static String getRot47(String plainText)
    {
        if (!plainText.matches("^[" + LETTERS_47 + "[ ]]*$"))
        {
            throw new IllegalArgumentException(
                    "Rot47 must contain only ASCII[33, 126] characters");
        }
        else
        {
            return getSubstitutionCipher(plainText, 47, true);
        }
    }

}
