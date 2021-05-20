package programmers.p42895;

import java.util.Arrays;

/**
 * N으로 표현
 * Created by IntelliJ IDEA
 * User: yhh1056@naver.com
 * Date: 2021/05/17 Time: 4:47 오후
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(5, 12));
    }

    static int n;
    static int target;
    static int answer = 9;

    public int solution(int N, int number) {
        n = N;
        target = number;
        dfs(0, 0);
        return answer == 9 ? -1 : answer;
    }

    private void dfs(int count, int prev) {
        if (count > 8) {
            answer = -1;
            return;
        }

        if (prev == target) {
            answer = Math.min(answer, count);
            return;
        }

        int tempN = n;
        for (int i = 1; i <= 8 - count; i++) {
            int newCount = count + i;
            dfs(newCount, prev + tempN);
            dfs(newCount, prev - tempN);
            dfs(newCount, prev / tempN);
            dfs(newCount, prev * tempN);

            tempN = tempN * 10 + n;
        }
    }
}