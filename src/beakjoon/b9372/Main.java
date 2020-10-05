package beakjoon.b9372;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 상근이의 여행
 * author {yhh1056}
 * Create by {2020/10/05}
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < len; i++) {
            st = new StringTokenizer(br.readLine());
            int country = Integer.parseInt(st.nextToken());
            int air = Integer.parseInt(st.nextToken());
            for (int j = 0; j < air; j++) {
                st = new StringTokenizer(br.readLine());
            }
            System.out.println(country - 1);
        }
    }
}
