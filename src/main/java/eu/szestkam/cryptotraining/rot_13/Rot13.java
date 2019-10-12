package eu.szestkam.cryptotraining.rot_13;

public class Rot13 {
    private String data;
    private final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public Rot13(String text) {
        this.data = text;
    }

    public Rot13() {
        this.data = "";
    }

    String encode() {
        StringBuilder sb = new StringBuilder();
        for (char ch : data.toCharArray()) {
            if(ALPHABET.contains((ch + "").toUpperCase())) {
                int index = (ALPHABET.indexOf(Character.toUpperCase(ch)) + 13) % 26;
                sb.append(Character.isUpperCase(ch) ? ALPHABET.charAt(index) : ALPHABET.toLowerCase().charAt(index));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
