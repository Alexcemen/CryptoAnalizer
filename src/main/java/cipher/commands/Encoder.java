package cipher.commands;

import cipher.entity.Result;
import cipher.entity.ResultCode;

import java.util.Arrays;

public class Encoder extends AbstractCommand implements Action {

    @Override
    public Result execute(String[] parameters) {
        String inputFileName = parameters[0];
        String outputFileName = parameters[1];
        int key = Integer.parseInt(parameters[2]);

        //не делать строки с гигантским текстом
        //а сразу считывать символы с одного потока
        //шифровать их
        //и записывать в выходной поток
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
}
