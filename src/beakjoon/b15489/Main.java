package beakjoon.b15489;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * author {yhh1056}
 * Create by {2020/09/11}
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());           //r번째 줄
        int c = Integer.parseInt(st.nextToken());           //r번째 줄의 c번째 꼭지점
        int w = Integer.parseInt(st.nextToken());           //한변의 길이

//        System.out.println(getSolution(r, c, w));
        System.out.println(getSolution2(r, c, w));
    }


    /**
     * 파스칼 삼각형 원리를 이용하여 풀이
     */
    public static int getSolution2(int r, int c, int w) {
        int n = r - 1;
        int k = c - 1;
        int answer = 0;

        for (int i = 1; i <= w; i++) {
            int tmp = k;
            for (int j = 0; j < i; j++) {
                answer += binomialCoefficient(n, k);
                k++;
            }
            k = tmp;
            n++;
        }
        return answer;
    }

    public static int binomialCoefficient(int n, int k) {
        if (k == 0) {
            return 1;
        }

        return factorial(n) / (factorial(k) * factorial(n - k));
    }

    private static int factorial(int number) {
        int answer = number;
        for (int i = 1; i < answer; i++) {
            number *= i;
        }
        return number;
    }

    /**
     * dp에 저장시켜 문제를 푸는 방법
     */
    public static int getSolution(int r, int c, int w) {
        int[][] pascal = new int[31][31];
        pascal[1][0] = 1;
        int defaultNum = 1;
        for (int i = 2; i < 31; i++) {
            pascal[i][0] = defaultNum;
            for (int j = 1; j < i; j++) {
                /**
                 점화식
                 pascal[i][j]는  왼쪽 위의 숫자와 오른쪽위 숫자의 합과 같다
                 */
                pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];

                /** n C r => n == r  값은 1이다 */
                if (j == i - 1) {
                    pascal[i][j] = defaultNum;
                }
            }
        }

        /**
         * 삼각형안의 숫자를 더하는 로직
         * r = 꼭지점의 라인
         * c = 몇번째 꼭지점인지
         * w = 변의 길이
         * */
        int answer = 0;
        answer += pascal[r][c - 1];

        int startRow = r + 1;
        for (int i = 1; i < w; i++) {
            int startColumn = c - 1;
            for (int j = 0; j <= i; j++) {
                answer += pascal[startRow][startColumn];
                startColumn++;
            }
            startRow++;
        }
        return answer;
    }

}
