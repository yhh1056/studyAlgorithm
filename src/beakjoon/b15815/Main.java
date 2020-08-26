package beakjoon.b15815;

import java.util.Scanner;
import java.util.Stack;

/**
 * author {yhh1056}
 * Create by {2020/08/26}
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("");

        Stack<Integer> stack = new Stack<>();

        int length = input.length;
        int numLength = length / 2 + 1;

        for (int i = 0; i < numLength; i++) {
            stack.push(Integer.parseInt(input[i]));
        }
        for (int i = numLength; i < length; i++) {
            int tmp = 0;
            if (input[i].equals("+")) {
                stack.push((stack.pop() + stack.pop()));
            } else if (input[i].equals("-")) {
                tmp = stack.pop();
                stack.push(stack.pop() - tmp);
            } else if (input[i].equals("*")) {
                stack.push((stack.pop() * stack.pop()));
            } else if (input[i].equals("/")) {
                tmp = stack.pop();
                stack.push(stack.pop() / tmp);
            }
        }
        System.out.println(stack.peek());
    }
}
