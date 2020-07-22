package programmers.p12928;


/**
 * author {yhh1056}
 * Create by {2020/07/22}
 */
public class Test {
    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.solution(12));
    }
}

class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n/2; i++) {
            if (n % i == 0) {
                answer += i;
            }
        }
        return answer + n;
    }
}
