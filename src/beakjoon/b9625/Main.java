package beakjoon.b9625;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BABBA
 * author {yhh1056}
 * Create by {2020/09/11}
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int[][] aBQuantity = new int[46][2];
        aBQuantity[0][0] = 1;
        aBQuantity[0][1] = 0;
        aBQuantity[1][0] = 0;
        aBQuantity[1][1] = 1;

        for (int i = 2; i < aBQuantity.length; i++) {
            aBQuantity[i][0] = aBQuantity[i - 2][0] + aBQuantity[i - 1][0];
            aBQuantity[i][1] = aBQuantity[i - 2][1] + aBQuantity[i - 1][1];
        }
        System.out.println(aBQuantity[num][0] + " " + aBQuantity[num][1]);
    }
}
