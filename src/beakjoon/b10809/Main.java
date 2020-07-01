package beakjoon.b10809;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.next();

        /**
         * 반복문을 통해 char를 배열로 만들 수 있구나;
         */
        for (char c = 'a'; c <= 'z'; c++) {
            System.out.print(inputString.indexOf(c) + " ");
        }
    }
}
