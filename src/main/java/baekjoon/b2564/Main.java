package baekjoon.b2564;

import archive.provider.baekjoon.Baekjoon;
import archive.provider.baekjoon.BaekjoonLevel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@Baekjoon(name = "경비원", url = "https://www.acmicpc.net/problem/2564", level = BaekjoonLevel.SILVER, number = 2564)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] load = new int[M * 2 + N * 2];
        int size = Integer.parseInt(br.readLine());

        int count = 1;
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            int way = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            // 북
            if (way == 1) {
                load[distance] = count++;
            }

            // 남
            if (way == 2) {
                load[M + N + M - distance] = count++;
            }

            // 서
            if (way == 3) {
                load[M + N + M + N - distance] = count++;
            }

            // 동
            if (way == 4) {
                load[M + distance] = count++;
            }
        }

        int now = 0;
        st = new StringTokenizer(br.readLine());
        int way = Integer.parseInt(st.nextToken());
        int distance = Integer.parseInt(st.nextToken());

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

        int answer = 0;
        for (int i = 1; i < count; i++) {
            answer += Math.min(left(i, load, now), right(i, load, now));
        }
        System.out.println(answer);
    }

    private static int left(int target, int[] load, int now) {
        int count = 0;
        while (true) {
            if (load[now] == target) {
                break;
            } else {
                now -= 1;
                if (now == -1) {
                    now = load.length - 1;
                }
                count++;
            }
        }
        return count;
    }

    private static int right(int target, int[] load, int now) {
        int count = 0;
        while (true) {
            if (load[now] == target) {
                break;
            } else {
                now += 1;
                if (now == load.length) {
                    now = 0;
                }
                count++;
            }
        }
        return count;
    }
}
