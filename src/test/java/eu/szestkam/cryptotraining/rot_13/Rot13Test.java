package eu.szestkam.cryptotraining.rot_13;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Rot13Test {

    private static final String SAMPLE_PHRASE = "sample";
    private Rot13 cipherNoArg;
    private Rot13 cipherPhrase;

    @BeforeEach
    void setUp() {
        cipherNoArg = new Rot13();
        cipherPhrase = new Rot13(SAMPLE_PHRASE);
    }

    @DisplayName("Correct cipher instance with no args")
    @Test
    public void testIfCesarExist() {
        Rot13 cipher = cipherNoArg;
        assertNotNull(cipher);
    }

    @DisplayName("Correct cipher instance with phrase")
    @Test
    public void testPassStringToConstructor() {
        Rot13 cipher = cipherPhrase;
        assertNotNull(cipher);
    }

    @Test
    public void testEncrypWhenNoTextThenEmptyString() {
        Rot13 cipher = cipherNoArg;
        String encoded = cipher.encode();

        assertNotNull(encoded);
        assertEquals("", encoded);
    }

    @Test
    public void MixedLetterTest() {
        assertEquals("nopqRSTU123", new Rot13("abcdEFGH123").encode());
        assertEquals("Nytbelgzl v Fgehxghen Qnalpu", new Rot13("Algorytmy i Struktura Danych").encode());
        assertEquals("14315612^%@!^%@!^%%^#", new Rot13("14315612^%@!^%@!^%%^#").encode());
    }
}