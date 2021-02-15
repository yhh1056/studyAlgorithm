package beakjoon.b1120;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] split = input.split(" ");

        String a = split[0];
        String b = split[1];

        int result = 50;

        int length = b.length() - a.length();

        for (int i = 0; i <= length; i++) {
            String cut = b.substring(i);
            int tmp = 0;

            for (int j = 0; j < a.length(); j++) {
                if (cut.charAt(j) != a.charAt(j)) {
                    tmp += 1;
                }
            }

            if (tmp < result) {
                result = tmp;
            }
        }

        System.out.println(result);
    }
}
