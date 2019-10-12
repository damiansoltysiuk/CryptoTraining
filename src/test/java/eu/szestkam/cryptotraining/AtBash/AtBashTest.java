package eu.szestkam.cryptotraining.AtBash;

import eu.szestkam.cryptotraining.vigenere.Vigenere;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AtBashTest {

    private static final String SAMPLE_PHRASE = "sample";
    private AtBash cipherNoArg;
    private AtBash cipherPhrase;

    @BeforeEach
    void setUp() {
        cipherNoArg = new AtBash();
        cipherPhrase = new AtBash(SAMPLE_PHRASE);
    }

    @DisplayName("Correct cipher instance with no args")
    @Test
    void testIfCesarExist() {
        AtBash cipher = cipherNoArg;
        assertNotNull(cipher);
    }

    @DisplayName("Correct cipher instance with phrase")
    @Test
    void testPassStringToConstructor() {
        AtBash cipher = cipherPhrase;
        assertNotNull(cipher);
    }

    @Test
    void testEncrypWhenNoTextThenEmptyString() {
        AtBash cipher = cipherNoArg;
        String encoded = cipher.encode();

        assertNotNull(encoded);
        assertEquals("", encoded);
    }

    @Test
    void testEncrypWhenTextThenSameLenghtOfString() {
        AtBash cipher = cipherPhrase;
        String encoded = cipher.encode();

        assertNotNull(encoded);
        assertEquals(SAMPLE_PHRASE.length(), encoded.length());
    }


    @Test
    void lowerLetterEncodeTest() {
        assertEquals("zyxv", new AtBash("abcd").encode());
    }

    @Test
    void mixedLetterEncodeTest() {
        assertEquals("AZby", new AtBash("ZAyb").encode());
    }

    @Test
    void digitsEncodeTest() {
        assertEquals("9876", new AtBash("0123").encode());
        assertEquals("0123", new AtBash("9876").encode());
    }

    @Test
    void otherSymbolEncodeTest() {
        assertEquals("73127&(*&*(*", new AtBash("26872&(*&*(*").encode());
    }

    @Test
    void lowerLetterDecodeTest() {
        assertEquals("abcd", new AtBash("zyxv").encode());
    }

    @Test
    void mixedLetterDecodeTest() {
        assertEquals("ZAyb", new AtBash("AZby").encode());
    }

}