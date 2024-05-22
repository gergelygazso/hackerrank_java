package org.gergelygazso.introduction.easy;

import java.util.Scanner;

public class JavaIfElse {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String output = "";
        if (N % 2 != 0) {
            output = "Weird";
        } else {
            if (N >= 2 && N <= 5) {
                output = "Not Weird";
            } else if (N >= 6 && N <= 20) {
                output = "Weird";
            } else if (N > 20) {
                output = "Not Weird";
            }
        }
        System.out.println(output);

        scanner.close();
    }

}
