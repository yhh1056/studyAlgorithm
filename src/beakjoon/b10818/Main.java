package beakjoon.b10818;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by yhh1056 on 2020-06-04.
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        int[] list = new int[num];

        for (int i = 0; i < num; i++) {
            list[i] = scanner.nextInt();
        }

        Arrays.sort(list);
        System.out.println(list[0] + " " + list[num - 1]);
    }
}
