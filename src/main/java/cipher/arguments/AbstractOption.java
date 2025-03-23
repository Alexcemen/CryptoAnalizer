package cipher.arguments;

import cipher.Validator;

import java.util.Scanner;

public abstract class AbstractOption {
    Validator validator = new Validator();
    Scanner scanner = new Scanner(System.in);
}
