package sortPractice;

import java.util.Arrays;

/**
 * author {yhh1056}
 * Create by {2020/09/03}
 */
public class bubbleSort {
    public static void main(String[] args) {
        int[] array = {9, 3, 1, 9, 5, 6, -1};
        int length = array.length;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - (i + 1); j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}

