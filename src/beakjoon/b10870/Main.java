package beakjoon.b10870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 피보나치 5
 * author {yhh1056}
 * Create by {2020/09/07}
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

//        System.out.println(fibonacci(num));
        int[] answer = new int[21];
        answer[0] = 0;
        answer[1] = 1;
        for (int i = 2; i <= 20; i++) {
            answer[i] =  answer[i - 2] + answer[i - 1];
        }
        System.out.println(answer[num]);
    }
//    static int fibonacci(int n) {
//        if (n <= 1) {	// F(0) = 0, F(1) = 1
//            return n;
//        } else {
//            return fibonacci(n-1) + fibonacci(n-2);
//        }
//    }
}
