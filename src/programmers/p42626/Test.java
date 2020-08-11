package programmers.p42626;


import java.util.PriorityQueue;
import java.util.Queue;

/**
 * author {yhh1056}
 * Create by {2020/08/11}
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[]{1, 2, 3, 9, 10, 12}, 7);
    }
}

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Integer> queue = new PriorityQueue();

        for (int s : scoville) {
            queue.offer(s);
        }
        while (queue.peek() < K) {
            if (queue.size() == 1) {
                return -1;
            }
            queue.offer(queue.poll() + queue.poll() * 2);
            answer++;
        }

        return answer;
    }
}
