package programmers.p64061;

import java.util.ArrayList;
import java.util.Stack;

/**
 * author {yhh1056}
 * Create by {2020/07/23}
 */
public class Test {
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
}

class Solution {
    public int solution(int[][] board, int[] moves) {
        int length = board.length;
        ArrayList<Integer> lowList = new ArrayList<>();
        ArrayList<Integer> basket = new ArrayList<>();

        //세로로 한줄씩 리스트에 추가
        for (int i = 0; i < length; i++) {
            for (int[] ints : board) {
                lowList.add(ints[i]);
            }
        }

        //뽑으려는 칸에 맞춰서 범위에 맞게 조회
        for (int move : moves) {
            int startSearchRange = (length * move) - length;
            int range = move * length;

            for (int j = startSearchRange; j < range; j++) {
                //뽑히고 나면 0으로 변환
                if (lowList.get(j) != 0) {
                    basket.add(lowList.get(j));
                    lowList.set(j, 0);
                    break;
                }
            }
        }
        //중복검사를 위해 유효하지 않는 숫자로 범위를 늘림
        basket.add(0);

        int count = 0;

        int maxSearchRange = basket.size() / 2;                                 //최대 조회수
        for (int i = 0; i < maxSearchRange; i++) {
            for (int j = 1; j < basket.size(); j++) {
                if (basket.get(j) == basket.get(j - 1)) {
                    count += 2;
                    basket.remove(j);
                    basket.remove(j - 1);
                    break;
                }
            }
        }
        return count;
    }
}

class Solution2 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack();

        for (int move : moves) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][move - 1] != 0) {
                    if (stack.isEmpty()) {
                        stack.push(board[j][move - 1]);
                        board[j][move - 1] = 0;
                        break;
                    }
                    if (board[j][move - 1] == stack.peek()) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(board[j][move -1]);
                        board[j][move - 1] = 0;
                    }
                }
            }
        }
        return answer;
    }
}
