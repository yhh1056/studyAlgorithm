package beackjoon2.recursion.b10872;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA
 * User: yhh1056@naver.com
 * Date: 2021/04/26 Time: 10:35 오전
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());

        if (input == 0) {
            System.out.println(1);
            return;
        }

        System.out.println(factorial(input));
    }

    private static int factorial(int input) {
        if (input <= 1) {
            return input;
        }
        return factorial(input - 1) * input;
    }
}
