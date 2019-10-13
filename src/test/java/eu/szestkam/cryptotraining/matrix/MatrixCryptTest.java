package eu.szestkam.cryptotraining.matrix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;

import static org.junit.jupiter.api.Assertions.*;

class MatrixCryptTest {

    private static final String SAMPLE_PHRASE = "sample";
    private MatrixCrypt cipherNoArg;
    private MatrixCrypt cipherPhrase;

    @BeforeEach
    void setUp() {
        cipherNoArg = new MatrixCrypt();
        cipherPhrase = new MatrixCrypt(SAMPLE_PHRASE);
    }

    @DisplayName("Correct cipher instance with no args")
    @Test
    void testIfCesarExist() {
        MatrixCrypt cipher = cipherNoArg;
        assertNotNull(cipher);
    }

    @DisplayName("Correct cipher instance with phrase")
    @Test
    void testPassStringToConstructor() {
        MatrixCrypt cipher = cipherPhrase;
        assertNotNull(cipher);
    }

    @Test
    void testEncrypWhenNoTextThenEmptyString() {
        MatrixCrypt cipher = cipherNoArg;
        String encoded = cipher.encode();

        assertNotNull(encoded);
        assertEquals("", encoded);
    }

    @Test
    void testEncrypWhenTextThenSameLenghtOfString() {
        MatrixCrypt cipher = cipherPhrase;
        String encoded = cipher.encode();

        assertNotNull(encoded);
        assertEquals((int)Math.pow(Math.ceil(Math.sqrt(SAMPLE_PHRASE.length())),2), encoded.length());
    }


    @Test
    void lowerLetterEncodeTest() {
        assertTrue(new MatrixCrypt("abcdw").encode().matches("ad\\Wbw\\Wc\\W{2}"));
    }

    @Test
    void mixedLetterEncodeTest() {
        assertEquals("AyStalttungmrryoyuycrikDh", new MatrixCrypt("AlgorytmyiStrukturyDanych").encode());
    }


    @Test
    void lowerLetterDecodeTest() {
        String messege = "abcdw";
        MatrixCrypt mc = new MatrixCrypt(messege);
        String encode = mc.encode();
        String decode = mc.decode();
        assertEquals(messege, decode);
    }

    @Test
    void mixedLetterDecodeTest() {
        String messege = "AlgorytmyiStrukturyDanych";
        MatrixCrypt mc = new MatrixCrypt(messege);
        String encode = mc.encode();
        String decode = mc.decode();
        assertEquals(messege, decode);
        assertEquals(messege, decode);
    }

}