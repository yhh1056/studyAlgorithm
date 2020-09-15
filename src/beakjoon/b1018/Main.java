package beakjoon.b1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 체스판 다시 칠하기
 * author {yhh1056}
 * Create by {2020/09/15}
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int column = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());

        String[][] answer = new String[column][row];
        for (int i = 0; i < column; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < row; j++) {
                answer[i][j] = input[j];
            }
        }

        // 8 * 8 크기의 2차원 배열을 주어지는 배열에 완탐 실행
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < column - 7; i++) {
            for (int j = 0; j < row - 7; j++) {
                int count = getCount(i, j, answer);
                set.add(count);
                set.add(64 - count);
            }
        }

        System.out.println(Collections.min(set));

    }

    private static int getCount(int startColumn, int startRow, String[][] answer) {
        String[][] chess = new String[][]{
                {"B", "W", "B", "W", "B", "W", "B", "W"},
                {"W", "B", "W", "B", "W", "B", "W", "B"},
                {"B", "W", "B", "W", "B", "W", "B", "W"},
                {"W", "B", "W", "B", "W", "B", "W", "B"},
                {"B", "W", "B", "W", "B", "W", "B", "W"},
                {"W", "B", "W", "B", "W", "B", "W", "B"},
                {"B", "W", "B", "W", "B", "W", "B", "W"},
                {"W", "B", "W", "B", "W", "B", "W", "B"}
        };

        int count = 0;
        int chessColumnIndex = 0;
        for (int i = startColumn; i < startColumn + 8; i++) {
            int chessRowIndex = 0;
            for (int j = startRow; j < startRow + 8; j++) {
                if (chess[chessColumnIndex][chessRowIndex].equals(answer[i][j])) {
                    count += 1;
                }
                chessRowIndex++;
            }
            chessColumnIndex++;
        }

        return count;
    }
}
