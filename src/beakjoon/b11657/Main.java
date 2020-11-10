package beakjoon.b11657;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 타임머신
 * author {yhh1056}
 * Create by {2020/11/10}
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");

        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);

        long[] dist = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            dist[i] = Long.MAX_VALUE;
        }

        ArrayList<Edge> arr = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String[] nums = br.readLine().split(" ");
            int s = Integer.parseInt(nums[0]);
            int e = Integer.parseInt(nums[1]);
            int w = Integer.parseInt(nums[2]);
            arr.add(new Edge(s, e, w));
        }

        dist[1] = 0;
        boolean isNegativeCycle = false;

        for (int i = 1; i <= n; i++) {
            for (Edge edge : arr) {
                if (dist[edge.s] == Long.MAX_VALUE) {
                    continue;
                }

                if (dist[edge.e] > dist[edge.s] + edge.w) {
                    dist[edge.e] = dist[edge.s] + edge.w;

                    if (i == n) {
                        isNegativeCycle = true;
                    }
                }
            }
        }

        if (isNegativeCycle) {
            System.out.println(-1);
        } else {
            for (int i = 2; i <= n; i++) {
                if (dist[i] == Long.MAX_VALUE) {
                    System.out.println(-1);
                } else {
                    System.out.println(dist[i]);
                }
            }
        }
    }
}

class Edge {
    int s, e, w;

    public Edge(int s, int e, int w) {
        super();
        this.s = s;
        this.e = e;
        this.w = w;
    }
}