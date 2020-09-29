package beakjoon.b7453;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * 합이 0인 네정수
 * author {yhh1056}
 * Create by {2020/09/29}
 */

//2
//0 -100 2 2
//0 -4 2 4

//2
//0 4 -2 -2
//4 0 -2 -2
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());

        //배열 두개를 합칠 때 사이즈
        int combiSize = len * len;

        int[] a = new int[len];
        int[] b = new int[len];
        int[] c = new int[len];
        int[] d = new int[len];

        long[] AB = new long[combiSize];
        long[] CD = new long[combiSize];

        StringTokenizer st;
        for (int i = 0; i < len; i++) {
            st = new StringTokenizer(br.readLine());

            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
            d[i] = Integer.parseInt(st.nextToken());
        }

        int index = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                AB[index] = a[i] + b[j];
                CD[index] = c[i] + d[j];
                index++;
            }
        }
        Arrays.sort(AB);
        Arrays.sort(CD);
//
//        System.out.println(Arrays.toString(AB));
//        System.out.println(Arrays.toString(CD));

        int end = combiSize - 1;

        int leftPointer = 0;
        int rightPointer = end;
        long count = 0;

        while (leftPointer < combiSize && rightPointer >= 0) {
            long leftNumber = AB[leftPointer];
            long rightNumber = CD[rightPointer];
            long sum = leftNumber + rightNumber;
            long leftCount = 0;
            long rightCount = 0;

            if (sum == 0) {

                while (leftPointer < combiSize && leftNumber == AB[leftPointer]) {
                    leftCount++;
                    leftPointer++;
                }
                while (rightPointer >= 0 && rightNumber == CD[rightPointer]) {
                    rightCount++;
                    rightPointer--;
                }
                count += leftCount * rightCount;
            }

            if (sum > 0L) {
                rightPointer--;
            }

            if (sum < 0L) {
                leftPointer++;
            }
        }

        System.out.println(count);
    }
}
