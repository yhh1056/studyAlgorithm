package programmers.p42883;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution2("4177252841", 4);
    }

    public String solution(String number, int k) {
        String answer = "";

        String[] numbers = number.split("");

        Queue<String> trash = new LinkedList<>();

        int count = 0;

        while (true) {
            if (trash.size() == k) {
                break;
            }

            for (int i = 0; i < numbers.length; i++) {
                if (Integer.parseInt(numbers[i]) == count) {
                    trash.offer(String.valueOf(numbers[i]));
                    numbers[i] = "-1";
                }

                if (trash.size() == k) {
                    break;
                }
            }
            count++;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (!numbers[i].equals("-1")) {
                answer += numbers[i];
            }
        }

        System.out.println(answer);
        return answer;
    }

    public String solution2(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int end = k;

        int start = 0;

        for (int i = 0; i < number.length() - k; i++) {
            int tmp = 0;

            for (int j = start; j <= end; j++) {

                if (tmp < number.charAt(j) - '0') {
                    tmp = number.charAt(j) - '0';
                    start = j + 1;
                }
            }
            sb.append(tmp);
            end++;
        }

        return sb.toString();
    }
}
