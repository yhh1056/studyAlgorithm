package beakjoon.b1261;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 1261번 : 알고스팟
 * author {yhh1056}
 * Create by {2020/10/29}
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] maze = new int[n][m];
        int[][] count = new int[n][m];
        boolean[][] visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = str.charAt(j) - '0';
            }
        }

        visit[0][0] = true;
        int[] moveX = {0, 1, 0, -1};
        int[] moveY = {1, 0, -1, 0};

        Deque<Point> deque = new ArrayDeque<>();
        deque.offer(new Point(0, 0));

        while (!deque.isEmpty()) {
            Point point = deque.poll();
            if (visit[n -1 ][m - 1]) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = point.x + moveX[i];
                int nextY = point.y + moveY[i];

                if (nextX < n && nextY < m && nextX >= 0 && nextY >= 0) {
                    if (!visit[nextX][nextY]) {
                        visit[nextX][nextY] = true;

                        if (maze[nextX][nextY] == 0) {
                            count[nextX][nextY] = count[point.x][point.y];
                            deque.addFirst(new Point(nextX, nextY));
                        }

                        if (maze[nextX][nextY] == 1) {
                            count[nextX][nextY] = count[point.x][point.y] + 1;
                            deque.offer(new Point(nextX, nextY));
                        }
                    }
                }
            }
        }
        System.out.println(count[n - 1][m - 1]);
    }
}

class Point {
    int x;
    int y;
    boolean visit;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        visit = true;
    }
}
