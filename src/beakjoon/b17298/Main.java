package beakjoon.b17298;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 오큰수
 * author {yhh1056}
 * Create by {2020/08/30}
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int len = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[len];
        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < len; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            }
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                result[stack.pop()] = nums[i];

            }
            stack.push(i);
        }
        for (int n : result) {
            sb.append(n).append(" ");
        }
        System.out.println(sb.toString());
    }
}

