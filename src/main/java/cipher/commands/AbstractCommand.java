package cipher.commands;

import cipher.FileManager;
import cipher.resources.Alphabet;

import java.util.Arrays;

public abstract class AbstractCommand {

    static char[] alphabet = Alphabet.getAlphabet();

    FileManager fileManager = new FileManager();

    String getText(String inputFileName) {
        return fileManager.readFile(inputFileName);
    }

    static boolean checkCharInAlphabet(char ch) {
        return Arrays.binarySearch(alphabet, ch) >= 0;
    }
}
