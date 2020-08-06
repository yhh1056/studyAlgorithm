package programmers.p12969;

import java.util.Scanner;

/**
 * author {yhh1056}
 * Create by {2020/08/06}
 */
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        for (int i = 0; i < b; i++) {
            for (int j = 0; j < a; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
