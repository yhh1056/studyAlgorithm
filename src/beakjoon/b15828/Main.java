package beakjoon.b15828;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Router
 * author {yhh1056}
 * Create by {2020/08/20}
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> router = new LinkedList<>();

        int bufferSize = scanner.nextInt();
        int info;

        while (true) {      //-1 입력 받으면 종료
            info = scanner.nextInt();
            if (info == -1) {
                break;
            }
            if (info == 0) {
                router.poll();
            } else if (router.size() < bufferSize) {
                router.offer(info);
            }
        }
        if (router.isEmpty()) {
            System.out.println("empty");
        } else {
            int size = router.size();
            for (int i = 1; i <size; i++) {
                System.out.print(router.poll() + " ");
            }
            System.out.print(router.poll());
        }
    }
}
