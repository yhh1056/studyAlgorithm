package programmers.p64061;

import java.util.Stack;

/**
 * 크레인 인형뽑기
 * author {yhh1056}
 * Create by {2020/07/23}
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[][]{
                        {0, 0, 0, 0, 0},
                        {0, 0, 1, 0, 3},
                        {0, 2, 5, 0, 1},
                        {4, 2, 4, 4, 2},
                        {3, 5, 1, 3, 1}},
                new int[]
                        {1, 5, 3, 5, 1, 2, 1, 4});
    }
    public int solution(int[][] board, int[] moves) {
        int result = 0;

        Stack<Integer> stack = new Stack<>();

        for (int move : moves) {
            int pick = move - 1;

            for (int j = 0; j < board.length; j++) {
                int doll = board[j][pick];

                if (isExisted(doll)) {
                    board[j][pick] = 0;
                    if (stack.isEmpty() || stack.peek() != doll) {
                        stack.push(doll);
                    } else {
                        stack.pop();
                        result += 2;
                    }
                    break;
                }
            }

        }
        return result;
    }

    public boolean isExisted(int dol) {
        return dol != 0;
    }
}

