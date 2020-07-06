package programmers.p12910;

import java.util.ArrayList;
import java.util.Collections;

/**
 * author {yhh1056}
 * Create by {2020/07/06}
 */

//input을 테스트 하기 위한 코드입니다.
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[]{5, 9, 7, 10}, 5);
    }
}

class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                arrayList.add(arr[i]);
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(-1);
        }
        Collections.sort(arrayList);

        int[] array = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            array[i] = arrayList.get(i);
        }
        System.out.println(array);
        return array;
    }
}
