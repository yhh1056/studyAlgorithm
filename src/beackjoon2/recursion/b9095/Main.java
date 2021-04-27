package beackjoon2.recursion.b9095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA
 * User: yhh1056@naver.com
 * Date: 2021/04/26 Time: 11:06 오전
 */
public class Main {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cycle = Integer.parseInt(br.readLine());

        for (int i = 0; i < cycle; i++) {
            int n = Integer.parseInt(br.readLine());

            add(0, n);
            System.out.println(count);
            count = 0;
        }
    }

    private static void add(int sum, int n) {
        if (sum > n) {
            return;
        }

        if (sum == n) {
            count++;
            return;
        }

        for (int i = 1; i <= 3; i++) {
            add(sum + i, n);
        }

    }

}
