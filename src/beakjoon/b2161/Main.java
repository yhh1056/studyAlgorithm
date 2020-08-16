package beakjoon.b2161;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * author {yhh1056}
 * Create by {2020/08/16}
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= length; i++) {
            queue.offer(i);
        }
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
            if (queue.isEmpty()) {
                break;
            }
            queue.offer(queue.poll());
        }
    }
}
