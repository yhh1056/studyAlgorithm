package beakjoon.b2153;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String words = br.readLine();

        int sum = 0;
        for (int i = 0; i < words.length(); i++) {
            final char word = words.charAt(i);
            if (word >= 97) {
                sum += word - 96;
            } else {
                sum += word - 38;
            }
        }
        if (sum == 1) {
            System.out.println("It is a prime word.");
            return;
        }

        for (int i = 2; i < sum; i++) {
            int result = sum % i;
            if (result == 0) {
                System.out.println("It is not a prime word.");
                return;
            }
        }
        System.out.println("It is a prime word.");
    }
}
