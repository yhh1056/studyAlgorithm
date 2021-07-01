package programmers.p49191;

/**
 * Created by yhh1056
 * Date: 2021/07/01 Time: 3:37 오후
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}});
    }

    public int solution(int n, int[][] results) {
        int answer = 0;

        boolean[][] visit = new boolean[n + 1][n + 1];

        for (int[] result : results) {
            visit[result[0]][result[1]] = true;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (visit[i][k] && visit[k][j]) {
                        visit[i][j] = true;
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (visit[i][j] || visit[j][i]) {
                    count++;
                }
            }

            if (count == n - 1) {
                answer++;
            }
        }

        return answer;
    }
}
