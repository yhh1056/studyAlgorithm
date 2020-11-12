package beakjoon.b1865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 웜홀
 * author {yhh1056}
 * Create by {2020/11/12}
 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(st.nextToken());

        while (testcase-->0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            List<Edge> edgeList = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                //양쪽 걸리는 시간은 같음
                edgeList.add(new Edge(s, e, t));
                edgeList.add(new Edge(e, s, t));
            }

            //웜홀 구간 입력
            for (int i = 0; i < w; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                edgeList.add(new Edge(s, e, (-1) * t));
            }

            int[] nodes = new int[n+1];
            Arrays.fill(nodes, 100000000);

            nodes[1] = 0;
            boolean isNegativeCycle = false;

            for(int i = 1; i <= n; i++) {
                for(Edge edge : edgeList) {
                    if(nodes[edge.end] > nodes[edge.start] + edge.time) {
                        nodes[edge.end] = nodes[edge.start] + edge.time;

                        if (i == n) {
                            isNegativeCycle = true;
                            break;
                        }
                    }
                }
                if(isNegativeCycle) {
                    break;
                }
            }
            sb.append(isNegativeCycle ? "YES" : "NO").append("\n");
        }
        System.out.println(sb);
    }
}

class Edge {
    int start, end, time;

    Edge(int start, int end, int time) {
        this.start = start;
        this.end = end;
        this.time = time;
    }
}