package beakjoon.b1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 숨바꼭질
 * author {yhh1056}
 * Create by {2020/09/21}
 */
public class Main {
    static int[] visited = new int[100001];
    static int max = 100001;
    static int min = -1;
    static Queue<Integer> bfs = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int subin = Integer.parseInt(st.nextToken());
        int sister = Integer.parseInt(st.nextToken());
        if (subin == sister) {
            System.out.println(0);
        } else {
            bfs(subin, sister);
        }
    }

    private static void bfs(int subin, int sister) {
        bfs.offer(subin);
        visited[subin] = 0;

        while (!bfs.isEmpty()) {
            int now = bfs.poll();

            if (isMeetSubinAndSister(sister, now)) {
                break;
            }

            int moveToBack = now - 1;
            int moveToFront = now + 1;
            int moveToTeleport = now * 2;

            if (moveToBack > min) {
                move(now, moveToBack);
            }
            if (moveToFront < max) {
                move(now, moveToFront);
            }
            if (moveToTeleport < max) {
                move(now, moveToTeleport);
            }
        }

        System.out.println(visited[sister]);
    }

    private static boolean isMeetSubinAndSister(int sister, int now) {
        return now == sister;
    }

    private static void move(int now, int pointToMove) {
        if (visited[pointToMove] == 0) {
            bfs.offer(pointToMove);
            visited[pointToMove] = visited[now] + 1;
        }
    }
}
