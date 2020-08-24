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
    }
}

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        int countTime = 0;
        int max = 0;
        int virtualTruck = 0;

        for (int i = 0; i < truck_weights.length; i++) {
            max += truck_weights[i];
            if (max <= weight) {
                bridge.offer(truck_weights[i]);
            } else {
                bridge.offer(virtualTruck);
                max -= truck_weights[i];        //트럭 무게 다시 빼준다.
                i -= 1;
            }
            countTime++;
            if (bridge.size() == bridge_length) {
                max -= bridge.poll();
            }
        }
        return countTime + bridge_length;               //마지막 트럭이 지나가는 거리;
    }
}

