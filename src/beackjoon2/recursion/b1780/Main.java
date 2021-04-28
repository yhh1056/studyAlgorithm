package beackjoon2.recursion.b1780;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1780번 종이의 개수
 * Created by IntelliJ IDEA
 * User: yhh1056@naver.com
 * Date: 2021/04/28 Time: 11:28 오전
 */
public class Main {
    static int minusCount = 0;
    static int zeroCount = 0;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] paper = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int xy = Integer.parseInt(st.nextToken());
                paper[i][j] = xy;
            }
        }

        if (isFull(paper, -1)) {
            minusCount++;
            print();
            return;
        }

        if (isFull(paper, 0)) {
            zeroCount++;
            print();
            return;
        }

        if (isFull(paper, 1)) {
            count++;
            print();
            return;
        }

        cut(paper, n);
        print();

    }

    private static void recursion(int[][] paper, int x, int y, int n) {
        int[][] cuttingPaper = new int[n][n];

        for (int i = 0; i < n; i++) {
            int tmp = y;
            for (int j = 0; j < n; j++) {
                int xy = paper[x][tmp];

                cuttingPaper[i][j] = xy;
                tmp += 1;
            }
            x += 1;
        }

        if (cuttingPaper.length == 1) {
            if (cuttingPaper[0][0] == -1) {
                minusCount++;
            } else if (cuttingPaper[0][0] == 0){
                zeroCount++;
            } else {
                count++;
            }
            return;
        }

        if (isFull(cuttingPaper, -1)) {
            minusCount++;
            return;
        }

        if (isFull(cuttingPaper, 0)) {
            zeroCount++;
            return;
        }

        if (isFull(cuttingPaper, 1)) {
            count++;
            return;
        }

        cut(cuttingPaper, n);
    }

    private static boolean isFull(int[][] cuttingPaper, int checkNumber) {
        for (int i = 0; i < cuttingPaper.length; i++) {
            for (int j = 0; j < cuttingPaper[i].length; j++) {
                if (cuttingPaper[i][j] != checkNumber) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void cut(int[][] cuttingPaper, int n) {
        recursion(cuttingPaper, 0, 0, n/3);
        recursion(cuttingPaper, 0, n/3, n/3);
        recursion(cuttingPaper, 0, n/3*2, n/3);

        recursion(cuttingPaper, n/3, 0, n/3);
        recursion(cuttingPaper, n/3, n/3, n/3);
        recursion(cuttingPaper, n/3, n/3*2, n/3);

        recursion(cuttingPaper, n/3*2, 0, n/3);
        recursion(cuttingPaper, n/3*2, n/3, n/3);
        recursion(cuttingPaper, n/3*2, n/3*2, n/3);

    }

    private static void print() {
        System.out.println(minusCount);
        System.out.println(zeroCount);
        System.out.println(count);
    }

}
