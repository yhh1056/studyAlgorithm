package programmers.p12934;


/**
 * author {yhh1056}
 * Create by {2020/07/29}
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(2L));
    }
}

class Solution {
    public long solution(long n) {
        double number = Math.sqrt(n);

        return Math.floor(number) == number ? (long) Math.pow(number + 1, 2) : -1;
    }
}
