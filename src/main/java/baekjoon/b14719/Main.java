package baekjoon.b14719;

import archive.algorithm.archive.provider.baekjoon.Baekjoon;
import archive.algorithm.archive.provider.baekjoon.BaekjoonLevel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@Baekjoon(number = 14719, level = BaekjoonLevel.GOLD)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        boolean[][] visit = new boolean[h][w];

        /**
         * 2차원 배열 생성하기 (180도 회전된 상태로 배열을 채워도 상관없다.)
         * 1번 예제는 다음과 같은 배열로 생성된다.
         * [true, false, true, true]
         * [true, false, false, true]
         * [true, false, false, true]
         * [false, false, false, true]
         */
        for (int i = 0; i < w; i++) {
            int depth = Integer.parseInt(st.nextToken());
            full(i, visit, depth);
        }

        System.out.println(solution(visit));
    }

    private static int solution(boolean[][] visit) {
        int result = 0;
        for (int i = 0; i < visit.length; i++) {
            for (int j = 0; j < visit[i].length; j++) {
                result += find(visit, i, j);
            }
        }
        return result;
    }

    private static void full(int index, boolean[][] visit, int depth) {
        int temp = 0;
        for (int i = 0; i < depth; i++) {
            visit[temp][index] = true;
            temp++;
        }
    }

    private static int find(boolean[][] visit, int x, int y) {
        if (visit[x][y]) {
            return 0;
        }

        if (isExistRight(visit, x, y) && isExistLeft(visit, x, y)) {
            visit[x][y] = true;
            return 1;
        }

        return 0;
    }

    private static boolean isExistRight(boolean[][] visit, int x, int y) {
        for (int i = y; i < visit[0].length; i++) {
            if (visit[x][i]) {
                return true;
            }
        }
        return false;
    }

    private static boolean isExistLeft(boolean[][] visit, int x, int y) {
        for (int i = y; i >= 0; i--) {
            if (visit[x][i]) {
                return true;
            }
        }
        return false;
    }
}
