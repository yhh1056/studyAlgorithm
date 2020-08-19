package dataStructure.queue;

import java.util.*;

/**
 * author {yhh1056}
 * Create by {2020/08/19}
 */
public class linkedQueue {

    public static void main(String[] args) {
        Queue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        priorityQueue.offer(4);
        priorityQueue.offer(2);
        priorityQueue.offer(1);
        priorityQueue.offer(5);

        int length = priorityQueue.size();
        for (int i = 0; i < length; i++) {
            System.out.print(priorityQueue.poll() + " ");
        }

        //출력 값 : 5 4 2 1
    }
}
