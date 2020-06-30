package beakjoon.b10039;

import java.util.Scanner;

/**
 * Created by yhh1056 on 2020-05-29.
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int totalScore = 0;
        int numberStudent = 5;
        int failScore = 40;

        for (int i = 0; i < numberStudent; i++) {
            int studentScore = sc.nextInt();

            if(studentScore < failScore) {
                studentScore = failScore;
            }
            totalScore += studentScore;
        }
        System.out.println(totalScore / numberStudent);
    }
}
