package beakjoon.b2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by yhh1056
 * Date: 2021/06/18 Time: 8:01 오후
 */
public class Main {

    static boolean[] visit;
    static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        visit = new boolean[N + 1];
        map = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = true;
            map[y][x] = true;
        }

        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        visit[1] = true;

        int answer = 0;
        while (!queue.isEmpty()) {
            int poll = queue.poll();

            boolean[] booleans = map[poll];

            for (int i = 1; i < booleans.length; i++) {
                if (!visit[i] && map[poll][i]) {
                    visit[i] = true;
                    queue.offer(i);
                    answer++;
                }
            }
        }

        System.out.println(answer);

    }

}
