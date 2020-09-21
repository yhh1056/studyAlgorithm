package beakjoon.b10448;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;


/**
 * 유레카이론
 * author {yhh1056}
 * Create by {2020/09/15}
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int[] sums = new int[44];
        sums[0] = 1;
        for (int i = 1; i < 44; i++) {
            sums[i] = sums[i - 1] + i + 1;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 44; i++) {
            for (int j = 0; j < 44; j++) {
                for (int k = 0; k < 44; k++) {
                    int sum = sums[i] + sums[j] + sums[k];
                    if (sum <= 1000) {
                        set.add(sum);
                    }
                }
            }
        }

        for (int i = 0; i < len; i++) {
            int answer = Integer.parseInt(br.readLine());
            if (set.contains(answer)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
