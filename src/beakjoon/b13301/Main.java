package beakjoon.b13301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 타일 장식물
 * author {yhh1056}
 * Create by {2020/09/11}
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        long[] tile = new long[82];
        tile[1] = 4L;
        tile[2] = 6L;

        for (int i = 3; i < 81; i++) {
            tile[i] = tile[i - 1] + tile[i - 2];
        }

        System.out.println(tile[num]);
    }
}
