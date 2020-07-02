package programmers.p12906;

import java.util.ArrayList;

/**
 * 같은 숫자는 싫어
 * <p>
 * author {yhh1056}
 * Create by {2020/07/02}
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{1, 1, 3, 0, 1, 1}));
    }
}

class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        int temp = -1;
        for (int i : arr) {
            if (temp != i) {
                arrayList.add(i);
            }
            temp = i;
        }
        return arrayList.stream().mapToInt(i -> i).toArray();
    }
}
