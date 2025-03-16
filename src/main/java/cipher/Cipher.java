package cipher;

import java.util.Arrays;

public class Cipher {
    private char[] alphabet;
    private final String WARNING_ABOUT_ENTERING_INCORRECT_CHARACTERS = "ПАНИКА! КТО-ТО ПРИСЛАЛ НА РАСШИФРОВКУ ТЕКСТ С ЛЕВЫМИ СИМВОЛАМИ!!!";

    public Cipher(char[] alphabet) {
        Arrays.sort(alphabet);
        this.alphabet = alphabet;
    }

    public String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        char[] charArrayOfText = text.toCharArray();
        for (char charFromText : charArrayOfText) {
            if (checkCharInAlphabet(charFromText)) {
                int positionCharInAlphabet = Arrays.binarySearch(alphabet, charFromText);
                int newPositionCharInAlphabet = (positionCharInAlphabet + shift) % alphabet.length;
                result.append(alphabet[newPositionCharInAlphabet]);
            }
        }
        return result.toString();
    }

    public String decrypt(String encryptedText, int shift) {
        StringBuilder result = new StringBuilder();
        char[] charArrayOfText = encryptedText.toCharArray();
        for (char charFromText : charArrayOfText) {
            if (checkCharInAlphabet(charFromText)) {
                int positionCharInAlphabet = Arrays.binarySearch(alphabet, charFromText);
                int newPositionCharInAlphabet = (positionCharInAlphabet - shift + alphabet.length) % alphabet.length;
                result.append(alphabet[newPositionCharInAlphabet]);
            } else {
                System.out.println(WARNING_ABOUT_ENTERING_INCORRECT_CHARACTERS);
                return null;
            }
        }
        return result.toString();
    }

    private boolean checkCharInAlphabet(char ch) {
        return Arrays.binarySearch(alphabet, ch) >= 0;
    }
}
