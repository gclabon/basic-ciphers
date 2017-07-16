/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enigma;

import Utils.Utilities;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * ciphers Rotor.java (UTF-8) Enigma
 *
 * @author Gareth Clabon. PI: E445736X 16-Jul-2017 10:04:25
 */
public class Rotor
{

    private int charCount;
    private int rotateEvery;
    private Map<Character, Character> ringMap;

    /**
     * 
     * @param rotorPosition 
     */
    public Rotor(int rotorPosition)
    {

    }

    //Moves character from key 0 to final key
    private void rotateRotor()
    {

        ringMap = ;
    }

    //
    private Map<Character, Character> fillRings()
    {
        ringMap = new HashMap<>();
        String s1 = Utilities.shuffleString(Utilities.LETTERS_26);
        String s2 = Utilities.shuffleString(Utilities.LETTERS_26);
        for (int i = 0; i < s1.length(); i++)
        {
            ringMap.put(s1.charAt(i), s2.charAt(i));
        }
        return ringMap;
    }

    /**
     * 
     * @param c
     * @param aRing
     * @return 
     */
    public char getCharForward(char c)
    {
        char aChar = ringMap.get(c);
        rotateRotor();
        return aChar;
    }

    /**
     * 
     * @param c
     * @param aRing
     * @return 
     */
    public char getCharReverse(char c)
    {
        char aChar;
        for (Entry<Character, Character> entry : ringMap.entrySet())

        {

            if (entry.getValue() == c)
            {
                aChar = c;

            }
        }
        rotateRotor();
        return aChar;
    }

}
