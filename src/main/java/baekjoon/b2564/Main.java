package baekjoon.b2564;

import archive.algorithm.archive.provider.baekjoon.Baekjoon;
import archive.algorithm.archive.provider.baekjoon.BaekjoonLevel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@Baekjoon(number = 2564, level = BaekjoonLevel.SILVER)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] load = new int[M * 2 + N * 2];
        int storeCount = Integer.parseInt(br.readLine());

        int point = 1;

        /**
         * 동서남북에 위치한 상점들을 load에 담아둔다.
         * point 변수는 상점들을 차례대로 탐색하기 위해 사용한다.
         */
        for (int i = 0; i < storeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int way = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            // 북
            if (way == 1) {
                load[distance] = point++;
            }

            // 남
            if (way == 2) {
                load[M + N + M - distance] = point++;
            }

            // 서
            if (way == 3) {
                load[M + N + M + N - distance] = point++;
            }

            // 동
            if (way == 4) {
                load[M + distance] = point++;
            }
        }

        st = new StringTokenizer(br.readLine());
        int way = Integer.parseInt(st.nextToken());
        int distance = Integer.parseInt(st.nextToken());

        /**
         * 마지막줄의 입력은 동근이의 위치정보가 나온다.
         * 동근이의 위치를 파악하여 현재 지점을 now 변수에 저장한다.
         */
        int now = setNow(M, N, way, distance);

        int answer = 0;

        /**
         * 이전에 저장해둔 point 지점대로 탐색한다.
         * 왼쪽으로 출발해보고, 오른쪽으로 출발하여 각 상점의 최단 거리를 구한다.
         */
        for (int i = 1; i < point; i++) {
            answer += Math.min(left(i, load, now), right(i, load, now));
        }
        System.out.println(answer);
    }

    private static int setNow(int M, int N, int way, int distance) {
        int now = 0;
        if (way == 1) {
            now = distance;
        }

        if (way == 2) {
            now = M + N + M - distance;
        }

        if (way == 3) {
            now = M + N + M + N - distance;
        }

        if (way == 4) {
            now = M + distance;
        }
        return now;
    }

    private static int left(int target, int[] load, int now) {
        int count = 0;
        while (load[now] != target) {
            now -= 1;
            if (now == -1) {
                now = load.length - 1;
            }
            count++;
        }
        return count;
    }

    private static int right(int target, int[] load, int now) {
        int count = 0;
        while (load[now] != target) {
            now += 1;
            if (now == load.length) {
                now = 0;
            }
            count++;
        }
        return count;
    }
}
