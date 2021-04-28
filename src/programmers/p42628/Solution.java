package programmers.p42628;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 이중우선순위큐
 * Created by IntelliJ IDEA
 * User: yhh1056@naver.com
 * Date: 2021/04/27 Time: 8:57 오후
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"});
    }

    public int[] solution(String[] operations) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue();
        for (String operation : operations) {
            String[] split = operation.split(" ");
            String command = split[0];

            if (command.equals("D")) {
                if (split[1].equals("1") && !priorityQueue.isEmpty()) {
                    priorityQueue.remove(Collections.max(priorityQueue));
                } else {
                    priorityQueue.poll();
                }
            } else {
                priorityQueue.offer(Integer.valueOf(split[1]));
            }
        }

        System.out.println(priorityQueue);
        if (priorityQueue.size() == 0) {
            return new int[]{0, 0};
        } else {
            return new int[]{Collections.max(priorityQueue), priorityQueue.poll()};
        }
    }
}
