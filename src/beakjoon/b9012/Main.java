package beakjoon.b9012;

import java.util.Scanner;
import java.util.Stack;

/**
 * 문제 : 괄호
 * author {yhh1056}
 * Create by {2020/08/25}
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < num; i++) {
            stack.clear();
            String[] strings = scanner.nextLine().split("");

            for (String string : strings) {
                if (stack.isEmpty()) {
                    stack.push(string);
                } else if (string.equals("(")) {
                    stack.push(string);
                } else if (string.equals(")")) {
                    if (stack.peek().equals("(")) {
                        stack.pop();
                    } else {
                        stack.push(string);
                        break;
                    }
                }
            }
            if (stack.size() == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        scanner.close();
    }
}