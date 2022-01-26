package baekjoon.b1916;

import archive.algorithm.archive.provider.baekjoon.Baekjoon;
import archive.algorithm.archive.provider.baekjoon.BaekjoonLevel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

@Baekjoon(number = 1916, level = BaekjoonLevel.GOLD)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<List<Node>> graph = new ArrayList<>();

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] dist = dijkstra(N, graph, start);
        System.out.println(dist[end]);
    }

    private static int[] dijkstra(int N, List<List<Node>> graph, int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int next = node.next;
            int cost = node.cost;

            // 현재 저장되어있는 비용보다 계산할 비용이 더 높으면 탐색할 필요가 없다.
            if (dist[next] < cost) {
                continue;
            }

            // 이동 가능한 노드들을 탐색한다.
            for (int i = 0; i < graph.get(next).size(); i++) {
                Node nextNode = graph.get(next).get(i);

                // 저장되어 있는 비용보다 지금 이동된 비용이 더 낮다면 바꾸고 queue에 저장
                if (dist[nextNode.next] > nextNode.cost + cost) {
                    dist[nextNode.next] = nextNode.cost + cost;
                    queue.add(new Node(nextNode.next, nextNode.cost + cost));
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