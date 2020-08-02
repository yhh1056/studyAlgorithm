package programmers.p12944;

/**
 * author {yhh1056}
 * Create by {2020/08/03}
 */
public class Test {
}

class Solution {
    public double solution(int[] arr) {
        double answer = 0;

        for (int a : arr) {
            answer += a;
        }
        answer /= arr.length;

        return answer;
    }
}
