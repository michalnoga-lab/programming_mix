package com.app.tools;

import java.util.Scanner;

public class InnerTools {

    private static final Scanner scanner = new Scanner(System.in);

    public static Scanner getScanner() {
        return scanner;
    }

    public static void closeScanner() {
        scanner.close();
    }
}
