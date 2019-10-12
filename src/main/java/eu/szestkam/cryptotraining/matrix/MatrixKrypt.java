package eu.szestkam.cryptotraining.matrix;

public class MatrixKrypt {
    private String date;

    public MatrixKrypt() {
        date = "";
    }

    public MatrixKrypt(String messege) {
        this.date = messege;
    }

    String encode() {
        int side = (int)Math.ceil(Math.sqrt(date.length()));
        if (side < 2) return date;
        StringBuilder sb = new StringBuilder(date);
        while (sb.length() != side * side) {
            sb.append(" ");
        }
        char[] chars = new char[sb.length()];
        for(int i = 0; i < side; i++) {
            for(int j = 0; j < side; j++) {
                char ch = sb.toString().charAt(i + side * j);
                chars[i * side + j] = ch;
            }
        }
        return String.valueOf(chars).trim();
    }

    public static void main(String[] args) {
        System.out.println(new MatrixKrypt("AlgorytmyIStrukturaDanych").encode());
    }
}
