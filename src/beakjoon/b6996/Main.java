package beakjoon.b6996;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 애너그램
 * author {yhh1056}
 * Create by {2020/09/03}
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());


        for (int i = 0; i < len; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String inputA = st.nextToken();
            String inputB = st.nextToken();

            String[] a = inputA.split("");
            String[] b = inputB.split("");

            Arrays.sort(a);
            Arrays.sort(b);

            if (Arrays.toString(a).equals(Arrays.toString(b))) {
                System.out.println(inputA + " & " + inputB + " are anagrams.");
            } else {
                System.out.println(inputA + " & " + inputB + " are NOT anagrams.");
            }
        }
    }
}
