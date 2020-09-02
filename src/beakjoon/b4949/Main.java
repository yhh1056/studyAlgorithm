package beakjoon.b4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 균형잡힌 세상
 * author {yhh1056}
 * Create by {2020/08/25}
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Stack<String> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            stack.clear();
            String string = br.readLine();
            if (string.equals(".")) {
                break;
            }
            String[] input = string.split("");

            for (String str : input) {
                if (str.equals("(") || str.equals("[")) {
                    stack.push(str);
                }
                else if (str.equals(")") && !stack.isEmpty() && stack.peek().equals("(")) {
                    stack.pop();
                } else if (str.equals("]") && !stack.isEmpty() && stack.peek().equals("[")) {
                    stack.pop();
                } else if (str.equals(")") || str.equals("]")) {
                    stack.push(str);
                }
            }

            if (stack.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}