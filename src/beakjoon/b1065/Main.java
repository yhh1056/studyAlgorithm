package beakjoon.b1065;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNum = scanner.nextInt();
        int count = 0;
        for (int i = 1; i <= inputNum; i++) {
            String hansu = String.valueOf(i);
            if (hansu.length() <= 2) {
                count++;
            } else {
                int firstSequence = hansu.charAt(0) - hansu.charAt(1);
                int secondSequence = hansu.charAt(1) - hansu.charAt(2);
                if (firstSequence == secondSequence) {
                    count++;
                }
            }
        }
        System.out.println(count);

    }

    public static int hanSu(int inputNum) {     //런타임 에러 코드
        int count = 0;
        for (int i = 1; i <= inputNum; i++) {
            if (i < 100) {
                count++;
            }
            if (i >= 100 && i < 1000) {
                int one = i % 10;
                int ten = (i / 10) % 10;
                int hund = (i / 100) % 10;
                if (one - ten == ten - hund) {
                    count++;
                }
            }

        }
        return count;
    }
}
