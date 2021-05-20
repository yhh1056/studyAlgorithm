package programmers.p43105;

import java.util.Arrays;

/**
 * 정수삼각형
 * Created by IntelliJ IDEA
 * User: yhh1056@naver.com
 * Date: 2021/05/18 Time: 8:39 오후
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}});
    }

    public int solution(int[][] triangle) {
        triangle[1][0] += triangle[0][0];
        triangle[1][1] += triangle[0][0];

        for (int i = 2; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) {
                    triangle[i][j] += triangle[i - 1][j];
                } else if (j == triangle[i].length - 1) {
                    triangle[i][j] += triangle[i - 1][j - 1];
                } else {
                    int leftTop = triangle[i][j] + triangle[i - 1][j];
                    int rightTop = triangle[i][j] + triangle[i - 1][j - 1];

                    triangle[i][j] = Math.max(leftTop, rightTop);
                }
            }
        }

        Arrays.sort(triangle[triangle.length - 1]);

        return triangle[triangle.length - 1][triangle.length - 1];
    }


}
