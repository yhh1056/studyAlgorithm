package programmers.p12943;

/**
 * author {yhh1056}
 * Create by {2020/08/03}
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(13));
    }
}

class Solution {
    public int solution(int n) {
        long num = n;
        int count = 0;

        while(num != 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else num = num * 3 + 1;
            count++;
            if (count == 483) {
                return -1;
            }
        }
        return count;
    }
}
