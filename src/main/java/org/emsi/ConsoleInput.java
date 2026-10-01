package org.emsi;

import java.util.Scanner;

/** Shares one scanner so input read-ahead does not hide console input from other classes. */
public final class ConsoleInput {
    private static final Scanner SCANNER = new Scanner(System.in);

    private ConsoleInput() {
    }

    public static Scanner scanner() {
        return SCANNER;
    }
}
