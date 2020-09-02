package beakjoon.b2752;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 세수정렬
 * author {yhh1056}
 * Create by {2020/09/02}
 */
public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int[] array = new int[3];
        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }

//        /* 선택정렬 */
//        for (int i = 0; i < 3; i++) {
//            int index = 0;
//            int min = array[i];
//
//            for (int j = i + 1; j < 3; j++) {
//                if (min > array[j]) {
//                    min = array[j];
//                    index = j;
//                }
//            }
//            array[index] = array[i];
//            array[i] = min;
//
//            sb.append(array[i]).append(" ");
//        }
//        System.out.println(sb.toString());

        /* 컬렉션 사용 */
        Arrays.sort(array);

        for (int i : array) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString());
    }
}
