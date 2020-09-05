package programmers.p12899;

/**
 * 124나라의 숫자
 *
 * author {yhh1056}
 * Create by {2020/09/05}
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(10);
    }

    public String solution(int n) {
        String[] num = {"4","1","2"};
        StringBuilder answer = new StringBuilder();

        while(n > 0){
            answer.insert(0, num[n % 3]);
            n = (n - 1) / 3;
        }
        return answer.toString();
    }
}


