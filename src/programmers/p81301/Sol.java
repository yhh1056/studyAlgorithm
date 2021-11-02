package programmers.p81301;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Sol {

    public static void main(String[] args) {
        Sol sol = new Sol();
        System.out.println(sol.solution("10twotwo09ninezero1"));
    }

    public int solution(String s) {
        String answer = "";

        Map<String, Integer> map =
                Map.of("zero", 0, "one", 1, "two", 2, "three", 3, "four", 4, "five", 5
                , "six", 6, "seven", 7, "eight", 8, "nine", 9);

        Queue<Character> queue = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            queue.add(s.charAt(i));
        }

        String word = "";
        while (!queue.isEmpty()) {
            Character poll = queue.poll();
            if (poll >= 48 && poll <= 57) {
                answer += poll - '0';
            } else {
                word += poll;
            }

            if (map.containsKey(word)) {
                answer += map.get(word);
                word = "";
            }
        }

        return Integer.parseInt(answer);
    }

}
