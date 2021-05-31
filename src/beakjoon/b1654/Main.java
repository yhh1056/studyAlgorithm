package beakjoon.b1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by yhh1056
 * Date: 2021/05/27 Time: 2:00 오후
 * 랜선자르기
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] split = line.split(" ");
        int K = Integer.parseInt(split[0]);
        int N = Integer.parseInt(split[1]);

        int[] lans = new int[K];

        for (int i = 0; i < K; i++) {
            lans[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(lans);

        long answer = 1;
        long mid;

        long left = 1;
        long right = lans[lans.length - 1];

        while (left <= right) {
            mid = (left + right) / 2;

            long total = 0;
            for (int i = 0; i < lans.length; i++) {
                total += lans[i] / mid;
            }

            if (total >= N) {
                answer = Math.max(answer, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);

    }

}
