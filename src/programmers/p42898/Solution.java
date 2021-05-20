package programmers.p42898;

import java.util.Arrays;

/**
 * 등굣길
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(4, 3, new int[][]{{2, 2}}));
    }

    public int solution(int m, int n, int[][] puddles) {
        int[][] street = new int[n][m];

        for (int[] puddle : puddles)
            street[puddle[1] - 1][puddle[0] - 1] = -1;

        street[0][0] = 1;

        for (int i = 0; i < n; i++) { // 시작점은 1로 저장
            for (int j = 0; j < m; j++) {
                if (street[i][j] == -1) {
                    street[i][j] = 0;
                } else {
                    if (i != 0) {
                        street[i][j] += street[i - 1][j] % 1000000007;
                    }

                    if (j != 0) {
                        street[i][j] += street[i][j - 1] % 1000000007;
                    }
                }
            }
        }

        return street[n - 1][m - 1] % 1000000007;
    }

//    public int solution(int m, int n, int[][] puddles) {
//
//        visit = new boolean[n][m];
//
//        for (int i = 0; i < puddles.length; i++) {
//            int x = puddles[i][1];
//            int y = puddles[i][0];
//            visit[x - 1][y - 1] = true;
//        }
//
//        bfs(0, 0, 0);
//
//        return answer & 1_000_000_007;
//    }

//    private static void bfs(int x, int y, int count) {
//        if (x == visit.length - 1 && y == visit[0].length - 1) {
//
//            if (min == 0) {
//                min = count;
//                answer++;
//            } else if (min == count) {
//                answer++;
//            } else if (min > count) {
//                min = count;
//                answer = 1;
//            }
//
//            return;
//        }
//
//        for (int i = 0; i < 4; i++) {
//            int x1 = x + moveX[i];
//            int y1 = y + moveY[i];
//
//            if (x1 >= 0 && y1 >= 0 && x1 < visit.length && y1 < visit[0].length) {
//                if (!visit[x1][y1]) {
//                    visit[x1][y1] = true;
//                    bfs(x1, y1, count + 1);
//                    visit[x1][y1] = false;
//                }
//            }
//
//        }
//
//    }
}
