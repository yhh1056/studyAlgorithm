package beakjoon.b2446;

import java.util.Scanner;

/**
 * Created by yhh1056 on 2020-06-03.
 */

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        scanner.close();

        for (int i = 1; i <= num; i++) {
            for (int j = 0; j < i - 1; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < (num * 2) - (i * 2 - 1); j++) {
                System.out.print("*");
            }
            System.out.println();

        }

        for (int i = 1; i < num; i++) {
            for (int j = num; j > i + 1; j--) {
                System.out.print(" ");
            }

            for (int j = 1; j <= 2 * i + 1; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

    }
}
