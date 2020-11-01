package beakjoon.b3584;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 가장 가까운 공통 조상
 * author {yhh1056}
 * Create by {2020/10/21}
 */
public class Main {
    private static boolean[] visited;
    private static ArrayList<Integer>[] tree;
    private static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for(int i = 0; i < testCase; i++) {
            int len = Integer.parseInt(br.readLine());

            visited = new boolean[len + 1];
            tree = new ArrayList[len + 1];

            for (int j = 0; j < len + 1; j++) {
                tree[j] = new ArrayList<>();
            }

            StringTokenizer st;

            for (int j = 1; j < len; j++) {
                st = new StringTokenizer(br.readLine());
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());

                tree[child].add(parent);
            }

            st = new StringTokenizer(br.readLine());
            int firstChild = Integer.parseInt(st.nextToken());
            int secondChild = Integer.parseInt(st.nextToken());

            visited[firstChild] = true;
            dfs(firstChild);
            dfs(secondChild);

            System.out.println(result);
        }
    }


    private static void dfs(int start) {
        if (tree[start] == null) {
            return;
        }

        for (int next : tree[start]) {
            if (!visited[next]) {
                visited[next] = true;

                dfs(next);
            } else {                // 두번째 탐색시, 첫번째 탐색때 방문했던 노드인 경우 -> 가장 가까운 공통 조상
                result = next;
                return;
            }
        }
    }
}

