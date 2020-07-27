package programmers.p12932;

/**
 * author {yhh1056}
 * Create by {2020/07/27}
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(12345);
    }
}

class Solution {
    public int[] solution(long n) {
        StringBuilder reverse =  new StringBuilder(String.valueOf(n)).reverse();
        String s = String.valueOf(reverse);

        String[] arr = s.split("");
        int[] answer = new int[arr.length];

        for (int i = 0; i < reverse.length(); i++) {
            answer[i] = Integer.parseInt(arr[i]);
        }

        return answer;
    }
}
