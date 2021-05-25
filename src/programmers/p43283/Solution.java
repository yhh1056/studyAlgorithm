package programmers.p43283;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA
 * User: yhh1056@naver.com
 * Date: 2021/05/25 Time: 3:44 오후
 * 입국 심사
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(6, new int[]{7, 10}));
    }

    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long start = 1;
        long end = ((long) times[times.length - 1]) * n;
        long answer = Long.MAX_VALUE;
        long mid;

        while (start <= end) {
            mid = (start + end) / 2;

            long total = 0;

            for (int i = 0; i < times.length; i++) {
                total += mid / times[i];
            }

            if (total >= n) {
                answer = Math.min(mid, answer);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return answer;
    }

}
