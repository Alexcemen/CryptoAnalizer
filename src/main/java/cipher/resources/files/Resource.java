package cipher.resources.files;

public class Resource {
    private static final char[] ALPHABET = {
            // Английский алфавит (маленькие и заглавные буквы)
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
            'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
            'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',

            // Русский алфавит (маленькие и заглавные буквы)
            'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у',
            'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я',
            'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У',
            'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я',

            // Дополнительные символы
            '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' ', '-', '[', ']', '(', ')', '—', '@', '#', '$', '%', '^','&', '*',
            '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'
    };

    private static final String content = "Используй пример текста (репрезентативный текст автора или в том же стиле) \n" +
            "и составь статистику букв (например, как часто встречается на каждые 1000 символов). \n" +
            "Кстати. Легко взломать шифр и без такого файла и анализа: попробуйте угадать пробел — \n" +
            "это наверняка наиболее часто встречающийся символ в обычном тексте.";

    private static final String INPUT_FILE_NAME = "/Users/alexcemen/javarush/3548974/javarush-project/src/com/javarush/task/projectModul1/java/inputFile";
    private static final String ENCRYPT_FILE_NAME = "/Users/alexcemen/javarush/3548974/javarush-project/src/com/javarush/task/projectModul1/java/encryptFile";
    private static final String DECRYPT_FILE_NAME = "/Users/alexcemen/javarush/3548974/javarush-project/src/com/javarush/task/projectModul1/java/decryptText";

    public static char[] getALPHABET() {
        return ALPHABET;
    }

    public static String getInputFileName() {
        return INPUT_FILE_NAME;
    }

    public static String getOutputFilePath() {
        return ENCRYPT_FILE_NAME;
    }

    public static String getDecryptFileName() { return DECRYPT_FILE_NAME;}
}
