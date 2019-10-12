package eu.szestkam.cryptotraining.vigenere;

public class Vigenere {
    private String key = "kjfcmdaklslmdsakl";
    private final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private String date;

    public Vigenere(String message) {
        this.date = message;
    }

    public Vigenere() {
        this.date = "";
    }

    String encode() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < date.length(); i++) {
            char ch = date.charAt(i);
            if (ALPHABET.contains(String.valueOf(ch).toLowerCase())) {
                boolean lowerCase = Character.isLowerCase(ch);
                int index = (ALPHABET.indexOf(String.valueOf(ch).toLowerCase()) + ALPHABET.indexOf(key.charAt(i % key.length()))) % 26;
                sb.append(lowerCase ? ALPHABET.charAt(index) : ALPHABET.toUpperCase().charAt(index));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    String decode() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < date.length(); i++) {
            char ch = date.charAt(i);
            if (ALPHABET.contains(String.valueOf(ch).toLowerCase())) {
                boolean lowerCase = Character.isLowerCase(ch);
                int index = (ALPHABET.indexOf(String.valueOf(ch).toLowerCase()) + 26 - ALPHABET.indexOf(key.charAt(i % key.length()))) % 26;
                sb.append(lowerCase ? ALPHABET.charAt(index) : ALPHABET.toUpperCase().charAt(index));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
