package beakjoon.b2309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * author {yhh1056}
 * Create by {2020/09/14}
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nanJengE = new int[9];
        for (int i = 0; i < nanJengE.length; i++) {
            nanJengE[i] = Integer.parseInt(br.readLine());
        }
        int[] result = new int[7];

        while (true) {
            int[] index = getRandom();
            int sum = 0;
            for (int i = 0; i < index.length; i++) {
                sum += nanJengE[index[i]];
                result[i] = nanJengE[index[i]];
            }
            if (sum == 100) {
                break;
            }
        }

        Arrays.sort(result);
        for (int value : result) {
            System.out.println(value);
        }
    }

    public static int[] getRandom() {
        int[] index = new int[7];

        for(int insertCur = 0; insertCur < index.length ; insertCur++){

            index[insertCur] = (int)(Math.random() * 9);

            for(int searchCur = 0; searchCur < insertCur; searchCur ++){
                if(index[insertCur] == index[searchCur]){
                    insertCur--;
                    break;
                }
            }
        }
        return index;
    }

}
