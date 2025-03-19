package cipher;

import cipher.resources.Alphabet;

import java.nio.file.Files;
import java.nio.file.Path;

public class Validator {

    public boolean isValidKey(int key) {
        final char[] alphabet = Alphabet.getAlphabet();
        boolean isValid = key >= 0 && key < alphabet.length-1;
        System.out.printf("Ключ %d %s условия валидации.%n",
                key, isValid ? "подходит под" : "не подходит под");
        return isValid;
    }

    public boolean isFileExists(String filePath) {
        Path path = Path.of(filePath);
        boolean isFileExists = (Files.exists(path) && Files.isRegularFile(path));
        if (isFileExists) {
            System.out.println("Файл существует и является обычным файлом.");
        } else {
            System.out.println("Файл не найден или это не обычный файл.");
        }
        return isFileExists;
    }
}
