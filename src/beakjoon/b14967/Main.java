package beakjoon.b14967;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 방 배정하기
 * author {yhh1056}
 * Create by {2020/09/07}
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int total = Integer.parseInt(st.nextToken());

        int[] answer = new int[total + 1];

        answer[0] = 1;
        for (int i = 1; i <= total; i++) {
            if (i >= a) {
                if (i >= b) {
                    if (i >= c) {
                        answer[i] = answer[i - a] + answer[i - b] + answer[i - c];
                    }  else {
                        answer[i] = answer[i - a] + answer[i - b];
                    }
                } else {
                    answer[i] = answer[i - a];
                }
            } else {
                answer[i] = 0;
            }

        }
        if (answer[total] == 0) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }

    }
}
