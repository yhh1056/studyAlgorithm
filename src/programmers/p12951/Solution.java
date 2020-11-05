package programmers.p12951;

import java.util.LinkedList;
import java.util.Queue;

/**
 * author {yhh1056}
 * Create by {2020/11/04}
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("3people unFollowed me"));
    }
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        s = s.toLowerCase();
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            queue.offer(s.charAt(i));
        }
        boolean visit = true;

        while (!queue.isEmpty()) {
            String unit = String.valueOf(queue.poll());
            if (unit.equals(" ")) {
                visit = true;
            } else if (visit) {
                unit = unit.toUpperCase();
                visit = false;
            }

            answer.append(unit);

        }

        return answer.toString();
    }

}
