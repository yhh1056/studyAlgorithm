package beakjoon.b9252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by yhh1056
 * Date: 2021/06/30 Time: 5:41 오후
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();


        int x = a.length();
        int y = b.length();

        int[][] answer = new int[x + 1][y + 1];

        a = " " + a;
        b = " " + b;

        for (int i = 1; i < a.length(); i++) {
            for (int j = 1; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    answer[i][j] = answer[i - 1][j - 1] + 1;
                } else {
                    answer[i][j] = Math.max(answer[i - 1][j], answer[i][j - 1]);
                }
            }
        }

        System.out.println(answer[a.length() - 1][b.length() - 1]);

        Stack<String> result = new Stack<>();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int tmp = answer[a.length() - 1][b.length() - 1];

        while (answer[i][j] != 0) {

            if (answer[i - 1][j] == tmp) {
                i -= 1;
            } else if (answer[i][j - 1] == tmp) {
                j -= 1;
            } else {
                result.push(String.valueOf(a.charAt(i)));
                i -= 1;
                j -= 1;
                tmp--;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!result.isEmpty()) {
            sb.append(result.pop());
        }

        System.out.println(sb.toString());
    }

}
