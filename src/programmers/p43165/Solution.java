package programmers.p43165;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by IntelliJ IDEA
 * User: yhh1056@naver.com
 * Date: 2021/05/04 Time: 8:43 오후
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[]{1, 1, 1, 1, 1}, 3);
    }

    public int solution(int[] numbers, int target) {

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> sums = new ArrayList<>();
        queue.offer(0);

        for (int i = 0; i < numbers.length; i++) {
            while (!queue.isEmpty()) {
                int poll = queue.poll();
                sums.add(poll + numbers[i]);
                sums.add(poll - numbers[i]);
            }

            for (int sum : sums) {
                queue.add(sum);
            }

            sums.clear();
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            if (poll == target) {
                count++;
            }
        }

        return count;
    }
}
