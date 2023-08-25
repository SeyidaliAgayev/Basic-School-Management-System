package util;

import model.Student;

import java.util.Scanner;

public class InputUtil {
    public static int inputRequiredInt(String title) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(title);
        return scanner.nextInt();
    }

    public static int[] inputRequiredIntArray(String title) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(title);
        return new int[]{scanner.nextInt()};
    }

    public static String inputRequiredString(String title) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(title);
        return scanner.nextLine();
    }

    public static double inputRequiredDouble(String title) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(title);
        return scanner.nextDouble();
    }
}
