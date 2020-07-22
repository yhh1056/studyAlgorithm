package programmers.p12921;

/**
 * author {yhh1056}
 * Create by {2020/07/11}
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(100));

    }
}

class Solution {
    public int solution(int n) {
        int[] arr  = new int[n + 1];
        arr[0] = 1;     //0은 소수가 아님
        arr[1] = 1;     //1은 소수가 아님
        int answer = 0;

        for (int i = 2; i < arr.length; i++) {
            for (int j = 2; i * j < arr.length; j++) {
                arr[i * j] = 1;
            }
        }
        for (int a : arr) {
            if (a == 0) {
                answer++;
            }
        }
        return answer;
    }
}