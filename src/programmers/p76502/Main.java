package programmers.p76502;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.solution("{{{}");
    }

    public int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            if (isGoodString(s)) {
                answer += 1;
            }

            s = s.substring(1) + s.charAt(0);
        }

        return answer;
    }

    private boolean isGoodString(String s) {
        Stack<String> left = new Stack<>();
        Stack<String> right = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            left.push(String.valueOf(s.charAt(i)));
        }

        while (!left.isEmpty()) {
            right.push(left.pop());

            while (!right.isEmpty()) {
                if (left.isEmpty() && !right.isEmpty()) {
                    break;
                }

                if (isSymmetry(left.peek(), right.peek())) {
                    left.pop();
                    right.pop();
                } else {
                    break;
                }
            }
        }

        return right.isEmpty();
    }

    private boolean isSymmetry(String left, String right) {
        if (left.equals("{") && right.equals("}")) {
            return true;
        }

        if (left.equals("[") && right.equals("]")) {
            return true;
        }

        return left.equals("(") && right.equals(")");

    }
}
