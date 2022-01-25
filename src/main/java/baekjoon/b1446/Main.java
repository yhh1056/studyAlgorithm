package baekjoon.b1446;

import archive.algorithm.archive.provider.baekjoon.Baekjoon;
import archive.algorithm.archive.provider.baekjoon.BaekjoonLevel;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

@Baekjoon(number = 1446, level = BaekjoonLevel.SILVER)
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> graph = new PriorityQueue<>();
        int[] distance = new int[D + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            if (end <= D) {
                graph.add(new Node(start, end, dist));
            }
        }
        System.out.println(solution(D, graph, distance));
    }

    private static int solution(int D, PriorityQueue<Node> graph, int[] distance) {
        int now = 0;      // 현재 지점
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;

        while (now < D) {
            int next = now + 1;

            if (!graph.isEmpty()) {    // 그래프를 꺼내올 수 있는 상태라면
                Node node = graph.peek();
                int start = node.start;
                int end = node.end;
                int dist = node.dist;

                if (start == now) {  // 현재 지점이 지름길을 탈 수 있는 상태라면
                    distance[end] = Math.min(distance[now] + dist, distance[end]);
                    graph.poll();
                } else {
                    distance[next] = Math.min(distance[next], distance[now] + 1);
                    now++;
                }

            } else {
                distance[next] = Math.min(distance[next], distance[now] + 1);
                now++;
            }
        }
        return distance[D];
    }
}

class Node implements Comparable<Node> {
    int start;
    int end;
    int dist;

    public Node(int start, int end, int dist) {
        this.start = start;
        this.end = end;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node o) {
        if (start == o.start) {
            return dist - o.dist;
        }
        return start - o.start;
    }
}
