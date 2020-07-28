package programmers.p12933;

import java.util.Arrays;
import java.util.Collections;

/**
 * author {yhh1056}
 * Create by {2020/07/27}
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(118372));

    }
}

class Solution {
    public long solution(long n) {
        long answer;
        String s = "" + n;
        String[] arr = s.split("");
        Arrays.sort(arr, Collections.reverseOrder());
        StringBuilder string = new StringBuilder();

        for (String a : arr) {
            string.append(a);
        }

        answer = Long.parseLong(string.toString());
        
        return answer;
    }
}
