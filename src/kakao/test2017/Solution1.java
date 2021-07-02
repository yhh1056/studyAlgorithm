package kakao.test2017;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yhh1056
 * Date: 2021/07/02 Time: 4:13 오후
 */
public class Solution1 {

    static int[] X = new int[]{0, 0, 1, -1};
    static int[] Y = new int[]{1, -1, 0, 0};
    static int[][] book;
    static boolean[][] visit;
    static long now;
    static int numberOfArea;
    static int maxSizeOfOneArea;
    static long[][] PICTURE;

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        book = new int[m][n];
        visit = new boolean[m][n];
        PICTURE = new long[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                PICTURE[i][j] = (long) picture[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && picture[i][j] != 0) {
                    visit[i][j] = true;
                    int tmp = 0;
                    now = picture[i][j];
                    tmp++;
                    tmp += bfs(i, j, m, n, PICTURE);
                    numberOfArea++;

                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, tmp);
                    tmp = 0;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public int bfs(int x, int y, int m, int n, long[][] picture) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        int area = 0;

        while (!queue.isEmpty()) {

            int[] poll = queue.poll();

            for (int i = 0; i < 4; i++) {

                int moveX = poll[0] + X[i];
                int moveY = poll[1] + Y[i];

                if (moveX < m && moveY < n && moveX >= 0 && moveY >= 0) {
                    if (!visit[moveX][moveY] && now == picture[moveX][moveY]) {
                        visit[moveX][moveY] = true;
                        area++;
                        queue.offer(new int[]{moveX, moveY});
                    }
                }
            }
        }

        return area;

    }
}
