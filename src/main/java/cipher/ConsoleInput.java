package cipher;

import cipher.resources.fileNames;

import java.util.Scanner;

public class ConsoleInput {
    Validator validator = new Validator();

    private final Scanner scanner = new Scanner(System.in);

    public String[] requestMainArguments() {
        showCipherOptions();
        String selectedCipherOption = getSelectedCipherOption();

        if (selectedCipherOption.equals("ENCODE")) {
            System.out.println("Вы выбрали \"зашифровать файл\"");
            return getEncryptionArguments();
        } else if (selectedCipherOption.equals("DECODE")) {
            System.out.println("Вы выбрали \"расшифровать файл\"");
            return getDecryptionArguments();
        } else if (selectedCipherOption.equals("BRUTE_FORCE")) {
            System.out.println("Вы выбрали \"взломать файл методом brute force\"");
            return getBruteForceArguments();
        } else if (selectedCipherOption.equals("STATISTICAL_ANALYZER")) {
            System.out.println("Вы выбрали \"взломать файл методом statistical analyzer\"");
            System.out.println("Сори, то я хз как это сделать");
            System.out.println("Попробуй ченить другое");
        }
        return null;
    }

    private static void showCipherOptions() {
        System.out.println("Перед вами шифровальщик Цезаря.");
        System.out.println("С его помощью вы можете: ");
        System.out.println("- Зашифровать ваш файл.");
        System.out.println("- Расшифровать файл (если у вас есть ключ).");
        System.out.println("- Если вы не знаете ключ - можем попытаться взломать этот файл методом brute force.");
        System.out.println("- Или можем попытаться взломать с помощью статистического анализатора");
        System.out.println();
        System.out.println("Что вы хотите:");
        System.out.println("1 - зашифровать свой файл");
        System.out.println("2 - расшифровать файл (у меня есть ключ).");
        System.out.println("3 - взломать файл методом brute force");
        System.out.println("4 - взломать файл с помощью статистического анализатора");
        System.out.println();
    }

    private String getSelectedCipherOption() {
        return switch (getNumberSelectedCipherOption()) {
            case 1 -> "ENCODE";
            case 2 -> "DECODE";
            case 3 -> "BRUTE_FORCE";
            case 4 -> "STATISTICAL_ANALYZER";
            //IDEA не дает убрать default. Хотя я еще в методе getNumberSelectedCipherOption() проверил,
            //что не может быть другого значения, кроме как от 1 до 4
            default -> throw new IllegalStateException("Unexpected value");
        };
    }

    private int getNumberSelectedCipherOption() {
        while (true) {
            System.out.println("Введите цифру от 1 до 4: ");
            String userInput = scanner.nextLine().trim();

            if (userInput.matches("[1-4]")) {
                return Integer.parseInt(userInput);
            } else {
                System.out.println("Ошибка! Введите ЦИФРУ от 1 до 4.");
            }
        }
    }

    private String[] getEncryptionArguments() {
        String inputFileNameForEncryption = getInputFileNameForEncryption();
        String outputFileNameForEncryption = getOutputFileNameForEncryption();
        String cipherKey = getCipherKey();
        return new String[] {"ENCODE", inputFileNameForEncryption, outputFileNameForEncryption, cipherKey};
    }

    private String[] getDecryptionArguments() {
        String inputFileNameForDecryption = getInputFileNameForDecryption();
        String outputFileNameForDecryption = getOutputFileNameForDecryption();
        String cipherKey = getCipherKey();
        return new String[] {"DECODE", inputFileNameForDecryption, outputFileNameForDecryption, cipherKey};
    }

    private String[] getBruteForceArguments() {
        String inputFileNameForBruteForce = getInputFileNameForBruteForce();
        String outputFileNameForBruteForce = getOutputFileNameForBruteForce();
        return new String[] {"BRUTE_FORCE", inputFileNameForBruteForce, outputFileNameForBruteForce};
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

    private String getInputFileNameForDecryption() {
        while (true) {
            System.out.println("Напишите путь к файлу, который нужно расшифровать.");
            System.out.println("Или нажмите на \"ENTER\", и мы предоставим свой файл");
            String inputFileNameForDecrypted = scanner.nextLine();
            if (inputFileNameForDecrypted.isEmpty()) {
                return fileNames.getDefaultInputFileNameForDecryption();
            }
            if (validator.isFileExists(inputFileNameForDecrypted)) {
                return inputFileNameForDecrypted;
            } else {
                System.out.println("Ошибка! Такого файла не существует\n");
            }
        }
    }

    private String getInputFileNameForBruteForce() {
        while (true) {
            System.out.println("Напишите путь к зашифрованному файлу, который нужно взломать.");
            System.out.println("Или нажмите на \"ENTER\", и мы предоставим свой файл");
            String inputFileNameForBruteForce = scanner.nextLine();
            if (inputFileNameForBruteForce.isEmpty()) {
                return fileNames.getDefaultInputFileNameForBruteForce();
            }
            if (validator.isFileExists(inputFileNameForBruteForce)) {
                return inputFileNameForBruteForce;
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

    private String getOutputFileNameForDecryption() {
        while (true) {
            System.out.println("Напишите путь к файлу, в который нужно записать расшифрованный текст.");
            System.out.println("Или нажмите на \"ENTER\", и мы предоставим свой файл");
            String outputFileNameForDecryption = scanner.nextLine();
            if (outputFileNameForDecryption.isEmpty()) {
                return fileNames.getDefaultOutputFileNameForDecryption();
            }
            if (validator.isFileExists(outputFileNameForDecryption)) {
                return outputFileNameForDecryption;
            } else {
                System.out.println("Ошибка! Такого файла не существует\n");
            }
        }
    }

    private String getOutputFileNameForBruteForce() {
        while (true) {
            System.out.println("Напишите путь к файлу, в который нужно записать расшифрованный текст.");
            System.out.println("Или нажмите на \"ENTER\", и мы предоставим свой файл");
            String outputFileNameForBruteForce = scanner.nextLine();
            if (outputFileNameForBruteForce.isEmpty()) {
                return fileNames.getDefaultOutputFileNameForBruteForce();
            }
            if (validator.isFileExists(outputFileNameForBruteForce)) {
                return outputFileNameForBruteForce;
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
