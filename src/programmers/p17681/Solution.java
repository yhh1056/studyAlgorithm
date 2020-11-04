package programmers.p17681;

import java.util.Arrays;

/**
 * 비밀지도
 * author {yhh1056}
 * Create by {2020/11/04}
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28});
    }

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            String tmp1 = Integer.toBinaryString(arr1[i]);
            String tmp2 = Integer.toBinaryString(arr2[i]);

            StringBuilder map1 = new StringBuilder();
            StringBuilder map2 = new StringBuilder();

            if (tmp1.length() != n) {
                int dif = n - tmp1.length();
                map1.append("0".repeat(Math.max(0, dif)));
            }

            if (tmp2.length() != n) {
                int dif = n - tmp2.length();
                map2.append("0".repeat(Math.max(0, dif)));
            }

            map1.append(tmp1);
            map2.append(tmp2);

            StringBuilder line = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (map1.charAt(j) == '0' && map2.charAt(j) == '0') {
                    line.append(" ");
                } else {
                    line.append("#");
                }
            }
            answer[i] = line.toString();
        }

        return answer;
    }
}
