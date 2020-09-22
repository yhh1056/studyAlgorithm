package beakjoon.b2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 단지 번호붙이기
 * author {yhh1056}
 * Create by {2020/09/22}
 */
public class Main {
    static int[][] townMap;
    static boolean[][] visited;
    static int[] x = new int[]{-1, 1, 0, 0};
    static int[] y = new int[]{0, 0, -1, 1};
    static int length;
    static int danzi = 0;
    static int dong = 0;

    public static void main(String[] args) throws IOException {
        ArrayList<Integer> arrayList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        length = Integer.parseInt(br.readLine());

        townMap = new int[length][length];
        visited = new boolean[length][length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                townMap[i][j] = br.read() - 48;
            }
            br.readLine();
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (townMap[i][j] == 1 && !visited[i][j]) {
                    dong = 1;
                    danzi++;
                    dfs(i, j);
                    arrayList.add(dong);
                }
            }
        }
        System.out.println(danzi);
        Collections.sort(arrayList);

        for (int answer : arrayList) {
            System.out.println(answer);
        }
    }

    private static void dfs(int i, int j) {
        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int moveX = i + x[k];
            int moveY = j + y[k];

            if (moveX >= 0 && moveX < length && moveY >= 0 && moveY < length) {
                if (townMap[moveX][moveY] == 1 && !visited[moveX][moveY]) {
                    dong++;
                    dfs(moveX, moveY);
                }
            }
        }
    }
}
