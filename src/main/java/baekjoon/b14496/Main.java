package baekjoon.b14496;

import archive.algorithm.archive.provider.baekjoon.Baekjoon;
import archive.algorithm.archive.provider.baekjoon.BaekjoonLevel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

@Baekjoon(number = 14496, level = BaekjoonLevel.SILVER)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N + 1][N + 1];
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[start][end] = 1;
            arr[end][start] = 1;
        }

        int answer = solution(a, b, N, arr);
        System.out.println(answer);
    }

    private static int solution(int start, int end, int n, int[][] arr) {
        int[] dist = new int[n + 1];
        boolean[] visit = new boolean[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[start] = 0;
        visit[start] = true;

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int now = node.start;
            int cost = node.cost;

            // 도착 지점이라면 탐색 중지 (최단 거리를 구하기 때문)
            if (now == end) {
                break;
            }

            for (int next = 1; next <= n; next++) {
                // 이동이 가능하고 방문한적이 없다면
                if (arr[now][next] == 1 && !visit[next]) {
                    dist[next] = cost + 1;
                    visit[next] = true;
                    queue.add(new Node(next, cost + 1));
                }
            }
        }
        return dist[end] == Integer.MAX_VALUE ? -1 : dist[end];
    }

}

class Node implements Comparable<Node> {
    int start;
    int cost;

    public Node(int start, int cost) {
        this.start = start;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node node) {
        return this.cost - node.cost;
    }
}
