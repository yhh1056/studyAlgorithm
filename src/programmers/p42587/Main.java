package programmers.p42587;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by yhh1056
 * Date: 2021/06/30 Time: 4:21 오후
 */

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.solution(new int[]{1,1,1,1,1}, 3);
    }
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Print> queue = new LinkedList<>();
        PriorityQueue<Print> pQueue = new PriorityQueue<>();
        List<Print> result = new ArrayList<>();

        for (int index = 0; index < priorities.length; index++) {
            Print print = new Print(index, priorities[index]);

            queue.add(print);
            pQueue.add(print);
        }

        while (!pQueue.isEmpty()) {
            Print p1 = queue.peek();
            Print p2 = pQueue.peek();

            if (p1.point == p2.point) {
                result.add(pQueue.poll());
                queue.poll();
            } else {
                queue.offer(queue.poll());
            }
        }

        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).index == location) {
                answer = i;
                System.out.print(i);
                break;
            }
        }
        return answer + 1;
    }
}

class Print implements Comparable<Print> {
    int index;
    int point;

    public Print(int index, int point) {
        this.index = index;
        this.point = point;
    }

    @Override
    public int compareTo(Print p) {
        if (p.point == this.point) {
            return this.index - p.point;
        }
        return p.point - this.point;
    }

}