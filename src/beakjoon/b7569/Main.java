package beakjoon.b7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *
 * 토마토
 *
 * 풀이시간 : 45분
 *
 * 무난한 3차원 bfs
 */
public class Main {

    static boolean[][][] visit;
    static int[][][] count;
    static int[][][] box;

    static int[] X = new int[]{-1, 1, 0, 0, 0, 0};
    static int[] Y = new int[]{0, 0, -1, 1, 0, 0};
    static int[] Z = new int[]{0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        box = new int[H][N][M];
        count = new int[H][N][M];
        visit = new boolean[H][N][M];

        int tmp = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    int num = Integer.parseInt(st.nextToken());
                    box[i][j][k] = num;

                    if (num == 0) {
                        tmp++;
                    }
                }
            }
        }

        if (tmp == 0) {
            System.out.println(0);
            return;
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (box[i][j][k] == 1) {
                        queue.add(new int[]{i, j, k});
                        visit[i][j][k] = true;
                        count[i][j][k] = 1;
                    }

                    if (box[i][j][k] == -1) {
                        visit[i][j][k] = true;
                        count[i][j][k] = -1;
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[2];
            int y = poll[1];
            int z = poll[0];

            for (int i = 0; i < 6; i++) {
                int tmpX = x + X[i];
                int tmpY = y + Y[i];
                int tmpZ = z + Z[i];

                if (tmpX >= 0 && tmpX < M && tmpY >= 0 && tmpY < N && tmpZ >= 0 && tmpZ < H) {
                    if (box[tmpZ][tmpY][tmpX] != -1 && !visit[tmpZ][tmpY][tmpX]) {
                        visit[tmpZ][tmpY][tmpX] = true;
                        queue.offer(new int[]{tmpZ, tmpY, tmpX});
                        // 현재 이동한 값과 기존의 값중 더 적은 움직임을 저장
                        if (count[tmpZ][tmpY][tmpX] == 0) {
                            count[tmpZ][tmpY][tmpX] = count[z][y][x] + 1;
                        } else {
                            count[tmpZ][tmpY][tmpX] = Math.min(count[tmpZ][tmpY][tmpX], count[z][y][x] + 1);
                        }

                    }
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (count[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }

                    answer = Math.max(count[i][j][k], answer);
                }
            }
        }

        System.out.println(answer - 1);
    }
}
