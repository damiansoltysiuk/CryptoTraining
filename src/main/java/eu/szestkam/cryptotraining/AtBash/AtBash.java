package eu.szestkam.cryptotraining.AtBash;

public class AtBash {
    private String date = "";
    private String digits = "0123456789";
    private String letter = "abcdefghijklmnopqrstuwvxyz";

    public AtBash(String message) {
        this.date = message;
    }

    public AtBash() {
    }

    String encode() {
        StringBuilder sb = new StringBuilder();
        for(char ch : date.toCharArray()) {
            if (Character.isLetter(ch)) {
                int index = 25 - letter.indexOf(String.valueOf(ch).toLowerCase());
                sb.append(Character.isLowerCase(ch) ? letter.charAt(index) : letter.toUpperCase().charAt(index));
            } else if (Character.isDigit(ch)) {
                sb.append(digits.charAt(9 - digits.indexOf(ch)));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
