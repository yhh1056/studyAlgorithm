package programmers.p42746;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 가장 큰 수
 * author {yhh1056}
 * Create by {2020/08/20}
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{0, 0, 0, 0}));
    }
}

class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        String[] strings = new String[numbers.length];

        for (int i = 0; i < strings.length; i++) {
            strings[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strings, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        if (strings[0].startsWith("0")) {
            answer.append("0");
        } else {
            for (String string : strings) {
                answer.append(string);
            }
        }
        return answer.toString();
    }
}
