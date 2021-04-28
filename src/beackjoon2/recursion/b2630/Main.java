package beackjoon2.recursion.b2630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 2630번 : 색종이 만들기
 * Created by IntelliJ IDEA
 * User: yhh1056@naver.com
 * Date: 2021/04/28 Time: 10:18 오전
 */
public class Main {

    static int blueCount = 0;
    static int whiteCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] paper = new int[n][n];

        int count = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int blueOrWhite = Integer.parseInt(st.nextToken());

                if (blueOrWhite == 1) {
                    count++;
                }
                paper[i][j] = blueOrWhite;
            }
        }

        if (count == n * n) {
            blueCount++;
            System.out.println(whiteCount);
            System.out.println(blueCount);
            return;
        }

        if (count == 0) {
            whiteCount++;
            System.out.println(whiteCount);
            System.out.println(blueCount);
            return;
        }

        // 0 0, 0 4, 4 0, 4,4
        cut(n, paper);

        System.out.println(whiteCount);
        System.out.println(blueCount);

    }

    private static void recursion(int[][] paper, int x, int y, int n) {
        int[][] cuttingPaper = new int[n][n];

        int count = 0;
        for (int i = 0; i < n; i++) {
            int tmp = y;
            for (int j = 0; j < n; j++) {
                int xy = paper[x][tmp];

                if (xy == 1) {
                    count++;
                }

                cuttingPaper[i][j] = xy;
                tmp += 1;
            }
            x += 1;
        }

        if (cuttingPaper.length == 1) {
            if (cuttingPaper[0][0] == 1) {
                blueCount++;
            } else {
                whiteCount++;
            }
            return;
        }

        if (count == n * n) {
            blueCount++;
            return;
        }
        if (count == 0) {
            whiteCount++;
            return;
        }

        cut(n, cuttingPaper);

    }

    private static void cut(int n, int[][] cuttingPaper) {
        recursion(cuttingPaper, 0, 0, n/2);
        recursion(cuttingPaper, 0, n/2, n/2);
        recursion(cuttingPaper, n/2, 0, n/2);
        recursion(cuttingPaper, n/2, n/2, n/2);
    }

}
