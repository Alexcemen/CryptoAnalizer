package cipher.commands;
import cipher.entity.Result;
import cipher.entity.ResultCode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class BruteForce extends CommonCommand implements Action {

    private static final String WARNING_ABOUT_ENTERING_INCORRECT_CHARACTERS = "ПАНИКА! КТО-ТО ПРИСЛАЛ НА РАСШИФРОВКУ ТЕКСТ С ЛЕВЫМИ СИМВОЛАМИ!!!";

    @Override
    public Result execute(String[] parameters) {
        String inputFileName = parameters[0];
        String outputFileName = parameters[1];
        String text = getText(inputFileName);
        String decryptedText = brutForce(text);
        fileManager.writeFile(decryptedText, outputFileName);
        return new Result("brute force прошел успешно", ResultCode.OK);
    }

    private static String brutForce(String text) {
        char mostFrequentCharInText = findMostFrequentChar(text);
        int positionSpaceCharInAlphabet = Arrays.binarySearch(alphabet, ' ');
        int positionMostFrequentCharInAlphabet = Arrays.binarySearch(alphabet, mostFrequentCharInText);
        if (positionSpaceCharInAlphabet < 0 || positionMostFrequentCharInAlphabet < 0) {
            throw new IllegalArgumentException("Ошибка: в алфавите отсутствует пробел или частый символ не найден.");
        }
        int key = Math.abs(positionSpaceCharInAlphabet - positionMostFrequentCharInAlphabet);
        return decrypt(text, key);
    }

    private static char findMostFrequentChar(String text) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        char mostFrequentChar = text.charAt(0);
        int maxCount = 0;
        for (char ch : text.toCharArray()) {
            charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
            if (charCountMap.get(ch) > maxCount) {
                maxCount = charCountMap.get(ch);
                mostFrequentChar = ch;
            }
        }
        return mostFrequentChar;
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
