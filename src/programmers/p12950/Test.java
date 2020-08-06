package programmers.p12950;

/**
 * author {yhh1056}
 * Create by {2020/08/03}
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[][]{{1, 2, 3}, {2,3}}, new int[][]{{3,4}, {5,6}});
    }
}

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int row = arr1.length;
        int column = arr1[0].length;

        int[][] answer = new int[row][column];

        for (int i = 0 ; i < row; i++) {
            for (int j = 0; j < column; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return answer;
    }
}
