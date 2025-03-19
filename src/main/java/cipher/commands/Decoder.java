package cipher.commands;

import cipher.FileManager;
import cipher.entity.Result;
import cipher.entity.ResultCode;
import cipher.resources.Alphabet;

import java.util.Arrays;

public class Decoder extends CommonCommand implements Action {

    private static final String WARNING_ABOUT_ENTERING_INCORRECT_CHARACTERS = "ПАНИКА! КТО-ТО ПРИСЛАЛ НА РАСШИФРОВКУ ТЕКСТ С ЛЕВЫМИ СИМВОЛАМИ!!!";

    @Override
    public Result execute(String[] parameters) {
        String inputFileName = parameters[0];
        String outputFileName = parameters[1];
        int key = Integer.parseInt(parameters[2]);
        String inputText = getText(inputFileName);
        String decryptedText = decrypt(inputText, key);
        fileManager.writeFile(decryptedText, outputFileName);
        return new Result("decode all right", ResultCode.OK);
    }

    public static String decrypt(String encryptedText, int key) {
        StringBuilder decryptedText = new StringBuilder();
        char[] charArrayOfText = encryptedText.toCharArray();
        for (char charFromText : charArrayOfText) {
            if (checkCharInAlphabet(charFromText)) {
                int positionCharInAlphabet = Arrays.binarySearch(alphabet, charFromText);
                int newPositionCharInAlphabet = (positionCharInAlphabet - key + alphabet.length) % alphabet.length;
                decryptedText.append(alphabet[newPositionCharInAlphabet]);
            } else {
                System.out.println(WARNING_ABOUT_ENTERING_INCORRECT_CHARACTERS);
                return null;
            }
        }
        return decryptedText.toString();
    }
}
