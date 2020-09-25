package beakjoon.b10971;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 원판원 순회2
 * author {yhh1056}
 * Create by {2020/09/24}
 */
public class Main {
    static int[][] arr;
    static int len;
    static boolean[] visit;
    static int minSum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        len = Integer.parseInt(br.readLine());
        StringTokenizer st;

        arr = new int[len][len];
        visit = new boolean[len];

        for (int i = 0; i < len; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < len; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0);
        System.out.println(minSum);
    }

    private static void dfs(int depth, int x, int sum) {
        if (depth == len) {
            if (minSum == 0) {
                minSum = sum;
            } else {
                minSum = Math.min(minSum, sum);
            }
            return;
        }
        for (int y = 0; y < len; y++) {
            if (arr[x][y] != 0) {
                if (!visit[y] && (depth != len - 1 || y == 0)) {
                    visit[y] = true;
                    dfs(depth + 1, y, sum + arr[x][y]);
                    visit[y] = false;
                }
            }
        }
    }
}
