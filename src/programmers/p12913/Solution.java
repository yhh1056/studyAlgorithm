package programmers.p12913;

import java.util.Arrays;

/**
 * 땅따먹기
 * author {yhh1056}
 * Create by {2020/09/23}
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[][]{{1,2,3,5},{5,6,7,8},{4,3,2,1}});
    }

    int solution(int[][] land) {
        int answer;

        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                int max = 0;
                for (int k = 0; k < 4; k++) {
                    if (j != k) {
                        int add = land[i][j] + land[i - 1][k];
                        if (max < add) {
                            max = add;
                        }
                    }
                }
                land[i][j] = max;
            }
        }

        Arrays.sort(land[land.length - 1]);
        answer = land[land.length - 1][3];
        return answer;
    }

}
