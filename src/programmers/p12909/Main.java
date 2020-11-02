package programmers.p12909;

import java.util.Stack;

/**
 * 올바른 괄호
 * author {yhh1056}
 * Create by {2020/11/01}
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.solution("()");
    }
    boolean solution(String word) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < word.length(); i++) {
            char bracket = word.charAt(i);
            if (stack.isEmpty() || bracket == '(') {
                stack.push(bracket);
            } else if (bracket == ')' && stack.peek() == '(') {
                stack.pop();
            }
        }
        System.out.println(stack);
        return stack.isEmpty();
    }
}
