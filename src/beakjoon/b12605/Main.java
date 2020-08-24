package beakjoon.b12605;

import java.util.Scanner;
import java.util.Stack;

/**
 * author {yhh1056}
 * Create by {2020/08/24}
 */
public class Main {
    public static void main(String[] args) {
        //입력 받기
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();
        Stack<String> stack = new Stack<>();

        for (int i = 1; i <= num; i++) {
            String[] inputStringToSpace = scanner.nextLine().split(" ");
            for (String inputString : inputStringToSpace) {
                stack.push(inputString);
            }
            System.out.print("Case #" + i + ": ");
            while (!stack.isEmpty()) {
                System.out.print(stack.pop() + " ");
            }
            System.out.println();
        }
    }
}
