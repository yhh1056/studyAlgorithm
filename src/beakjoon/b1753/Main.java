package beakjoon.b1753;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.Integer.MAX_VALUE;

/**
 * 최단경로
 * author {yhh1056}
 * Create by {2020/10/30}
 */
public class Main {
    static int INF = MAX_VALUE;
    static ArrayList<Node>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int vertex = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());

        list = new ArrayList[vertex + 1];
        int[] result = new int[vertex + 1];

        for (int i = 1; i <= vertex; i++) {
            list[i] = new ArrayList<>();
        }

        Arrays.fill(result, INF);

        int start = Integer.parseInt(br.readLine());
        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Node(v, w));
        }
        result[start] = 0;

        PriorityQueue<Node> pQueue = new PriorityQueue<>();
        pQueue.add(new Node(start, 0));

        while (!pQueue.isEmpty()) {
            Node node = pQueue.poll();

            if (result[node.v] >= node.w) {
                for (int i = 0; i < list[node.v].size(); i++) {
                    int tmpIndex = list[node.v].get(i).v;
                    int tmpDist = node.w + list[node.v].get(i).w;

                    if (result[tmpIndex] > tmpDist) {
                        result[tmpIndex] = tmpDist;
                        pQueue.add(new Node(tmpIndex, tmpDist));
                    }
                }
            }
        }

        for (int i = 1; i <= vertex; i++) {
            if (result[i] == MAX_VALUE)
                System.out.println("INF");
            else {
                System.out.println(result[i]);
            }
        }
    }


    public static class Node implements Comparable<Node> {
        int v;
        int w;

        public Node(int v, int val) {
            this.v = v;
            this.w = val;
        }

        @Override
        public int compareTo(Node o) {
            if (this.w > o.w)
                return 1;
            return 0;
        }

    }
}
