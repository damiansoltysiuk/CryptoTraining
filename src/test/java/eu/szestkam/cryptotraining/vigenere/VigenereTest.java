package eu.szestkam.cryptotraining.vigenere;

import eu.szestkam.cryptotraining.cesar.CesarCipher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VigenereTest {

    private static final String SAMPLE_PHRASE = "sample";
    private Vigenere cipherNoArg;
    private Vigenere cipherPhrase;

    @BeforeEach
    void setUp() {
        cipherNoArg = new Vigenere();
        cipherPhrase = new Vigenere(SAMPLE_PHRASE);
    }

    @DisplayName("Correct cipher instance with no args")
    @Test
    void testIfCesarExist() {
        Vigenere cipher = cipherNoArg;
        assertNotNull(cipher);
    }

    @DisplayName("Correct cipher instance with phrase")
    @Test
    void testPassStringToConstructor() {
        Vigenere cipher = cipherPhrase;
        assertNotNull(cipher);
    }

    @Test
    void testEncrypWhenNoTextThenEmptyString() {
        Vigenere cipher = cipherNoArg;
        String encoded = cipher.encode();

        assertNotNull(encoded);
        assertEquals("", encoded);
    }

    @Test
    void testEncrypWhenTextThenSameLenghtOfString() {
        Vigenere cipher = cipherPhrase;
        String encoded = cipher.encode();

        assertNotNull(encoded);
        assertEquals(SAMPLE_PHRASE.length(), encoded.length());
    }


    @Test
    void lowerLetterEncodeTest() {
        assertEquals("kkhfi", new Vigenere("abcdw").encode());
    }

    @Test
    void mixedLetterEncodeTest() {
        assertEquals("kkhFI", new Vigenere("abcDW").encode());
    }

    @Test
    void otherSymbolEncodeTest() {
        assertEquals("73127&(*&*(*", new Vigenere("73127&(*&*(*").encode());
    }

    @Test
    void lowerLetterDecodeTest() {
        assertEquals("abcdw", new Vigenere("kkhfi").decode());
    }

    @Test
    void mixedLetterDecodeTest() {
        assertEquals("abcDW", new Vigenere("kkhFI").decode());
    }

    @Test
    void otherSymbolDecodeTest() {
        assertEquals("73127&(*&*(*", new Vigenere("73127&(*&*(*").encode());
    }



}