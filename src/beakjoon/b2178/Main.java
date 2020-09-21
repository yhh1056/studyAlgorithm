package beakjoon.b2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 미로 탐색
 * author {yhh1056}
 * Create by {2020/09/21}
 */
public class Main {
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};
    static int row;
    static int column;
    static int[][] maze;
    static boolean[][] check;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        column = Integer.parseInt(st.nextToken());
        maze = new int[row][column];
        check = new boolean[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                maze[i][j] = br.read() - 48;
            }
            br.readLine();
        }

        Queue<Integer> queueX = new LinkedList<>();
        queueX.offer(0);
        Queue<Integer> queueY = new LinkedList<>();
        queueY.offer(0);

        while (!queueX.isEmpty()) {
            int x = queueX.poll();
            int y = queueY.poll();

            for (int i = 0; i < 4; i++) {
                int moveX = x + dx[i];
                int moveY = y + dy[i];

                if (moveX >= 0 && moveY >= 0) {
                    if (moveX < row && moveY < column) {
                        if (maze[moveX][moveY] == 1 && !check[moveX][moveY]) {
                            queueX.offer(moveX);
                            queueY.offer(moveY);

                            check[moveX][moveY] = true;
                            maze[moveX][moveY] = maze[x][y] + 1;
                        }
                    }
                }
            }

        }
        System.out.println(maze[row - 1][column - 1]);
    }

}
