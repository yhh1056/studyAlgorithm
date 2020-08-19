package beakjoon.b10845;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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
        Queue<Integer> queue = new LinkedList<>();

        int num = 0;
        for (int i = 0 ; i < inputNum; i++) {
            String input = scanner.next();
            switch (input) {
                case "push":
                    num = scanner.nextInt();
                    queue.offer(num);
                    break;
                case "pop":
                    System.out.println(pop(queue));
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "empty":
                    System.out.println(empty(queue));
                    break;
                case "front":
                    System.out.println(front(queue));
                    break;
                case "back":
                    System.out.println(back(queue, num));
                    break;
            }
        }
    }

    public static int back(Queue<Integer> queue, int num) {
        if (isEmpty(queue)) {
            return -1;
        }
        return num;
    }

    public static int front(Queue<Integer> queue) {
        if (isEmpty(queue)) {
            return -1;
        }
        return queue.peek();
    }

    public static int empty(Queue<Integer> queue) {
        if (isEmpty(queue)) {
            return 1;
        }
        return 0;
    }

    public static int pop(Queue<Integer> queue) {
        if (isEmpty(queue)) {
            return -1;
        }
        return queue.poll();
    }

    public static boolean isEmpty(Queue<Integer> queue) {
        return queue.isEmpty();
    }
}