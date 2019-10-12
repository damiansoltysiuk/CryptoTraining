package eu.szestkam.cryptotraining.cesar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CesarCipherTest {

    private static final String SAMPLE_PHRASE = "sample";
    private CesarCipher cipherNoArg;
    private CesarCipher cipherPhrase;

    @BeforeEach
    void setUp() {
        cipherNoArg = new CesarCipher();
        cipherPhrase = new CesarCipher(SAMPLE_PHRASE);
    }

    @DisplayName("Correct cipher instance with no args")
    @Test
    public void testIfCesarExist() {
        CesarCipher cipher = cipherNoArg;
        assertNotNull(cipher);
    }

    @DisplayName("Correct cipher instance with phrase")
    @Test
    public void testPassStringToConstructor() {
        CesarCipher cipher = cipherPhrase;
        assertNotNull(cipher);
    }

    @Test
    public void testEncrypWhenNoTextThenEmptyString() {
        CesarCipher cipher = cipherNoArg;
        String encoded = cipher.encode();

        assertNotNull(encoded);
        assertEquals("", encoded);
    }

    @Test
    public void testEncrypWhenTextThenSameLenghtOfString() {
        CesarCipher cipher = cipherPhrase;
        String encoded = cipher.encode();

        assertNotNull(encoded);
        assertEquals(SAMPLE_PHRASE.length(), encoded.length());
    }

    @Test
    public void testSimpleEncodeLowerCase() {
        CesarCipher cipher = new CesarCipher("abc");
        String code = "def";
        String encode = cipher.encodeKS();
        assertEquals(code, encode);

        cipher = new CesarCipher("xyz");
        code = "abc";
        encode = cipher.encodeKS();
        assertEquals(code, encode);

    }

    @Test
    public void testSimpleEncodeMixedCase() {
        CesarCipher cipher = new CesarCipher("abC");
        String code = "deF";
        String encode = cipher.encode();
        assertEquals(code, encode);

        cipher = new CesarCipher("xyZ");
        code = "abC";
        encode = cipher.encode();
        assertEquals(code, encode);
    }

    @Test
    public void testDecode() {
        CesarCipher cipher = new CesarCipher("deF");
        String code = "abC";
        String encoded = cipher.decrypt();
        assertEquals(code, encoded);
    }

//    @Test
//    public void onlySmallLetterTest() {
//        assertEquals("gdpldq", new CesarCipher("damian").decode());
//        assertEquals("grp", new CesarCipher("dom").decode());
//        assertEquals("nrw", new CesarCipher("kot").decode());
//    }

//    @Test
//    public void onlyBigletterTest() {
//        assertEquals("GDPLDQ", CesarCipher.decode("DAMIAN"));
//        assertEquals("GRP", CesarCipher.decode("DOM"));
//        assertEquals("NRW", CesarCipher.decode("KOT"));
//    }
//
//    @Test
//    public void letterTest() {
//        assertEquals("abcDEF", CesarCipher.decode("xyzABC"));
//        assertEquals("abc DEF", CesarCipher.decode("xyz ABC"));
//    }
//
//    @Test
//    public void digitsTest() {
//        assertEquals("2134", CesarCipher.decode("9801"));
//        assertEquals("22 66", CesarCipher.decode("99 33"));
//    }
//
//    @Test
//    void specialSymbolsTest() {
//        assertEquals("....", CesarCipher.decode("...."));
//        assertEquals("!@#$", CesarCipher.decode("!@#$"));
//    }
//
//    @Test
//    void fullTest() {
//        assertEquals("DEFghi456!@#$", CesarCipher.decode("ABCdef123!@#$"));
//    }

}
