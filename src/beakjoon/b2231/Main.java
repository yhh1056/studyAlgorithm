package beakjoon.b2231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * author {yhh1056}
 * 분해핪
 * Create by {2020/09/14}
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        for (int i = 1; i <= input; i++) {
            int result = 0;
            int firstNumber = i;

            while (firstNumber != 0) {
                result += firstNumber % 10;
                firstNumber /= 10;
            }
            result = result + i;
            if (result == input) {
                System.out.println(i);
                System.exit(0);
            }
        }
        System.out.println(0);
    }
}
