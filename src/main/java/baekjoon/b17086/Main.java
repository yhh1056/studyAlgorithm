package baekjoon.b17086;

import archive.provider.baekjoon.Baekjoon;
import archive.provider.baekjoon.BaekjoonLevel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

@Baekjoon(name = "아기 상어2", url = "https://www.acmicpc.net/problem/17086", level = BaekjoonLevel.SILVER, number = 17086)
public class Main {
    private static int N;
    private static int M;
    private static Queue<int[]> queue;
    private static int[][]  zone;

    public static void main(String[] args) throws IOException {
        // 입력 받기
        initInputValue();

        bfs();

        // 1부터 시작하므로 1을 뺀 값이 가장 큰 안전 거리
        System.out.println(getMaxSafeDistance() - 1);
    }

    private static void initInputValue() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        zone = new int[N][M];
        queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int n = Integer.parseInt(st.nextToken());
                if (n == 1) {
                    queue.add(new int[] {i, j});
                    zone[i][j] = 1;
                } else {
                    zone[i][j] = Integer.MAX_VALUE;
                }
            }
        }
    }

    private static void bfs() {
        // 상하좌우 대각선
        int[] moveX = new int[] {1, -1, 0, 0, 1, 1, -1, -1};
        int[] moveY = new int[] {0, 0, 1, -1, -1, 1, 1, -1};

        while (!queue.isEmpty()) {
            // 큐에서 꺼낸 좌표 정보
            int[] xy = queue.poll();
            int x = xy[0];
            int y = xy[1];

            // 현재 좌표 이동거리
            int now = zone[x][y];

            for (int i = 0; i < 8; i++) {
                // 다음 이동 좌표
                int mx = moveX[i] + x;
                int my = moveY[i] + y;

                // 이동 가능한 좌표인지 확인
                if (mx >= 0 && mx < N && my >= 0 && my < M) {
                    int next = zone[mx][my];
                    int nextPoint = now + 1;

                    // Max일경우 바로 다음 좌표 저장, 아닐 경우 더 짧은 이동경로 좌표 저장
                    if (next == Integer.MAX_VALUE) {
                        zone[mx][my] = nextPoint;
                        queue.add(new int[] {mx, my});
                    } else {
                        if (next > nextPoint) {
                            zone[mx][my] = nextPoint;
                            queue.add(new int[] {mx, my});
                        }
                    }
                }

            }
        }
    }

    private static int getMaxSafeDistance() {
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                answer = Math.max(answer, zone[i][j]);
            }
        }
        return answer;
    }
}
