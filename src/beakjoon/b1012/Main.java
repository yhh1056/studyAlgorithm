package beakjoon.b1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 유기농 배추
 * author {yhh1056}
 * Create by {2020/09/21}
 */
public class Main {
    static int[] upDownLeftRightByX = new int[]{0, 1, -1, 0};
    static int[] upDownLeftRightByY = new int[]{-1, 0, 0, 1};
    static int row;
    static int column;
    static int[][] cabbageFarm;
    static boolean[][] visit;
    static final int cabbage = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int range = toInt(br.readLine());

        for (int r = 0; r < range; r++) {
            int cabbageWhiteEarthworm = 0;          //배추흰지렁이 갯수
            StringTokenizer st = new StringTokenizer(br.readLine());
            row = toInt(st.nextToken());
            column = toInt(st.nextToken());
            int quantity = toInt(st.nextToken());

            cabbageFarm = new int[row][column];
            visit = new boolean[row][column];

            for (int i = 0; i < quantity; i++) {
                st = new StringTokenizer(br.readLine());
                int x = toInt(st.nextToken());
                int y = toInt(st.nextToken());

                cabbageFarm[x][y] = cabbage;
            }

            for (int x = 0; x < row; x++) {
                for (int y = 0; y < column; y++) {
                    if (cabbageFarm[x][y] == cabbage && !visit[x][y]) {
                        findConnectCabbage(x, y);
                        cabbageWhiteEarthworm++;
                    }
                }
            }
            System.out.println(cabbageWhiteEarthworm);
        }
    }

    private static void findConnectCabbage(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) {
            x = queue.peek()[0];
            y = queue.peek()[1];
            visit[x][y] = true;
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int connectX = x + upDownLeftRightByX[i];
                int connectY = y + upDownLeftRightByY[i];

                if (connectX >= 0 && connectY >= 0 && connectX < row && connectY < column) {
                    if (cabbageFarm[connectX][connectY] == cabbage && !visit[connectX][connectY]) {
                        queue.offer(new int[]{connectX, connectY});
                        visit[connectX][connectY] = true;
                    }
                }
            }
        }
    }

    public static int toInt(String s) {
        return Integer.parseInt(s);
    }
}
