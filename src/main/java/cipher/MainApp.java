package cipher;

public class MainApp {

    public static void makeIndent() {
        System.out.println("***********");
        System.out.println();
    }

    public static void main(String[] args) {
        char[] alphabet = Resource.getALPHABET();
        String inputFileName = Resource.getInputFileName();
        String outputFileName = Resource.getOutputFilePath();
        String decryptFileName = Resource.getDecryptFileName();

        System.out.println("Введите путь к файлу, который нужно зашифровать");
        System.out.println("Нужно зашифровать файл: " + inputFileName);
        makeIndent();

        System.out.println("Проверяю, существует ли такой файл");
        Validator validator = new Validator();
        System.out.println(validator.isFileExists(inputFileName));
        makeIndent();

        System.out.println("Придумай ключ для шифрования");
        int key = 5;
        System.out.println("Ключ для шифрования: " + key);
        makeIndent();

        System.out.println("Проверяю, подойдет ли такой ключ");
        System.out.println(validator.isValidKey(key, alphabet));
        makeIndent();

        System.out.println("Считываю текст из файла:");
        FileManager fileManager = new FileManager();
        String inputText = fileManager.readFile(inputFileName);
        System.out.println(inputText);
        makeIndent();

        System.out.println("Начинаю шифровать");
        Cipher cipher = new Cipher(alphabet);
        String encryptText = cipher.encrypt(inputText, key);
        System.out.println("Зашифрованный текст:");
        System.out.println(encryptText);
        makeIndent();

        System.out.println("Записываю зашифрованный текст в encryptFile файл");
        fileManager.writeFile(encryptText, outputFileName);
        System.out.println("Записал");
        makeIndent();

        System.out.println("Начинаю расшифровку текста");
        System.out.println("Зашифрованный текст:");
        String encryptedText = fileManager.readFile(outputFileName);
        System.out.println(encryptedText);
        System.out.println("Расшифрованный текст:");
        String decryptedText = cipher.decrypt(encryptedText, key);
        System.out.println(decryptedText);
        makeIndent();

        System.out.println("Записываю расшифрованный текст в decryptFile");
        fileManager.writeFile(decryptedText, decryptFileName);
        System.out.println("Записал");
        makeIndent();

        System.out.println("Проверяю изначальный текст и расшифрованный");
        if (inputText.equals(decryptedText)) {
            System.out.println("Да, они одинаковые");
        } else {
            System.out.println("Нет, есть отличия");
        }
    }
}
