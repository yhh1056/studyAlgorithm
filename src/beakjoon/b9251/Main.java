package beakjoon.b9251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * LCS
 * author {yhh1056}
 * Create by {2020/11/05}
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        int[][] lcs = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i <= s1.length(); i++) {
            char s1Unit = s1.charAt(i - 1);

            for (int j = 1; j <= s2.length(); j++) {
                char s2Unit = s2.charAt(j - 1);

                //같을 때 왼쪽 대각선 값 + 1
                if (s1Unit == s2Unit) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                    //다를때 왼쪽, 상단 중 큰 값
                } else {
                    lcs[i][j] = Math.max(lcs[i][j - 1], lcs[i - 1][j]);
                }
            }
        }

        System.out.println(lcs[s1.length()][s2.length()]);
    }
}
