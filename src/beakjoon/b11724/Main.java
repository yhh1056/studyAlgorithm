package beakjoon.b11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 연결 요소의 개수
 * author {yhh1056}
 * Create by {2020/09/22}
 */
public class Main {
    static int[][] arr = new int[1001][1001];
    static boolean[] visited = new boolean[1001];
    static int quantity;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        quantity = Integer.parseInt(st.nextToken());
        int len = Integer.parseInt(st.nextToken());

        for (int i = 0; i < len; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = 1;
            arr[y][x] = 1;
        }
        int result = 0;

        for (int i = 1; i <= quantity; i++) {
            if (!visited[i]) {
                dfs(i);
                result++;
            }
        }
        System.out.println(result);

    }

    private static void dfs(int index) {
        if (visited[index]) {
            return;
        }
        visited[index] = true;
        for (int i = 1; i <= quantity; i++) {
            if (arr[index][i] == 1) {
                dfs(i);
            }
        }
    }
}
