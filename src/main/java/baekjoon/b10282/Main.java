package baekjoon.b10282;

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

@Baekjoon(number = 10282, level = BaekjoonLevel.GOLD)
public class Main {
    static int n;
    static int d;
    static int c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testcase = 0; testcase < T; testcase++) {

            // 컴퓨터 개수 n, 의존성 개수 d, 해킹당한 컴퓨터의 번호 c
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            List<List<Node>> graph = new ArrayList<>();

            for (int i = 0; i < n + 1; i++) {
                graph.add(new ArrayList<>());
            }

            // 각 의존성을 나타내는 정수 a, b, s
            // 컴퓨터 a가 컴퓨터 b를 의존하며, 컴퓨터 b가 감염되면 s초 후 컴퓨터 a도 감염됨
            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                // 따라서 b에서 출발하여 도착하는 지점과 비용을 그래프에 담는다.
                graph.get(b).add(new Node(a, s));
            }

            int[] dist = dijkstra(graph);

            int virusCount = 0;
            int totalSeconds = 0;

            for (int i : dist) {
                if (i != Integer.MAX_VALUE) {
                    virusCount += 1;
                    totalSeconds = Math.max(totalSeconds, i);
                }
            }
            System.out.println(virusCount + " " + totalSeconds);

        }
    }

    private static int[] dijkstra(List<List<Node>> graph) {
        boolean[] computer = new boolean[n + 1];
        int[] dist = new int[n + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        computer[c] = true;
        dist[c] = 0;

        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(c, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int next = node.next;
            int second = node.second;

            for (int i = 0; i < graph.get(next).size(); i++) {
                Node nextNode = graph.get(next).get(i);

                if (dist[nextNode.next] > second + nextNode.second) {
                    dist[nextNode.next] = second + nextNode.second;
                    queue.add(new Node(nextNode.next, second + nextNode.second));
                }
            }
        }
        return dist;
    }
}

class Node implements Comparable<Node> {
    int next;
    int second;

    public Node(int next, int second) {
        this.next = next;
        this.second = second;
    }

    @Override
    public int compareTo(Node o) {
        return this.second - o.second;
    }
}
