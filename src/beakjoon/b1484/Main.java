package beakjoon.b1484;

import java.io.*;

/**
 * 다이어트
 * author {yhh1056}
 * Create by {2020/10/02}
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int g = Integer.parseInt(br.readLine());
        //x2 = y2 + g
        long x = 2;
        long y = 1;
        long count = 0;

        while (x != y) {
            long x2 = x * x;
            long y2 = y * y;

            if (x2 < y2 + g) {
                x++;
            }

            if (x2 > y2 + g) {
                y++;
            }
            if (x2 == y2 + g) {
                System.out.println(x);
                count++;
                x++;
                y++;
            }
        }

        if (count == 0) {
            System.out.println(-1);
        }
    }
}
