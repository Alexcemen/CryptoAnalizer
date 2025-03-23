package cipher.arguments;

import cipher.resources.fileNames;

public class EncodeOption extends AbstractOption implements CipherOption {
    @Override
    public String[] requestArguments() {
        return getEncryptionArguments();
    }

    private String[] getEncryptionArguments() {
        String inputFileNameForEncryption = getInputFileNameForEncryption();
        String outputFileNameForEncryption = getOutputFileNameForEncryption();
        String cipherKey = getCipherKey();
        return new String[]{"ENCODE", inputFileNameForEncryption, outputFileNameForEncryption, cipherKey};
    }

    private String getInputFileNameForEncryption() {
        while (true) {
            System.out.println("Напишите путь к файлу, который нужно зашифровать.");
            System.out.println("Или нажмите на \"ENTER\", и мы предоставим свой файл");
            String inputFileNameForEncrypted = scanner.nextLine();
            if (inputFileNameForEncrypted.isEmpty()) {
                return fileNames.getDefaultInputFileNameForEncryption();
            }
            if (validator.isFileExists(inputFileNameForEncrypted)) {
                return inputFileNameForEncrypted;
            } else {
                System.out.println("Ошибка! Такого файла не существует\n");
            }
        }
    }

    private String getOutputFileNameForEncryption() {
        while (true) {
            System.out.println("Напишите путь к файлу, в который нужно записать зашифрованный текст.");
            System.out.println("Или нажмите на \"ENTER\", и мы предоставим свой файл");
            String outputFileNameForEncryption = scanner.nextLine();
            if (outputFileNameForEncryption.isEmpty()) {
                return fileNames.getDefaultOutputFileNameForEncryption();
            }
            if (validator.isFileExists(outputFileNameForEncryption)) {
                return outputFileNameForEncryption;
            } else {
                System.out.println("Ошибка! Такого файла не существует\n");
            }
        }
    }

    private String getCipherKey() {
        while (true) {
            System.out.println("Введите ключ.");
            String cipherKey = scanner.nextLine().trim();
            try {
                int key = Integer.parseInt(cipherKey);
                if (validator.isValidKey(key)) {
                    return cipherKey;
                } else {
                    System.out.println("Ошибка! Введенный ключ не соответствует допустимому диапазону.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Необходимо ввести число.");
            }
        }
    }
}
