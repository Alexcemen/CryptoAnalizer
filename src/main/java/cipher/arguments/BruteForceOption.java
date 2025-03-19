package cipher.arguments;

import cipher.resources.fileNames;

public class BruteForceOption extends CommonOption implements CipherOption {
    @Override
    public String[] requestArguments() {
        return getBruteForceArguments();
    }

    private String[] getBruteForceArguments() {
        String inputFileNameForBruteForce = getInputFileNameForBruteForce();
        String outputFileNameForBruteForce = getOutputFileNameForBruteForce();
        return new String[] {"BRUTE_FORCE", inputFileNameForBruteForce, outputFileNameForBruteForce};
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
}
