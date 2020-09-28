package programmers.p12905;

/**
 * 가장 큰 정사각형 찾기
 * author {yhh1056}
 * Create by {2020/09/05}
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[][]{{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}});

    }


    public int solution(int[][] board) {
        int[][] boards = new int[board.length + 1][board[0].length + 1];

        for (int i = 1; i < boards.length; i++) {
            for (int j = 1; j < boards[i].length; j++) {
                boards[i][j] = board[i - 1][j - 1];
            }
        }

        int max = 0;
        for (int i = 1; i < boards.length; i++) {
            for (int j = 1; j < boards[i].length; j++) {
                if (boards[i][j] == 1) {
                    int min = Math.min(boards[i - 1][j], Math.min(boards[i][j - 1], boards[i - 1][j - 1]));
                    boards[i][j] = min + 1;
                    if (min + 1 > max) {
                        max = min + 1;
                    }
                }
            }
        }
        return max * max;
    }

}

