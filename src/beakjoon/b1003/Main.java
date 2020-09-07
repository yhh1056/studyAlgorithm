package beakjoon.b1003;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * author {yhh1056}
 * Create by {2020/09/06}
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int[][] answer = new int[41][2];
        answer[0][0] = 1;
        answer[1][1] = 1;

        for (int i = 2; i <= 40; i++) {
            for (int j = 0; j < 2; j++) {
                answer[i][j] = answer[i - 2][j] + answer[i - 1][j];
            }
        }

        for (int i = 0; i < len; i++) {
            int num = Integer.parseInt(br.readLine());
            System.out.println(answer[num][0] + " " + answer[num][1]);
        }
    }
}


