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

        int[] aAndB = new int[len];
        int[] aOrB = new int[len];
        int[] aXorB = new int[len];
        int[] aXor = new int[len];
        int[] bXor = new int[len];

        for (int i = 0; i < len; i++) {
            a[i] = inputA.charAt(i) - 48;
            b[i] = inputB.charAt(i) - 48;
        }

        for (int i = 0; i < len; i++) {
            aAndB[i] = a[i] & b[i];
            aOrB[i] = a[i] | b[i];
            aXorB[i] = a[i] ^ b[i];
            aXor[i] = a[i] ^ 1;
            bXor[i] = b[i] ^ 1;
        }
        for (int i : aAndB) {
            System.out.print(i);
        }
        System.out.println();
        for (int i : aOrB) {
            System.out.print(i);
        }
        System.out.println();
        for (int i : aXorB) {
            System.out.print(i);
        }
        System.out.println();
        for (int i : aXor) {
            System.out.print(i);
        }
        System.out.println();
        for (int i : bXor) {
            System.out.print(i);
        }
        System.out.println();
    }
}
