package programmers.p12954;

/**
 * author {yhh1056}
 * Create by {2020/08/06}
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(2, 5);
    }
}

class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];

        long num = x;
        for (int i = 0; i < n; i++) {
            answer[i] = num;
            num += x;
        }
        return answer;
    }
}