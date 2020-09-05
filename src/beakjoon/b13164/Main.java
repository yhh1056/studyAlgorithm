package beakjoon.b13164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 행복유치원
 * author {yhh1056}
 * Create by {2020/09/05}
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int len = Integer.parseInt(st.nextToken());
        int group = Integer.parseInt(st.nextToken());

        //3개의 조가 필요하다면 기준이 되는 학생 2명이 필요함
        int tmp = group - 1;
        long[] student = new long[len];
        //학생들 인풋받기
        StringTokenizer secondLine = new StringTokenizer(br.readLine());
        for (int i = 0; i < len; i++) {
            student[i] = Long.parseLong(secondLine.nextToken());
        }
        //학생들의 기 차이가 담긴 배열 (스택에 넣어야 max값이 같아도 먼저 뺄 수 있다.)
        Stack<Long> subtractHeight = new Stack<>();
        for (int i = 1; i < len; i++) {
            subtractHeight.push(student[i] - student[i - 1]);
        }
        //가장 높은 값이 기준이기 때문에 정렬
        Collections.sort(subtractHeight);
        //tmp만큼 스택에서 제거
        for (int i = 0; i < tmp; i++) {
            subtractHeight.pop();
        }
        //스택에 있는 값을 모두 더한다.
        long result = 0;
        while (!subtractHeight.isEmpty()) {
            result += subtractHeight.pop();
        }
        System.out.println(result);
    }
}
