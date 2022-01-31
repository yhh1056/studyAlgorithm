package baekjoon.b6087;

import archive.algorithm.archive.provider.baekjoon.Baekjoon;
import archive.algorithm.archive.provider.baekjoon.BaekjoonLevel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

@Baekjoon(number = 6087, level = BaekjoonLevel.GOLD)
public class Main {
    static int W;
    static int H;
    static int[][] MAP;
    static Node START;
    static Node END;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        MAP = new int[H][W];
        int[][] dist = new int[H][W];

        boolean tag = false;
        for (int i = 0; i < H; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < split.length; j++) {
                String s = split[j];
                if (s.equals(".")) {
                    MAP[i][j] = 0;
                } else if (s.equals("*")) {
                    MAP[i][j] = -1;
                } else {
                    if (tag) {
                        END = new Node(i, j, 0);
                    } else {
                        START = new Node(i, j, 0);
                        tag = true;
                    }
                }
            }
        }
        dijkstra(dist);
        System.out.println(dist[END.start][END.end]);
    }

    private static void dijkstra(int[][] dist) {
        for (int[] ints : dist) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }

        Queue<Node> queue = new PriorityQueue<>();
        queue.add(START);
        dist[START.start][START.end] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int start = node.start;
            int end = node.end;
            int mirror = node.mirror;

            for (Way way : Way.values()) {
                int nextStart = start + way.ways[0];
                int nextEnd = end + way.ways[1];

                // 좌표를 벗어나거나 벽에 만나게 된다면 탐색할 필요 X
                if (nextStart >= H || nextStart < 0 || nextEnd >= W || nextEnd < 0 || MAP[nextStart][nextEnd] == -1) {
                    continue;
                }

                // 방향이 같다면 or 초기값이라 방향이 정해지지 않았다면
                if (node.way == null || node.way == way) {
                    // 현재 탐색하려는 경로가 거울이 더 적은 경우라면
                    if (dist[nextStart][nextEnd] >= mirror) {
                        dist[nextStart][nextEnd] = mirror;
                        queue.add(new Node(nextStart, nextEnd, mirror, way));
                    }
                // 방향이 다르다면 거울 설치
                } else {
                    // 현재 탐색하려는 경로가 거울이 더 적은 경우라면
                    if (dist[nextStart][nextEnd] >= mirror + 1) {
                        dist[nextStart][nextEnd] = mirror + 1;
                        queue.add(new Node(nextStart, nextEnd, mirror + 1, way));
                    }
                }
            }
        }
    }
}

class Node implements Comparable<Node> {
    int start;
    int end;
    int mirror;
    Way way;

    public Node(int start, int end, int mirror) {
        this.start = start;
        this.end = end;
        this.mirror = mirror;
    }

    public Node(int start, int end, int mirror, Way way) {
        this.start = start;
        this.end = end;
        this.mirror = mirror;
        this.way = way;
    }

    @Override
    public int compareTo(Node o) {
        return this.mirror - o.mirror;
    }
}

enum Way {
    UP(new int[] {-1, 0}),
    DOWN(new int[] {1, 0}),
    LEFT(new int[] {0, -1}),
    RIGHT(new int[] {0, 1});

    int[] ways;

    Way(int[] ways) {
        this.ways = ways;
    }
}
