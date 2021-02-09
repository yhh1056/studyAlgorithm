package beakjoon.b10610;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] nums = new int[10];
        int sum = 0;
        int length = input.length();

        for (int i = 0; i < length; i++) {
            final int num = input.charAt(i) - '0';
            sum += num;
            nums[num] += 1;
        }


        if (nums[0] == 0 || sum % 3 != 0) {
            System.out.println("-1");
            return;
        }

        StringBuilder sb = new StringBuilder();
        int count = 9;
        while (true) {
            if (nums[count] != 0) {
                sb.append(count);
                nums[count] -= 1;
            } else {
                count--;
            }
            if (count < 0) {
                break;
            }
        }

        System.out.println(sb.toString());
    }
}
