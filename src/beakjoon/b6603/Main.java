package beakjoon.b6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 로또
 * author {yhh1056}
 * Create by {2020/09/23}
 */
public class Main {
    static int[] arr;
    static int[] result;
    static int len;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            len = Integer.parseInt(st.nextToken());

            if (len == 0) {
                break;
            }

            arr = new int[len];
            result = new int[len];
            for (int i = 0; i < len; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);
            System.out.println();
        }

    }

    private static void dfs(int start, int depth) {
        if (depth == 6) {
            for (int i = 0; i < len; i++) {
                if (result[i] == 1) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
        }
        for (int i = start; i < len; i++) {
            result[i] = 1;
            dfs(i + 1, depth + 1);
            result[i] = 0;
        }
    }
}
