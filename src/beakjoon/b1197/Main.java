package beakjoon.b1197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 최소 스패닝 트리
 * Created by yhh1056
 * Date: 2021/06/18 Time: 5:30 오후
 */

public class Main {

    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        PriorityQueue<Node> nodes = new PriorityQueue<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            Node node = new Node(v, next, cost);
            nodes.add(node);
        }

        int answer = 0;
        while (!nodes.isEmpty()) {
            Node poll = nodes.poll();
            int v = poll.v;
            int next = poll.next;
            int cost = poll.cost;

            if (find(v) != find(next)) {
                answer += cost;
                union(v, next);
            }
        }

        System.out.println(answer);


    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        int a = find(x);
        int b = find(y);

        if (a > b) {
            a = a + b;
            a = b - a;
            b = b - a;
        }

        parent[b] = a;
    }
}

class Node implements Comparable<Node> {
    int v;
    int next;
    int cost;

    public Node(int v, int next, int cost) {
        this.v = v;
        this.next = next;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}
