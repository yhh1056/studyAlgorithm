package beakjoon.b7562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 나이트의 이동
 * author {yhh1056}
 * Create by {2020/09/27}
 */
public class Main {
    //나이트가 시계 방향으로 움직일 수 있는 위치
    public static int[] nmx = {-2, -1, 1, 2, 2, 1, -1, -2};
    public static int[] nmy = {1, 2, 2, 1, -1, -2, -2, -1};
    public static int[][] chess;
    public static boolean[][] visit;
    public static int size;
    public static int[] start = new int[2];
    public static int[] finish = new int[2];
    public static Queue<Integer> qX;
    public static Queue<Integer> qY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());

        for (int i = 0; i < len; i++) {
            size = Integer.parseInt(br.readLine());
            chess = new int[size][size];
            visit = new boolean[size][size];
            setStart(br);
            setFinish(br);

            visit[start[0]][start[1]] = true;
            bfs(start);
            System.out.println(chess[finish[0]][finish[1]]);
        }
    }

    private static void bfs(int[] start) {
        qX = new LinkedList<>();
        qY = new LinkedList<>();
        qX.offer(start[0]);
        qY.offer(start[1]);

        while (!qX.isEmpty()) {
            if (chess[finish[0]][finish[1]] != 0) {
                break;
            }
            int x = qX.poll();
            int y = qY.poll();

            for (int i = 0; i < 8; i++) {
                int moveX = x + nmx[i];
                int moveY = y + nmy[i];

                if (moveX >= 0 && moveX < size && moveY >= 0 && moveY < size) {
                    if (!visit[moveX][moveY]) {
                        visit[moveX][moveY] = true;
                        chess[moveX][moveY] = chess[x][y] + 1;
                        qX.offer(moveX);
                        qY.offer(moveY);
                    }
                }
            }
        }
    }


    public static void setStart(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int inputX = Integer.parseInt(st.nextToken());
        int inputY = Integer.parseInt(st.nextToken());
        start[0] = inputX;
        start[1] = inputY;
    }

    public static void setFinish(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int inputX = Integer.parseInt(st.nextToken());
        int inputY = Integer.parseInt(st.nextToken());
        finish[0] = inputX;
        finish[1] = inputY;
    }
}
