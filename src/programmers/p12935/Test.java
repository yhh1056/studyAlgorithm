package programmers.p12935;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * author {yhh1056}
 * Create by {2020/07/29}
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{4, 3, 2, 1}));
    }
}

class Solution {
    public int[] solution(int[] arr) {
        int[] exArray = {-1};
        if (arr.length == 1) {
            return exArray;
        }
        List<Integer> list = new ArrayList<>();

        for (int value : arr) {
            list.add(value);
        }

        int min = Collections.min(list);

        list.remove((Integer) min);
        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}