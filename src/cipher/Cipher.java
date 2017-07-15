/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cipher;

/**
 * Simple abstract class to implement basic Ciphers (Caesar/Rot13/Rot47)
 * 
 * Cipher.java (UTF-8) cipher
 *
 * @author Gareth Clabon. 12-Jul-2017 20:37:35
 */
public abstract class Cipher
{

    private static final String LETTERS_26 = "abcdefghijklmnopqrstuvwxyz";
    private static final String LETTERS_47 = "!\"#$%&'()*+,-./0123456789:"
            + ";<=>?@ABCDEFGHIJKLMNOPQRST"
            + "UVWXYZ\\[\\]^_`abcdefghijklm"
            + "nopqrstuvwxyz{|}~";

    /**
     * Encodes a String using a simple alphabetical shift
     *
     * @param useExtendedCharSet Boolean whether extended character set is
     * needed for rot47
     * @param plainText String containing plaintext to be encoded
     * @param shiftBy int number of Characters to shift by
     * @return cipherText String containing the encoded plainText
     */
    private static String getShiftCipher(String plainText, int shiftBy,
            boolean useExtendedCharSet)
    {
        try
        {
            String baseChars;
            char[] oArray;
            String cipherText = "";

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

            int i;
            for (char c : oArray)
            {
                int cPosition = baseChars.indexOf(c);
                int lALength = baseChars.length();
            
                if (c == ' '){
                    cipherText += " ";
                }
                else if ((cPosition + shiftBy) >= lALength)
                {
                    cipherText += baseChars.charAt((cPosition + shiftBy) - lALength);
                }
                else
                {
                    cipherText += baseChars.charAt(cPosition + shiftBy);
                }
                
            }

            return cipherText;
        }
        catch (Exception e)
        {
            throw new IllegalArgumentException(shiftBy
                    + "is not a valid shift");
        }
    }

    /**
     * Encodes a String using a simple Caesar Cipher
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
            return getShiftCipher(lowerCasePT, shiftBy, false);
        }
    }

    /**
     * Encodes a String using a simple Rot13 alphabetical shift
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
            return getShiftCipher(lowerCasePT, 13, false);
        }
    }

    /**
     * Encodes a String using a simple Rot47 ASCII shift
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
            return getShiftCipher(plainText, 47, true);
        }
    }

}
