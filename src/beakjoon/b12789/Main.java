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

        Stack<Integer> oneLine = new Stack<>();     //한 명씩 설 수 있는 공간
        oneLine.push(0);                     //예외를 막기 위해 0을 넣음

        int count = 1;          //1번부터 순서대로 간식을 받을 수 있다.
        for (int i = 0; i < num; i++) {
            personNumber = Integer.parseInt(scanner.next());
            if (oneLine.peek() == count) {
                count = getCount(oneLine, count);
            }
            if (personNumber != count) {
                oneLine.push(personNumber);
            }
            if (personNumber == count) {
                count++;
            }
        }
        countOneLinePerson(oneLine, count);     //oneLine에 남아 있는 사람들 조회

        if (oneLine.peek() == 0) {
            System.out.println("Nice");
        }
    }

    public static void countOneLinePerson(Stack<Integer> oneLine, int count) {
        int length = oneLine.size();
        for (int i = 1; i < length; i++) {
            if (count == oneLine.peek()) {
                oneLine.pop();
                count++;
            } else {
                System.out.println("Sad");
                break;
            }
        }
    }

    public static int getCount(Stack<Integer> oneLine, int count) {
        int length = oneLine.size();
        for (int j = 0; j < length; j++) {
            if (oneLine.peek() == count) {
                oneLine.pop();
                count++;
            }
        }
        return count;
    }
}

