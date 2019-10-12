package eu.szestkam.cryptotraining.matrix;

import eu.szestkam.cryptotraining.vigenere.Vigenere;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixKryptTest {

    private static final String SAMPLE_PHRASE = "sample";
    private MatrixKrypt cipherNoArg;
    private MatrixKrypt cipherPhrase;

    @BeforeEach
    void setUp() {
        cipherNoArg = new MatrixKrypt();
        cipherPhrase = new MatrixKrypt(SAMPLE_PHRASE);
    }

    @DisplayName("Correct cipher instance with no args")
    @Test
    void testIfCesarExist() {
        MatrixKrypt cipher = cipherNoArg;
        assertNotNull(cipher);
    }

    @DisplayName("Correct cipher instance with phrase")
    @Test
    void testPassStringToConstructor() {
        MatrixKrypt cipher = cipherPhrase;
        assertNotNull(cipher);
    }

    @Test
    void testEncrypWhenNoTextThenEmptyString() {
        MatrixKrypt cipher = cipherNoArg;
        String encoded = cipher.encode();

        assertNotNull(encoded);
        assertEquals("", encoded);
    }

    @Test
    void testEncrypWhenTextThenSameLenghtOfString() {
        MatrixKrypt cipher = cipherPhrase;
        String encoded = cipher.encode();

        assertNotNull(encoded);
        assertEquals(SAMPLE_PHRASE.length(), encoded.length());
    }


    @Test
    void lowerLetterEncodeTest() {
        assertEquals("ad bw c", new MatrixKrypt("abcdw").encode());
    }

    @Test
    void mixedLetterEncodeTest() {
        assertEquals("AyStalttungmrryoyuycrikDh", new MatrixKrypt("AlgorytmyiStrukturyDanych").encode());
    }


    @Test
    void lowerLetterDecodeTest() {
        assertEquals("abcdw", new MatrixKrypt("ad bw c").encode());
    }

    @Test
    void mixedLetterDecodeTest() {
        assertEquals("AlgorytmyiStrukturyDanych", new MatrixKrypt("AyStalttungmrryoyuycrikDh").encode());
    }

}