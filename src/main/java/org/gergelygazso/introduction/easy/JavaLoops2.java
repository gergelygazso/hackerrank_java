package org.gergelygazso.introduction.easy;


import java.util.Scanner;

public class JavaLoops2 {

    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        String outputLine="";
        for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            int result = a;
            for (int j = 0; j < n; j++) {
                int partResult = (int) Math.pow(2, j) * b;
                result += partResult;
                outputLine += result + " ";
            }
            outputLine = outputLine.substring(0, outputLine.length() - 1);
            outputLine += System.lineSeparator();
        }
        System.out.println(outputLine);
        in.close();
    }

}
