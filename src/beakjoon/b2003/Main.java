package beakjoon.b2003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 수들의 합 2
 * author {yhh1056}
 * Create by {2020/09/28}
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int len = Integer.parseInt(st.nextToken());
        int sum = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[len];

        int leftPointer = 0;
        int rightPointer = 0;
        int answer = 0;         //counter
        int pointerSum = 0;

        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while (leftPointer < len) {
            if (pointerSum == sum) {
                answer++;
            }
            if (rightPointer == len) {
                pointerSum -= arr[leftPointer++];
            } else if (pointerSum < sum) {
                pointerSum += arr[rightPointer++];
            } else if (pointerSum >= sum) {
                pointerSum -= arr[leftPointer++];
            }
        }
        System.out.println(answer);
    }
}
