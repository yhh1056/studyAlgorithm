package sortPractice;

import java.util.Arrays;

/**
 * author {yhh1056}
 * Create by {2020/09/04}
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = {9, 3, 1, 9, 5, 6, -1};
        int length = array.length;

        quicksort(array,0,length-1);

        System.out.println(Arrays.toString(array));
    }
    static void quicksort(int[] arr, int start, int end) {
        if (start >= end) { //원소가 1개일 때 처리
            return;
        }
        int pivot = start;
        int i = start + 1;
        int j = end;

        while (i <= j) { // 엇갈릴 때까지 반복
            while (i <= end && arr[pivot] >= arr[i]) {
                i++;
            }
            while (j > start && arr[pivot] <= arr[j]) {
                j--;
            }
            int temp = arr[j];
            if (i > j) { // 엇갈렸을 때 j,pivot 교환
                arr[j] = arr[pivot];
                arr[pivot] = temp;

            } else { // 엇갈리지 않았을 때 i,j 교환
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        quicksort(arr, start, j - 1);
        quicksort(arr, j + 1, end);
    }
}
