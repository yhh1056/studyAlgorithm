package beakjoon.b2577;

import java.util.Scanner;

/**
 * Created by yhh1056 on 2020-06-09.
 *
 *          * 백준 2577번
 *          * 3 개의 숫자는 100이상 1000미만
 *          *  A×B×C를 계산한 결과에 0부터 9까지 각각의 숫자가 몇 번씩 쓰였나
 *
 */


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();
        int num123MultiResult = num1 * num2 * num3;
        scanner.close();

        int[] numberArrays = new int[10];

        while (num123MultiResult > 0) {
            numberArrays[num123MultiResult % 10]++; //일의 자리의 숫자를 해당 배열 칸에 증가.
            num123MultiResult /= 10;
        }

        for (int a : numberArrays) {
            System.out.println(a);
        }
    }
}
