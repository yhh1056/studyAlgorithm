package beakjoon.b1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 최단경로
 * 다익스트라
 *
 */
public class Main {

    static int[] dist;
    static List<Node>[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        dist = new int[N + 1];
        nodes = new ArrayList[N + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int nV = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            nodes[v].add(new Node(nV, w));
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));

        dist[start] = 0;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            int nextV = poll.nextV;
            int weight = poll.weight;

            if (dist[nextV] >= weight) {
                for (int i = 0; i < nodes[nextV].size(); i++) {
                    Node nextNode = nodes[nextV].get(i);

                    if (dist[nextNode.nextV] > nextNode.weight + weight) {
                        dist[nextNode.nextV] = nextNode.weight + weight;
                        queue.offer(new Node(nextNode.nextV, nextNode.weight + weight));
                    }
                }
            }

            if (dist[nextV] >= weight) {
                for (int i = 0; i < nodes[nextV].size(); i++) {
                    Node nextNode = nodes[nextV].get(i);

                    int v = nextNode.nextV;
                    int w = weight + nodes[nextV].get(i).weight;

                    if (dist[nextNode.nextV] > weight + nextNode.weight) {
                        dist[nextNode.nextV] = weight + nextNode.weight;
                        queue.offer(new Node(v, w));
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }
}

class Node implements Comparable<Node> {

    int nextV;
    int weight;

    public Node(int nextV, int weight) {
        this.nextV = nextV;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}