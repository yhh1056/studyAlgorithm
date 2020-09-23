package beakjoon.b7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 토마토
 * author {yhh1056}
 * Create by {2020/09/23}
 */
public class Main {
    static int[] x = new int[]{-1, 1, 0, 0};
    static int[] y = new int[]{0, 0, -1, 1};
    static int[][] tomatoContainer;
    static int row;
    static int column;
    static Queue<Integer> xQ;
    static Queue<Integer> yQ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        column = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        tomatoContainer = new int[row][column];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < column; j++) {
                tomatoContainer[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        xQ = new LinkedList<>();
        yQ = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (tomatoContainer[i][j] == 1) {
                    xQ.offer(i);
                    yQ.offer(j);
                }
            }
        }

        while (!xQ.isEmpty()) {
            int tmpX = xQ.poll();
            int tmpY = yQ.poll();

            for (int k = 0; k < 4; k++) {
                int moveX = tmpX + x[k];
                int moveY = tmpY + y[k];

                if (moveX >= 0 && moveX < row && moveY >= 0 && moveY < column) {
                    if (tomatoContainer[moveX][moveY] == 0) {
                        xQ.offer(moveX);
                        yQ.offer(moveY);
                        tomatoContainer[moveX][moveY] = tomatoContainer[tmpX][tmpY] + 1;
                    }
                }
            }
        }

        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (tomatoContainer[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                if (max < tomatoContainer[i][j]) {
                    max = tomatoContainer[i][j];
                }
            }
        }
        System.out.println(max - 1);
    }
}
