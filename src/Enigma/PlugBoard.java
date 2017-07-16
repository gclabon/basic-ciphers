package Enigma;

import Utils.Utilities;
import java.util.HashMap;
import java.util.Map;

/**
 * Class representing the PlugBoard on an Enigma machine
 * 
 * ciphers PlugBoard.java (UTF-8) Enigma
 *
 * @author Gareth Clabon. PI: E445736X 16-Jul-2017 10:04:37
 */
public class PlugBoard
{

    public Map<Character, Character> plugMap;

    /**
     * 
     */
    public PlugBoard()
    {
        plugMap = new HashMap<>();
        String s1 = Utilities.shuffleString(Utilities.LETTERS_26);
        String s2 = Utilities.shuffleString(Utilities.LETTERS_26);
        for (int i = 0; i < s1.length(); i++)
        {
            plugMap.put(s1.charAt(i), s2.charAt(i));
        }
    }

    /**
     * 
     * @param c
     * @return 
     */
    public char getCharacterForward(char c){
        return plugMap.get(c);
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
        for (Map.Entry<Character, Character> entry : plugMap.entrySet())
        {
            if (entry.getValue() == c)
            {
                aChar = c;

            }
        }F
        return aChar;
    }

}
