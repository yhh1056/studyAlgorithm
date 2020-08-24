package beakjoon.b17608;

import java.util.Scanner;
import java.util.Stack;

/**
 * author {yhh1056}
 * Create by {2020/08/24}
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int lookStick = 1;      //막대기는 최소 2개가 주어진다.
        Stack<Integer> sticks = new Stack<>();

        for (int i = 0; i < num; i++) {
            sticks.push(scanner.nextInt());
        }

        /**
         * @parm bigStick : 가장 큰 막대의 길이
         * stack으로 조회한다.
         * 자신보다 더 큰 막대를 만날경우 bigStick을 변경하고 lookStick 카운트를 올린다.
         * 조회를 하고나서 삭제한다.
         */
        int bigStickLength = sticks.pop();
        while (!sticks.isEmpty()) {
            int nextStick = sticks.peek();
            if (bigStickLength < nextStick) {
                bigStickLength = nextStick;
                lookStick++;
            }
            sticks.pop();
        }
        System.out.println(lookStick);
    }
}
