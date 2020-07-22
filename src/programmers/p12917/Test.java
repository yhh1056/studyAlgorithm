package programmers.p12917;

import java.util.Arrays;
import java.util.Stack;

/**
 * author {yhh1056}
 * Create by {2020/07/22}
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("Zbcdefg"));
    }
}

class Solution {
    public String solution(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> strings = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i);
        }
        Arrays.sort(arr);
        for (char c : arr) {
            strings.push(c);
        }

        StringBuilder answer = new StringBuilder();

        while (!strings.isEmpty()) {
            answer.append(strings.pop());
        }
        return answer.toString();
    }
}
