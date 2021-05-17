package programmers.p42861;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int solution(int n, int[][] costs) {
        boolean[] visit = new boolean[n];

        int answer = 0;

        Arrays.sort(costs, Comparator.comparingInt(c -> c[2]));

        for (int[] cost : costs) {
            if (!visit[cost[1]]) {
                visit[cost[1]] = true;
                answer += cost[2];

            }
        }

        return answer;
    }

    public int solution2(int n, int[][] costs) {
        boolean[][] visit = new boolean[n][n];

        int answer = 0;

        Arrays.sort(costs, Comparator.comparingInt(c -> c[2]));

        for (int[] cost : costs) {
            if (!visit[cost[0]][cost[1]] || !visit[cost[1]][cost[0]]) {
                visit[cost[0]][cost[1]] = true;
                visit[cost[1]][cost[0]] = true;
                answer += cost[2];

            }
        }

        return answer;
    }
}
