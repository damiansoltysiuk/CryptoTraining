package eu.szestkam.cryptotraining.matrix;

import java.util.Random;

public class MatrixCrypt {
    private String date;
    private String code = "";

    public MatrixCrypt() {
        date = "";
    }

    public MatrixCrypt(String messege) {
        this.date = messege;
    }

    String encode() {
        int side = (int)Math.ceil(Math.sqrt(date.length()));
        if (side < 2) return date;
        StringBuilder sb = new StringBuilder(date);
        while (sb.length() != side * side) {
            int i = new Random().nextInt(16) + 32;
            sb.append((char)i);
        }
        char[] chars = new char[sb.length()];
        for(int i = 0; i < side; i++) {
            for(int j = 0; j < side; j++) {
                char ch = sb.toString().charAt(i + side * j);
                chars[i * side + j] = ch;
            }
        }
        code = String.valueOf(chars);
        return code;
    }

    String decode() {
        int side = (int)Math.ceil(Math.sqrt(code.length()));
        if (side < 2) return code;
        StringBuilder sb = new StringBuilder(code);
        while (sb.length() != side * side) {
            int i = new Random().nextInt(16) + 32;
            sb.append((char)i);
        }
        char[] chars = new char[sb.length()];
        for(int i = 0; i < side; i++) {
            for(int j = 0; j < side; j++) {
                char ch = sb.toString().charAt(i + side * j);
                chars[i * side + j] = ch;
            }
        }
        return String.valueOf(chars).replaceAll("\\W", "");
    }
}
