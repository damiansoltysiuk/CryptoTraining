package eu.szestkam.cryptotraining.cesar;

public class CesarCipher {
    private String phrase;
    private String ALPHABETH = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    CesarCipher(String text) {
        this.phrase = text;
    }

    CesarCipher() {
        phrase = "";
    }

    public static void main(String[] args) {
        System.out.println(new CesarCipher("dOm").encode());
    }

    String encode() {
        //StringBuilder sb = new StringBuilder();
        String result = "";
        for(char ch : phrase.toCharArray()) {
            int index;
            if(ch >= 65 && ch <= 90) index= (ch + 3) % 64;
            else if(ch >= 97 && ch <= 122) index = ((ch + 3) % 96);
            else if(ch >= 48 && ch <= 57) index = ((ch + 3) % 47);
            else index = ch;
            char _ch = (char)index;

            //sb.append(_ch + "");
            result += String.valueOf((char)index);
        }
        return result;
    }

    String encodeKS() {
        String code = "";
        char[] letters = phrase.toCharArray();
        for(char letter : letters) {
            boolean isLower = isLower(letter);
            Character _char = Character.toUpperCase(letter);
            int val = charIndex(_char);
            int newVal = (val + 3) % 26;
            String newLetter = codeLetter(newVal);
            code += (isLower) ? newLetter.toLowerCase() : newLetter.toUpperCase();

        }
        return code;
    }

    String decrypt() {
        String decode = "";
        char[] letters = phrase.toCharArray();
        for(char letter : letters) {
            boolean isLower = isLower(letter);
            Character _char = Character.toUpperCase(letter);
            int val = charIndex(_char);
            int newVal = (val + 23) % 26;
            String newLetter = codeLetter(newVal);
            decode += (isLower) ? newLetter.toLowerCase() : newLetter.toUpperCase();

        }
        return decode;
    }

    private String codeLetter(int newVal) {
        return String.valueOf(ALPHABETH.charAt(newVal));
    }

    private int charIndex(Character _char) {
        return ALPHABETH.indexOf(_char);
    }

    private boolean isLower(char letter) {
        return Character.isLowerCase(letter);
    }
}
