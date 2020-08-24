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

            stack.push(input[0]);

            for (int j = 1; j < input.length; j++){
                if (!stack.isEmpty() && input[j].equals(stack.peek())) {
                    stack.pop();
                } else {
                    stack.push(input[j]);
                }
            }

            if (stack.size() == 0) {
                count++;
            }
            stack.clear();
        }
        System.out.println(count);
    }
}
