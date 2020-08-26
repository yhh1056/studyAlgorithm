package beakjoon.b10773;

import java.util.Scanner;
import java.util.Stack;

/**
 * author {yhh1056}
 * Create by {2020/08/26}
 * 제로
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        Long sum = 0L;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < num; i++) {
            int input = scanner.nextInt();

            if (input != 0) {
                stack.push(input);
            } else {
                stack.pop();
            }
        }
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        System.out.println(sum);
    }
}
