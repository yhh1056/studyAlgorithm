package beakjoon.b1110;


import java.util.Scanner;

/**
 * Created by yhh1056 on 2020-05-29.
 */

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int inputNum = sc.nextInt();

        int resetNum = inputNum;
        int count = 0;

        while (true) {
            int solveNum = 0;
            int ten = resetNum / 10;
            int one = resetNum % 10;
            int addNum = ten + one;

            if (addNum >= 10) {
                addNum = addNum % 10;
            }

            solveNum = (one * 10) + addNum;

            resetNum = solveNum;
            count++;

            if(inputNum == solveNum) {
                break;
            }
        }
        System.out.println(count);
    }
}
