package beakjoon.b1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BFS DFS
 */

public class Main {
    static int[][] node; // 인접행렬 배열
    static int[] check; // 노드의 방문여부 표시 배열
    static Queue<Integer> queue = new LinkedList<>(); // BFS를 위한 큐

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 정점의 개수
        int m = Integer.parseInt(st.nextToken()); // 간선의 개수
        int v = Integer.parseInt(st.nextToken()); // 탐색 시작 노드

        node = new int[n + 1][n + 1];
        check = new int[n + 1];

        for (int i = 0; i < m; i++) { // 인접행렬로 그래프를 구현
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            node[a][b] = 1;
            node[b][a] = 1;
        }

        dfs(v);
        Arrays.fill(check, 0); // DFS이후 동일한 방문 여부배열을 사용하기 때문에 다시 0으로 초기화 해준다.
        System.out.println();
        bfs(v);
    }

    static void dfs(int v) { // DFS 메소드 재귀호출 반복한다.
        if (check[v] == 1) {
            return; //이미 방문한 노드라면 종료한다.
        }
        check[v] = 1; //방문하지 않은 노드라면 방문여부를 표시하고 출력한다.
        System.out.print(v + " ");

        for (int i = 1; i < node.length; i++) { // 인접행렬의 경우 행열이 대각선을 기준으로 대칭이 되므로 행 또는 열을 기준으로만 탐색하면된다.
            if (node[v][i] == 1) { // 방문하지 않은 노드의 인접 노드일 경우

                dfs(i); // 해당 노드로 이동
            }
        }
    }

    static void bfs(int x) { //BFS 메소드 큐를 이용해 구현
       queue.offer(x);
       check[x] = 1;
       while (!queue.isEmpty()) {
           x = queue.poll();
           System.out.print(x + " ");

           for (int i = 1; i < node.length; i++) {
               if (check[i] != 1 && node[x][i] == 1) {
                   queue.offer(i);
                   check[i] = 1;
               }
           }
       }
    }
}