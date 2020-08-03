package programmers.p12940;

import java.util.ArrayList;
import java.util.List;

/**
 * author {yhh1056}
 * Create by {2020/08/03}
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(36, 12);

    }
}

class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];

        answer[0] = gcd(n, m);
        answer[1] = n * m / answer[0];
        System.out.println(answer[0]);
        System.out.println(answer[1]);
        return answer;
    }

    public int gcd(int a,int b){
        if(a % b == 0)
            return b;
        return gcd(b,a%b);
    }
}
