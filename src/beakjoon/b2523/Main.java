package beakjoon.b2523;

import java.util.Scanner;

/**
 * Created by yhh1056 on 2020-06-02.
 */

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        int line = num * 2;

        for (int i = 1; i <= line - 1; i++) {
            if (i <= num) {
                for (int j = 0; j < i; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
            if (i > num) {
                for (int j = 0; j < line - i; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }
}
