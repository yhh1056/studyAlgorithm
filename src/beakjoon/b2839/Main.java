package beakjoon.b2839;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 설탕 배달
 * author {yhh1056}
 * Create by {2020/09/09}
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int[] numbers = new int[5001];
        numbers[0] = -1;
        numbers[1] = -1;
        numbers[2] = -1;
        numbers[3] = 1;
        numbers[4] = -1;
        numbers[5] = 1;

        for (int i = 6; i <= 5000; i++) {
            int t = i - 3;
            int f = i - 5;
            if (numbers[t] == -1 && numbers[f] == -1) {
                numbers[i] = -1;
            } else if (numbers[t] == -1 && numbers[f] != -1) {
                numbers[i] = numbers[f] + 1;
            } else if (numbers[t] != -1 && numbers[f] == -1) {
                numbers[i] = numbers[t] + 1;
            } else if (numbers[t] > numbers[f]) {
                numbers[i] = numbers[f] + 1;
            } else if (numbers[t] < numbers[f]) {
                numbers[i] = numbers[t] + 1;
            } else if (numbers[t] == numbers[f]) {
                numbers[i] = numbers[t] + 1;
            }
        }
        System.out.println(numbers[number]);
    }
}
