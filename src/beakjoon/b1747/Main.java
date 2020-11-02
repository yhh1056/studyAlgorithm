package beakjoon.b1747;

import java.io.*;

/**
 * 소수 & 팰린드롬
 * author {yhh1056}
 * Create by {2020/11/02}
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        boolean[] prime = new boolean[1200000];

        prime[1] = true;
        for (int i = 2; i * i < prime.length; i++) {
            if (!prime[i]) {
                for (int j = i * i; j < prime.length; j += i) {
                    prime[j] = true;
                }
            }
        }

        for (int i = 1; i < prime.length; i++) {
            if (!prime[i] && isPalendrom(i) && i >= num) {
                System.out.println(i);
                break;
            }
        }
    }

    private static boolean isPalendrom(int num) {
        String snum = String.valueOf(num);
        String string = reverseString(snum);
        return snum.equals(string);
    }

    public static String reverseString(String s) {
        return (new StringBuffer(s)).reverse().toString();
    }
}
