package beakjoon.b1546;

import java.util.Scanner;

/**
 *
 * 백준 1차원 배열 문
 *
 * author {yhh1056}
 * Create by {2020/06/15}정
 *
 * 수정 -> 반복문을 하나 줄이고 계산식을 추가
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = scanner.nextInt();
        int maxNum = 0;
        int totalScore = 0;
        int score;
        double avg;

        for(int i = 0; i < inputNumber; i++) {
            score = scanner.nextInt();
            totalScore += score;

            if(score > maxNum) {
                maxNum = score;
            }
        }

        scanner.close();

        avg = 100.0 * totalScore /(maxNum * inputNumber);

        System.out.println(avg);
    }
}
