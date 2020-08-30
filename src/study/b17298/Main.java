package study.b17298;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * author {yhh1056}
 * Create by {2020/08/30}
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int len = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] nums = new int[len];

        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int max = nums[i];
            int result = -1;

            for (int j = i + 1; j < len; j++) {
                if (nums[j] > max) {
                    result = nums[j];
                    break;
                }
            }
            nums[i] = result;
            sb.append(nums[i] + " ");
        }
        System.out.println(sb.toString());
    }
}
