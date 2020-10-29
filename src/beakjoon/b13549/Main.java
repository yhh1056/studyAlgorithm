package beakjoon.b13549;

import java.io.*;
import java.util.*;

/**
 * 13549번 : 숨바꼭질3
 * author {yhh1056}
 * Create by {2020/10/28}
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int subin = Integer.parseInt(st.nextToken());
        int sister = Integer.parseInt(st.nextToken());
        int[] movePointers = new int[100001];
        Arrays.fill(movePointers, -1);

        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(subin);
        movePointers[subin] = 0;

        while (!deque.isEmpty()) {
            int now = deque.poll();

            if (now == sister) {
                break;
            }

            int teleport = now * 2;
            if (teleport <= 100000 && movePointers[teleport] == -1) {
                deque.addFirst(teleport);
                movePointers[teleport] = movePointers[now];
            }

            int front = now + 1;
            if (front <= 100000 && movePointers[front] == -1) {
                deque.offer(front);
                movePointers[front] = movePointers[now] + 1;
            }

            int back = now -1;
            if (back >= 0 && movePointers[back] == -1) {
                deque.offer(back);
                movePointers[back] = movePointers[now] + 1;
            }

        }

//        System.out.println(Arrays.toString(movePointers));
        System.out.println(movePointers[sister]);
    }
}
