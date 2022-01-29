package baekjoon.b1584;

import archive.algorithm.archive.provider.baekjoon.Baekjoon;
import archive.algorithm.archive.provider.baekjoon.BaekjoonLevel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

@Baekjoon(number = 1584, level = BaekjoonLevel.GOLD)
public class Main {
    static int WARNING_ZONE = 1;
    static int DEATH_ZONE = -1;
    static int[][] zone = new int[501][501];
    static boolean[][] visit = new boolean[501][501];

    public static void main(String[] args) throws IOException {
        // 위험한 구역 입력 받기
        setZone(WARNING_ZONE);

        // 죽음의 구역 입력받기
        setZone(DEATH_ZONE);

        int answer = bfs();

        // 방문한 적이 없으면 도착하지 못한 상태이므로 -1
        System.out.println(visit[500][500] ? answer : -1);
    }

    private static void setZone(int zone) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = Math.min(x1, x2); j <= Math.max(x1, x2); j++) {
                for (int k = Math.min(y1, y2); k <= Math.max(y1, y2); k++) {
                    Main.zone[j][k] = zone;
                }
            }
        }
    }

    private static int bfs() {
        int[] x = new int[] {0, 0, -1, 1};
        int[] y = new int[] {1, -1, 0, 0};

        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(0, 0, 0));
        visit[0][0] = true;
        zone[0][0] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int cost = node.cost;

            for (int i = 0; i < 4; i++) {
                int nextX = node.x + x[i];
                int nextY = node.y + y[i];

                // 이동 가능한 범위이고
                if (nextX >= 0 && nextX < 501 && nextY >= 0 && nextY < 501) {
                    // 방문한 적이 없고 죽음의 존이 아니라면
                    if (!visit[nextX][nextY] && zone[nextX][nextY] != DEATH_ZONE) {
                        visit[nextX][nextY] = true;
                        zone[nextX][nextY] += cost;
                        queue.add(new Node(nextX, nextY, zone[nextX][nextY]));
                    }
                }
            }
        }
        return zone[500][500];
    }
}

class Node implements Comparable<Node> {
    int x;
    int y;
    int cost;

    public Node(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}