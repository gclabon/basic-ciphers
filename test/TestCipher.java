/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import cipher.*;

/**
 * Basic JUnit tests for cipher class
 *
 * @author Gareth Clabon. PI: E445736X
 */
public class TestCipher
{

    public TestCipher()
    {

    }
    
    //Caesar Cipher Tests

    /**
     * Test shift of 1 at beginning of alphabet
     */
    @Test
    public void test1GetCaesarCipher()
    {
        assert Cipher.getCaesarCipher("abc", 1).equals("bcd") : "abc with a shift of 1 should return bcd";
    }

    /**
     * Test shift of 1 at end of alphabet
     */
    @Test
    public void test2GetCaesarCipher()
    {
        assert Cipher.getCaesarCipher("xyz", 1).equals("yza") : "xyz with a shift of 1 should return yza";
    }

    /**
     * Test shift of length of alphabet
     */
    @Test
    public void test3GetCaesarCipher()
    {
        assert Cipher.getCaesarCipher("abc", 26).equals("abc") : "abc with a shift of 26 should return abc";
    }

    /**
     * Test cannot use a negative shift
     */
    @Test
    public void test4GetCaesarCipher()
    {
        boolean thrown = false;

        try
        {
            Cipher.getCaesarCipher("abc", -1);
        }
        catch (IllegalArgumentException e)
        {
            thrown = true;
        }
        assert (thrown) : "Illegal Argument Exception should have been thrown for -1 shift";
    }

    /**
     * Test cannot use an illegal character
     */
    @Test
    public void test5GetCaesarCipher()
    {
        Boolean thrown = false;
        try
        {
            Cipher.getCaesarCipher("!", 1);
        }
        catch (IllegalArgumentException e)
        {
            thrown = true;
        }
        assert (thrown) : "Illegal Argument Exception should have been thrown for !";
    }

    /**
     * Test using spaces
     */
    @Test
    public void test6GetCaesarCipher()
    {
        assert Cipher.getCaesarCipher("abc def", 1).equals("bcd efg") : "Should equal \"bcd efg\"";
    }

    
    //Rot13 Tests
    
    /**
     * Test shift at start at alphabet
     */
    @Test
    public void test1GetRot13()
    {
        assert Cipher.getRot13("abc").equals("nop") : "abc using Rot13 shoulf return nop";
    }

    /**
     * Test shift at end of alphabet
     */
    @Test
    public void test2GetRot13()
    {
        assert Cipher.getRot13("xyz").equals("klm") : "xyz using Rot13 should return klm";
    }

    /**
     * Test cannot use an illegal character
     */
    @Test
    public void test3GetRot13()
    {
        boolean thrown = false;

        try
        {
            Cipher.getRot13("!");
        }
        catch (IllegalArgumentException e)
        {
            thrown = true;
        }
        assert (thrown) : "Illegal Argument Exception should have been thrown for !";
    }

    /**
     * Test spaces
     */
    @Test
    public void test4GetRot13()
    {
        assert Cipher.getRot13("abc def").equals("nop qrs") : "abc def using Rot13 should return nop qrs";
    }
    
    //Rot 47 Tests

    /**
     * Test shift at start of ASCII character string
     */
    @Test
    public void test1GetRot47()
    {
        assert Cipher.getRot47("abc").equals("234") : "abc using Rot47 should return 234";
    }

    /**
     * Test Shift at end of ASCII character string
     */
    @Test
    public void test2GetRot47()
    {
        assert Cipher.getRot47("|}~").equals("MNO") : "xyz using Rot47 should return MNO";
    }
    
    /**
     * Test Rot47 with spaces
     */
    @Test
    public void test3GetRot47()
    {
        assert Cipher.getRot47("abc |}~").equals("234 MNO") : "abc |}~ using Rot47 should return 234 MNO";
    }
    /**
     * Test cannot use illegal characters
     */
    @Test
    public void test4GetRot47()
    {
        boolean thrown = false;

        try
        {
            Cipher.getRot47("é");
        }
        catch (IllegalArgumentException e)
        {
            thrown = true;
        }
        assert (thrown) : "Illegal Argument Exception should have been thrown for é";
    }

}
