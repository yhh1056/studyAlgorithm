package beakjoon.b8958;

import java.util.Scanner;

/**
 * 백준 1차원 배열 문제 *
 * author {yhh1056}
 * Create by {2020/06/16}
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] oxArray = new String[scanner.nextInt()];

        for (int i = 0; i < oxArray.length; i++) {
            int count = 0;
            int comboScore = 0;
            oxArray[i] = scanner.next();

            for (int j = 0; j < oxArray[i].length(); j++) {
                if (oxArray[i].charAt(j) == 'O') {
                    count += ++comboScore;
                } else {
                    comboScore = 0;
                }
            }
            System.out.println(count);
        }

    }
}
