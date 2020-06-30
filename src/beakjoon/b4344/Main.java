package beakjoon.b4344;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNum = scanner.nextInt();
        double avg = 0;
        double ratio = 0;
        for (int i = 0; i < inputNum; i++) {
            int[] score = new int[scanner.nextInt()];
            int sum = 0;
            int count = 0;
            int[] students = new int[score.length];

            for (int j = 0; j < score.length; j++) {
                students[j] = scanner.nextInt();
                sum += students[j];
                avg = (double) sum / score.length;
            }

            for (int j = 0; j < score.length; j++) {
                if (students[j] > avg) {
                    count++;
                }
                ratio = (double) count / score.length * 100;
            }
            System.out.printf("%.3f%%", ratio);
            System.out.println("%");
        }
    }
}

