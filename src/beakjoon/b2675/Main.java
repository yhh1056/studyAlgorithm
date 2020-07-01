package beakjoon.b2675;

import java.util.Scanner;

/**
 * 클레스 설명
 * <p>
 * author {yhh1056}
 * Create by {2020/07/01}
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNum = scanner.nextInt();

        for (int i = 0; i < inputNum; i++) {
            int num = scanner.nextInt();  //3
            String munza = scanner.next();  // abc
            String answer = "";
            for (int j = 0; j < munza.length(); j++) {
                for (int k = 0; k < num; k++) {
                    answer += munza.charAt(j);
                }
            }
            System.out.println(answer);
        }
    }
}
