package programmers.p42747;

import java.util.Arrays;

/**
 * author {yhh1056}
 * Create by {2020/08/12}
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[]{2, 2, 4, 4});
    }
}

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;

            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }
        return answer;
    }
}
