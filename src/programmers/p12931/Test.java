package programmers.p12931;

/**
 * author {yhh1056}
 * Create by {2020/07/27}
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(12345));

    }
}
class Solution {
    public int solution(int n) {
        int answer = 0;
        String s = String.valueOf(n);
        String[] arr = s.split("");
        for (String a : arr) {
            answer += Integer.parseInt(a);
        }
        return answer;
    }
}