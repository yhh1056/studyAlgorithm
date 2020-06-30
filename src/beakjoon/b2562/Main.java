package beakjoon.b2562;

import java.util.Scanner;

/**
 * Created by yhh1056 on 2020-06-07.
 */

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] list = new int[9];
        int maxNum = list[0];
        int count = 0;

        for (int i = 0; i < 9; i++) {
            list[i] = scanner.nextInt();
            if (list[i] >= maxNum) {
                maxNum = list[i];
                count = i + 1;
            }
        }
        System.out.println(maxNum + "\n" + count);
    }
}
