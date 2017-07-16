package Enigma;

import Utils.Utilities;
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

    private Rotor rightRotor;
    private Rotor middleRotor;
    private Rotor leftRotor;
    private PlugBoard plugboard;

    /**
     * 
     */
    public Enigma()
    {
        rightRotor = new Rotor(1);
        middleRotor = new Rotor(2);
        leftRotor = new Rotor(3);
        plugboard = new PlugBoard();
    }

    
    /**
     * 
     * @param plainText
     * @return 
     */
    public String enigmaEncode(String plainText)
    {
        String cipherText = "";
        for (char c : plainText.toCharArray())
        {
            char cipherChar = 0;
            if (c == ' ' || c == '.')
            {
                cipherChar = c;
            }
            else
            {
                char pbvF = plugboard.getCharacterForward(c);
                char rRF = rightRotor.getCharForward(pbvF);
                char mRF = middleRotor.getCharForward(rRF);
                char lRF = leftRotor.getCharForward(mRF);
                char lRR = leftRotor.getCharReverse(lRF);
                char mRR = middleRotor.getCharReverse(lRR);
                char rRR = rightRotor.getCharReverse(mRR);
                char pbvR = plugboard.getCharReverse(rRR);
                cipherChar = pbvR;
            }
            cipherText += cipherChar;
        }
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

        return cipherText;
    }

    /**
     * 
     * @param cipherText
     * @param rotor1
     * @param rotor2
     * @param rotor3
     * @param plugBoard
     * @return 
     */
    public String enigmaDecode(String cipherText, String rotor1, String rotor2,
            String rotor3, String plugBoard)
    {
        String plainText = "";

        return plainText;
    }


    /**
     * 
     * @param args 
     */
    public static void main(String[] args)
    {
        //New enigma machine
        Enigma e = new Enigma();
        
        //check rotor setups
        
        
        //check plugboard setup
        
    }

}
