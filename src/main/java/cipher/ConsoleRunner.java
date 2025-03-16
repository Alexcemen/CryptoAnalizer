package cipher;

import cipher.entity.Result;

public class ConsoleRunner {
    public static void main(String[] args) {
        System.out.println("sdfsdf");
        //аргументы: {encode, text.txt, encode.txt, 12}
        Application application = new Application();
        Result result = application.run(args);
        System.out.println(result);
    }
}