package programmers.p42583;

import java.util.LinkedList;
import java.util.Queue;

/**
 * author {yhh1056}
 * Create by {2020/08/11}
 * <p>
 * 다리를 지나나는 터널
 */
public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(2, 10, new int[]{7, 4, 5, 6});
        solution.solution(100, 100, new int[]{10});
    }
}

class Solution {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> bridge = new LinkedList<>();
        Queue<Integer> truck = new LinkedList<>();

        for (int truck_weight : truck_weights) {
            truck.offer(truck_weight);
        }

        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }

        while (!truck.isEmpty()) {
            answer++;
            bridge.poll();

            int total = getTotal(bridge) + truck.peek();

            if (weight >= total) {
                bridge.offer(truck.poll());
            } else {
                bridge.offer(0);
            }

        }

        return answer + bridge_length;

    }

    private int getTotal(Queue<Integer> bridge) {
        int total = 0;
        for (int b : bridge) {
            total += b;
        }
        return total;
    }

}

