package beakjoon.b2798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * author {yhh1056}
 * Create by {2020/09/15}
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int len = Integer.parseInt(st.nextToken());
        int blackJackNumber = Integer.parseInt(st.nextToken());

        int[] cards = new int[len];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < len; i++) {
            cards[i] = Integer.parseInt(st2.nextToken());
        }
        int sum;
        int tmp = 0;
        for (int i = 0; i < len; i++) {
            for (int k = i + 1; k < len; k++) {
                for (int j = k + 1; j < len; j++) {
                    sum = cards[i] + cards[j] + cards[k];
                    if (sum == blackJackNumber) {
                        System.out.println(sum);
                        System.exit(0);
                    }
                    if (sum < blackJackNumber && tmp < sum) {
                        tmp = sum;
                    }
                }
            }
        }
        System.out.println(tmp);
    }
}
