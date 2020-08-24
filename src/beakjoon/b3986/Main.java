package beakjoon.b3986;

import java.util.Scanner;
import java.util.Stack;

/**
 * author {yhh1056}
 * Create by {2020/08/24}
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();
        Stack<String> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < num; i++) {
            String[] input = scanner.nextLine().split("");
            for (String s : input) {
                stack.push(s);
            }
            String first = stack.pop();
            String second = stack.pop();

            if (first.equals(stack.peek())) {
                count++;
            }
            if (second.equals(stack.peek())) {
                count++;
            }

        }
    }
}
