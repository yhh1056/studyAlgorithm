package beakjoon.b2470;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 두 용액
 * author {yhh1056}
 * Create by {2020/10/02}
 */
public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int len = Integer.parseInt(br.readLine());
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int[] arr = new int[len];
//        for (int i = 0; i < len; i++) {
//            arr[i] = Integer.parseInt(st.nextToken());
//        }
//        Arrays.sort(arr);
//
//        int leftPointer = 0;
//        int rightPointer = len - 1;
//        long maxNumber = 2000000000;
//
//        int result1 = 0;
//        int result2 = 0;
//
//        while (arr[leftPointer] != arr[rightPointer]) {
//            int sum = arr[leftPointer] + arr[rightPointer];
//            if (Math.abs(sum) < Math.abs(maxNumber)) {
//                result1 = arr[leftPointer];
//                result2 = arr[rightPointer];
//                maxNumber = sum;
//            }
//            if (sum > 0) {
//                rightPointer--;
//            }
//
//            if (sum < 0) {
//                leftPointer++;
//            }
//
//            if (sum == 0) {
//                result1 = arr[leftPointer];
//                result2 = arr[rightPointer];
//                break;
//            }
//        }
//
//        if (result1 > result2) {
//            System.out.println(result2 + " " + result1);
//        } else {
//            System.out.println(result1 + " " + result2);
//        }
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n];

        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        int left = 0;
        int right = array.length - 1;

        int tmp = Integer.MAX_VALUE;
        int[] answer = new int[2];

        while (left < right) {
            int mid = array[left] + array[right];

            if (mid == 0) {
                answer[0] = array[left];
                answer[1] = array[right];
                break;
            }

            int abs = Math.abs(mid);
            if (abs < tmp) {
                tmp = abs;
                answer[0] = array[left];
                answer[1] = array[right];
            }

            if (mid > 0) {
                right--;
            }
            if (mid < 0) {
                left++;
            }
        }

        System.out.println(answer[0] + " " + answer[1]);

    }
}
