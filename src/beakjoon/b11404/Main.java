package beakjoon.b11404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by yhh1056
 * Date: 2021/06/30 Time: 10:51 오후
 */
public class Main {

    static final int INF = 987_654_321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] visit = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                visit[i][j] = INF;

                if (i == j) {
                    visit[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            visit[a][b] = Math.min(visit[a][b], c);
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    visit[i][j] = Math.min(visit[i][k] + visit[k][j], visit[i][j]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (visit[i][j] == INF) {
                    visit[i][j] = 0;
                }
                System.out.print(visit[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

}
