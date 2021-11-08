package programmers.p87390;

import java.util.ArrayList;
import java.util.List;

/**
 * n ^ 2 배열 자르기
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.solution(4, 7, 14);
    }

    public int[] solution(int n, long left, long right) {
        List<Long> result = new ArrayList<>();
        for (long i = left; i <= right; i++) {
            long x = i / n + 1;
            long y = i % n + 1;
            long max = Math.max(x, y);
            result.add(max);
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = Math.toIntExact(result.get(i));
        }

        return answer;
    }

}
