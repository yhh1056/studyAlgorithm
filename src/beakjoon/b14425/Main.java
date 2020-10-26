package beakjoon.b14425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 문자열 집합
 * author {yhh1056}
 * Create by {2020/10/05}
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashSet<String> s = new HashSet<>();

        for (int i = 0; i < n; i++) {
            s.add(br.readLine());
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            String word = br.readLine();
            if (s.contains(word)) {
                count++;
            }
        }

        System.out.println(count);
    }
}
