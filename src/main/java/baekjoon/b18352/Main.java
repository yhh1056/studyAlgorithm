package baekjoon.b18352;

import archive.algorithm.archive.provider.baekjoon.Baekjoon;
import archive.algorithm.archive.provider.baekjoon.BaekjoonLevel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

@Baekjoon(number = 18352, level = BaekjoonLevel.SILVER)
public class Main {
    static int N;
    static int M;
    static int K;
    static int X;
    static int[] dist;
    static List<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        dist = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, 1));
        }

        dist[X] = 0;
        PriorityQueue<Node> queue = new PriorityQueue();
        queue.add(new Node(X, 0));

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int v = now.v;
            int cost = now.cost;

            if (dist[v] >= cost) {
                for (int i = 0; i < graph[v].size(); i++) {
                    int nextV = graph[v].get(i).v;
                    int nextCode = graph[v].get(i).cost + cost;
                    if (dist[nextV] > nextCode) {
                        dist[nextV] = nextCode;
                        queue.add(new Node(nextV, nextCode));
                    }
                }
            }
        }

        boolean none = false;
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == K) {
                System.out.println(i);
                none = true;
            }
        }
        if (!none) {
            System.out.println(-1);

        }
    }

}

class Node implements Comparable<Node> {
    int v;
    int cost;

    public Node(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return cost - o.cost;
    }
}