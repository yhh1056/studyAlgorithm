package beakjoon.b18258m;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int inputNum = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        int num = 0;
        for (int i = 0 ; i < inputNum; i++) {
            String input = br.readLine();
            if (input.contains("push")) {
                String[] strings = input.split(" ");
                int pushNum = Integer.parseInt(strings[1]);
                System.out.println(pushNum);
                queue.offer(num);
            } else if ("pop".equals(input)) {
                sb.append(pop(queue));
            } else if ("size".equals(input)) {
                sb.append(queue.size());
            } else if ("empty".equals(input)) {
                sb.append(empty(queue));
            } else if ("front".equals(input)) {
                sb.append(front(queue));
            } else if ("back".equals(input)) {
                sb.append(back(queue, num));
            }
            sb.toString();
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