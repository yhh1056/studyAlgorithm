package dataStructure.sort;

/**
 * author {yhh1056}
 * Create by {2020/09/04}
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {9, 3, 1, 9, 5, 6, -1};
        int length = array.length;

        for (int i = 1; i < length; i++) {
            int j = i;
            int key = array[i];

            while (j > 0 && array[j - 1] > key) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = key;

            for (int value : array) {
                System.out.printf("%3d", value);
            }
            System.out.println();
        }
    }
}
