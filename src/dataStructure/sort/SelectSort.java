package dataStructure.sort;

/**
 * 선택 정렬
 * author {yhh1056}
 * Create by {2020/09/02}
 */
public class SelectSort {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int[] array = {9, 3, 1, 9, 5, 6, -1};

        for (int i = 0; i < array.length; i++) {
            int index = 0;
            int min = array[i];

            for (int j = i + 1; j < array.length; j++) {
                if (min > array[j]) {
                    min = array[j];
                    index = j;
                }
            }
            /*해당 위치의 인덱스 값과 min 값을 바꾼다.*/
            array[index] = array[i];
            array[i] = min;

            sb.append(array[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
