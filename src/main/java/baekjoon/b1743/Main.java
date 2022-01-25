package baekjoon.b1743;

import archive.algorithm.archive.provider.baekjoon.Baekjoon;
import archive.algorithm.archive.provider.baekjoon.BaekjoonLevel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

@Baekjoon(number = 1743, level = BaekjoonLevel.SILVER)
public class Main {
    static int[] moveX = new int[] {0, 0, 1, -1};
    static int[] moveY = new int[] {1, -1, 0, 0};
    static int N;
    static int M;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[][] zone = new int[N][M];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            zone[x - 1][y -1] = 1;
        }

        solution(zone);
    }

    private static void solution(int[][] zone) {
        boolean[][] visit = new boolean[zone.length][zone[0].length];

        int answer = 0;
        for (int i = 0; i < zone.length; i++) {
            for (int j = 0; j < zone[i].length; j++) {
                if (zone[i][j] == 1) {
                    answer = Math.max(answer, bfs(zone, i, j, visit));
                }
            }
        }

        System.out.println(answer);
    }

    private static int bfs(int[][] zone, int x, int y, boolean[][] visit) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});

        int size = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = now[0] + moveX[i];
                int nextY = now[1] + moveY[i];

                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
                    if (zone[nextX][nextY] == 1 && !visit[nextX][nextY]) {
                        visit[nextX][nextY] = true;
                        size += 1;
                        queue.add(new int[] {nextX, nextY});
                    }
                }
            }
        }
        return size;
    }
}
