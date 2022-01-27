package baekjoon.b2174;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int E;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        long v1v2Cost = 0;
        v1v2Cost += dijkstra(graph, 1, v1);
        v1v2Cost += dijkstra(graph, v1, v2);
        v1v2Cost += dijkstra(graph, v2, N);

        long v2v1Cost = 0;
        v2v1Cost += dijkstra(graph, 1, v2);
        v2v1Cost += dijkstra(graph, v2, v1);
        v2v1Cost += dijkstra(graph, v1, N);

        if (v1v2Cost >= Integer.MAX_VALUE && v2v1Cost >= Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(Math.min(v1v2Cost, v2v1Cost));

    }

    private static int dijkstra(List<List<Node>> graph, int start, int end) {
        int[] dist = new int[N + 1];
        boolean[] visit = new boolean[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int next = node.next;
            int cost = node.cost;

            if (visit[next]) {
                continue;
            }

            visit[next] = true;

            for (int i = 0; i < graph.get(next).size(); i++) {
                Node nextNode = graph.get(next).get(i);
                if (dist[nextNode.next] > nextNode.cost + cost && !visit[nextNode.next]) {
                    dist[nextNode.next] = nextNode.cost + cost;
                    queue.add(new Node(nextNode.next, nextNode.cost + cost));
                }
            }
        }
        return dist[end];
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