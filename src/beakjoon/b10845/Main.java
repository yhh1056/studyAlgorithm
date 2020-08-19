package beakjoon.b10845;

import java.util.Scanner;
import java.util.concurrent.LinkedBlockingDeque;

/**
 문제 : 큐
 정수를 저장하는 큐를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

 명령은 총 여섯 가지이다.

 push X: 정수 X를 큐에 넣는 연산이다.
 pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 size: 큐에 들어있는 정수의 개수를 출력한다.
 empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
 front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.

 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNum = scanner.nextInt();
        scanner.nextLine();
        LinkedBlockingDeque<Integer> queue = new LinkedBlockingDeque<>();

        for (int i = 0 ; i < inputNum; i++) {
            String input = scanner.nextLine();
            if (input.contains("push")) {
                enqueue(queue, input);
            }
            if (input.equals("pop")) {
                System.out.println(dequeue(queue));
            }
            if (input.equals("size")) {
                System.out.println(queue.size());
            }
            if (input.equals("empty")) {
                System.out.println(isEmpty(queue));
            }
            if (input.equals("front")) {
                if (queue.isEmpty()) {
                    System.out.println(-1);
                }
                System.out.println(queue.getFirst());
            }
            if (input.equals("back")) {
                if (queue.isEmpty()) {
                    System.out.println(-1);
                }
                System.out.println(queue.getLast());
            }
        }
    }

    private static int isEmpty(LinkedBlockingDeque<Integer> queue) {
        if (queue.isEmpty()) {
            return 1;
        }
        return 0;
    }

    public static int dequeue(LinkedBlockingDeque<Integer>queue) {
        if (queue.size() == 0) {
            return -1;
        }
        return queue.poll();
    }

    public static void enqueue(LinkedBlockingDeque<Integer> queue, String input) {
        int num;
        String[] strings = input.split(" ");
        num = Integer.parseInt(strings[1]);
        queue.offer(num);
    }
}