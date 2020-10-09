package beakjoon.b4256;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 트리
 * author {yhh1056}
 * Create by {2020/10/08}
 */
public class Main {
    static int preOrder[];
    static int inOrder[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            preOrder = new int[n + 1];
            inOrder = new int[n + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                preOrder[j] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                inOrder[j] = Integer.parseInt(st.nextToken());

            postorder(0, n, 0);
            System.out.println();
        }
    }

    public static void postorder(int s, int e, int root) {
        for (int i = s; i < e; i++) {
            if (preOrder[root] == inOrder[i]) {
                postorder(s, i, root + 1);
                postorder(i + 1, e, root + i - s + 1);
                System.out.print(preOrder[root] + " ");
            }
        }
    }
}