package beakjoon.b2096;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 내려 가기
 * author {yhh1056}
 * Create by {2020/10/02}
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());

        int[][] maxPage = new int[len][3];
        int[][] minPage = new int[len][3];

        for (int i = 0; i < len; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                maxPage[i][j] = Integer.parseInt(st.nextToken());
                minPage[i][j] = maxPage[i][j];
            }
        }

        int[] maxNums = new int[3];
        int[] minNums = new int[3];
        for (int i = 0; i < 3; i++) {
            maxNums[i] = maxPage[0][i];
            minNums[i] = minPage[0][i];
        }

        for (int i = 1; i < len; i++) {
            maxPage[i][0] += Math.max(maxNums[0], maxNums[1]);
            maxPage[i][1] += Math.max(maxNums[0], Math.max(maxNums[1], maxNums[2]));
            maxPage[i][2] += Math.max(maxNums[1], maxNums[2]);

            minPage[i][0] += Math.min(minNums[0], minNums[1]);
            minPage[i][1] += Math.min(minNums[0], Math.min(minNums[1], minNums[2]));
            minPage[i][2] += Math.min(minNums[1], minNums[2]);

            maxNums[0] = maxPage[i][0];
            maxNums[1] = maxPage[i][1];
            maxNums[2] = maxPage[i][2];

            minNums[0] = minPage[i][0];
            minNums[1] = minPage[i][1];
            minNums[2] = minPage[i][2];
        }

        Arrays.sort(maxPage[len - 1]);
        Arrays.sort(minPage[len - 1]);
        System.out.print(maxPage[len - 1][2] + " " + minPage[len - 1][0]);
    }
}
