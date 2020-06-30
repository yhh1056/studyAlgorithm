package beakjoon.b3052;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by yhh1056 on 2020-0.6-12.
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputIntArr = new int[10];
        int beakJunGivenNumber = 42;
        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i = 0; i < 10; i++) {
            inputIntArr[i]= scanner.nextInt();

            int remainderNumber = inputIntArr[i] % beakJunGivenNumber;

            if(!arrayList.contains(remainderNumber)) {
                arrayList.add(remainderNumber);
            }
        }
        System.out.println(arrayList.size());

    }
}
