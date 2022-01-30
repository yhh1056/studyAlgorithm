package baekjoon.b5972;

import archive.algorithm.archive.provider.baekjoon.Baekjoon;
import archive.algorithm.archive.provider.baekjoon.BaekjoonLevel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

@Baekjoon(number = 5972, level = BaekjoonLevel.GOLD)
public class Main {
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A_i = Integer.parseInt(st.nextToken());
            int B_i = Integer.parseInt(st.nextToken());
            int C_i = Integer.parseInt(st.nextToken());
            graph.get(A_i).add(new Node(B_i, C_i));
            graph.get(B_i).add(new Node(A_i, C_i));
        }

        int[] dist = dijkstra(graph);
        System.out.println(dist[N]);
    }

    private static int[] dijkstra(List<List<Node>> graph) {
        boolean[] visit = new boolean[N + 1];
        int[] dist = new int[N + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        // 시작 지점 세팅
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(1, 0));
        dist[1] = 0;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int next = now.next;
            int cost = now.cost;

            // 한 번 방문한 적이 있다면 이미 최소 경로로 이동했음
            if (visit[now.next]) {
                continue;
            }

            visit[next] = true;

            for (int i = 0; i < graph.get(next).size(); i++) {
                Node nextNode = graph.get(next).get(i);
                int sumCost = cost + nextNode.cost;

                // 기존 비용보다 지금 움직일 비용이 더 작다면
                if (dist[nextNode.next] > sumCost) {
                    dist[nextNode.next] = sumCost;
                    queue.add(new Node(nextNode.next, sumCost));
                }
            }
        }
        return dist;
    }
}

class Node implements Comparable<Node> {
    int next;
    int cost;

    public Node(int next, int cost) {
        this.next = next;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}
