package cipher;

import java.nio.file.Files;
import java.nio.file.Path;

public class Validator {

    public boolean isValidKey(int key, char[] alphabet) {
        boolean result = key >= 0 && key < alphabet.length-1;
        if (result) {
            System.out.println("Ключ подходит под условия валидации");
        } else {
            System.out.println("Ключ не подходит под условия валидации");
        }
        return result;
    }

    public boolean isFileExists(String filePath) {
        Path path = Path.of(filePath);
        boolean result = (Files.exists(path) && Files.isRegularFile(path));
        if (result) {
            System.out.println("Файл существует и является обычным файлом.");
        } else {
            System.out.println("Файл не найден или это не обычный файл.");
        }
        return result;
    }
}
