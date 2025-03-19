package cipher.commands;

import cipher.FileManager;
import cipher.entity.Result;
import cipher.entity.ResultCode;
import cipher.resources.Alphabet;

import java.util.Arrays;

public class Encoder implements Action {
    char[] alphabet = Alphabet.getAlphabet();
    FileManager fileManager = new FileManager();

    @Override
    public Result execute(String[] parameters) {
        String inputFileName = parameters[0];
        String outputFileName = parameters[1];
        int key = Integer.parseInt(parameters[2]);

        String inputText = getText(inputFileName);
        String encryptedText = encrypt(inputText, key);
        fileManager.writeFile(encryptedText, outputFileName);

        return new Result("Шифрование прошло успешно", ResultCode.OK);
    }

    private String encrypt(String text, int key) {
        StringBuilder encryptedText = new StringBuilder();
        char[] charArrayOfText = text.toCharArray();
        for (char charFromText : charArrayOfText) {
            if (checkCharInAlphabet(charFromText)) {
                int positionCharInAlphabet = Arrays.binarySearch(alphabet, charFromText);
                int newPositionCharInAlphabet = (positionCharInAlphabet + key) % alphabet.length;
                encryptedText.append(alphabet[newPositionCharInAlphabet]);
            }
        }
        return encryptedText.toString();
    }

    private boolean checkCharInAlphabet(char ch) {
        return Arrays.binarySearch(alphabet, ch) >= 0;
    }

    private String getText(String inputFileName) {
        return fileManager.readFile(inputFileName);
    }
}
