package cipher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * Enigma.java (UTF-8) Class representing the Enigma Machine cipher
 * implementation
 *
 * @author Gareth Clabon 15-Jul-2017
 */
public class Enigma
{

    private String rightRotor;
    private String middleRotor;
    private String leftRotor;
    private Map<Character, Character> plugboard;

    public Enigma()
    {
        StringBuilder sb = new StringBuilder(
                cipher.SubstitutionCiphers.LETTERS_26);
        rightRotor = fillRotor(sb);
        middleRotor = fillRotor(sb);
        leftRotor = fillRotor(sb);
        plugboard = generatePlugBoard();
    }

    
    
    
    
    public String enigmaEncode(String plainText)
    {
        String cipherText = "";

        for (int i = 0; i < plainText.length(); i++)
        {
            //get plugboard character
            //pass to right
            //rotate rotor 1
            //pass to rotor 2
            //check for rotate rotor 2
            //pass to rotor 3
            //check for rotate rotor 3
            //pass to rotor2
            //pass to rotor1
            //pas via plugboard
        }
        
        return cipherText;
    }

    
    
    
    
    public String enigmaDecode(String cipherText, String rotor1, String rotor2,
            String rotor3, String plugBoard)
    {
        String plainText = "";

        return plainText;
    }

    
    
    
    
    private String fillRotor(StringBuilder sb)
    {
        String aString = "";
        Random r = new Random();
        for (int i = 0; i < sb.length(); i++)
        {
            int p = r.nextInt(sb.length());
            aString += sb.charAt(p);

        }
        return aString;
    }

    
    
    
    
    private Map<Character, Character> generatePlugBoard()
    {
        Map<Character, Character> tempMap = new HashMap<>();
        StringBuilder sb1 = new StringBuilder(shuffleString(
                cipher.SubstitutionCiphers.LETTERS_26));
        StringBuilder sb2 = new StringBuilder(shuffleString(
                cipher.SubstitutionCiphers.LETTERS_26));

        for (int i = 0; i < sb1.length(); i++)
        {
            tempMap.put(sb1.charAt(i), sb2.charAt(i));
        }
        return tempMap;
    }

    
    
    
    
    private String shuffleString(String aString)
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

    
    
    
    
    public static void main(String[] args)
    {
        Enigma e = new Enigma();
        System.out.println(e.rightRotor);
        System.out.println(e.middleRotor);
        System.out.println(e.leftRotor);
        for (Character c : e.plugboard.keySet())
        {
            System.out.println(c + "," + e.plugboard.get(c));
        }
    }

}
