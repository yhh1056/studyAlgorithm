package beakjoon.b2583;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 영역 구하기
 * author {yhh1056}
 * Create by {2020/09/27}
 */
public class Main {
    static int[] mx = new int[]{-1, 1, 0, 0};
    static int[] my = new int[]{0, 0, -1, 1};
    static int m;
    static int n;
    static int k;
    static int[][] land;
    static boolean[][] check;
    public static Queue<Integer> qX;
    public static Queue<Integer> qY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        land = new int[m][n];
        check = new boolean[m][n];
        List<Integer> list = new ArrayList<>();


        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int j = y1; j < y2; j++) {
                for (int l = x1; l < x2; l++) {
                    land[j][l] = 1;
                    check[j][l] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!check[i][j]) {
                    check[i][j] = true;
                    int count = bfs(i, j);
                    list.add(count);
                }
            }
        }

        Collections.sort(list);

        System.out.println(list.size());
        for (int result : list) {
            System.out.print(result + " ");
        }
    }

    private static int bfs(int i, int j) {
        int count = 1;
        qX = new LinkedList<>();
        qY = new LinkedList<>();
        qX.offer(i);
        qY.offer(j);

        while (!qX.isEmpty()) {
            int x = qX.poll();
            int y = qY.poll();

            for (int l = 0; l < 4; l++) {
                int moveX = x + mx[l];
                int moveY = y + my[l];

                if (moveX >= 0 && moveX < m && moveY >= 0 && moveY < n) {
                    if (!check[moveX][moveY]) {
                        check[moveX][moveY] = true;
                        count++;
                        qX.offer(moveX);
                        qY.offer(moveY);
                    }
                }
            }
        }
        return count;
    }

}
