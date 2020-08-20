package beakjoon.b12789;

import java.util.Scanner;
import java.util.Stack;

/**
 * author {yhh1056}
 * Create by {2020/08/20}
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        int personNumber;
        int length;
        Stack<Integer> oneLine = new Stack<>();     //한 명씩 설 수 있는 공간
        oneLine.push(0);

        int count = 1;          //1번부터 순서대로 간식을 받을 수 있다.
        for (int i = 0; i < num; i++) {
            personNumber = Integer.parseInt(scanner.next());
            if (oneLine.peek() == count) {
                length = oneLine.size();
                for (int j = 0; j < length; j++) {
                    if (oneLine.peek() == count) {
                        oneLine.pop();
                        count++;
                    }
                }
            }
            if (personNumber != count) {
                oneLine.push(personNumber);
            }
            if (personNumber == count) {
                count++;
            }
        }
        length = oneLine.size();
        for (int i = 1; i < length; i++) {
            if (count == oneLine.peek()) {
                oneLine.pop();
                count++;
            } else {
                System.out.println("Sad");
                break;
            }
        }
        if (oneLine.peek() == 0) {
            System.out.println("Nice");
        }
    }
}

