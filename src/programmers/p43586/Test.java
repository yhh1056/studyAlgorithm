package programmers.p43586;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * author {yhh1056}
 * Create by {2020/08/13}
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
    }
}

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();

        int day;
        int workTime;
        int count = 1;
        for (int i = 0; i < progresses.length; i++) {
            day = (100 - progresses[i]) % speeds[i];
            if (day == 0) {
                workTime = (100 - progresses[i]) / speeds[i];
            } else {
                workTime = ((100 - progresses[i]) / speeds[i]) + 1;
            }
            if (stack.isEmpty()) {
                queue.offer(workTime);
                stack.push(1);
            } else if (queue.peek() >= workTime) {
                count += 1;
                if (!stack.empty()) {
                    stack.pop();
                }
                stack.push(count);
            } else {
                queue.poll();
                queue.offer(workTime);
                stack.push(1);
                count = 1;
            }
        }
        int[] answer = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }

        return answer;
    }
}
