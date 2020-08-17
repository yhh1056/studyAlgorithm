package beakjoon.b1158;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.close();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= length; i++) {
            queue.add(i);
        }

        System.out.print("<");
        int tmp;
        while (queue.size() > 1) {
            for (int i = 0; i < n - 1; i++) {
                queue.offer(queue.poll());
            }

            tmp = queue.poll();
            System.out.print(tmp + ", ");
        }
        System.out.print(queue.poll());
        System.out.println(">");
    }
}
