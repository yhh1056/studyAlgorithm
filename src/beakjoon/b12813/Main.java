package beakjoon.b12813;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 이진수 연산
 * author {yhh1056}
 * Create by {2020/09/25}
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] a = new int[100001];
        int[] b = new int[100001];

        String inputA = br.readLine();
        String inputB = br.readLine();
        int len = inputA.length();

        for (int i = 0; i < len; i++) {
            a[i] = inputA.charAt(i) - '0';
            b[i] = inputB.charAt(i) - '0';
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(a[i] & b[i]);
        }

        sb.append("\n");
        for (int i = 0; i < len; i++) {
            sb.append(a[i] | b[i]);
        }

        sb.append("\n");
        // A^B
        for (int i = 0; i < len; i++) {
            sb.append(a[i] ^ b[i]);
        }

        sb.append("\n");
        // ~A
        for (int i = 0; i < len; i++) {
            sb.append(a[i] ^ 1);
        }

        sb.append("\n");
        // ~B
        for (int i = 0; i < len; i++) {
            sb.append(b[i] ^ 1);
        }

        sb.append("\n");
        System.out.println(sb);
    }
}
