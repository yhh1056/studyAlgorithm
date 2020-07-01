package beakjoon.b11720;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String inputNum = scanner.next();
        int sum = 0;
        for (int i = 0; i < num; i++) {
            sum += Integer.parseInt(String.valueOf(inputNum.charAt(i)));
        }
        System.out.println(sum);
    }
}
