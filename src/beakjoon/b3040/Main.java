package beakjoon.b3040;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백설공주와 일곱난쟁이
 * author {yhh1056}
 * Create by {2020/09/15}
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int dwarfSum = 0;
        int[] dwarf = new int[9];
        for (int i = 0; i < 9; i++) {
            dwarf[i] = Integer.parseInt(br.readLine());
            dwarfSum += dwarf[i];
        }
        int liarDwarfSum = dwarfSum - 100;

        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (dwarf[i] + dwarf[j] == liarDwarfSum) {
                    for (int k = 0; k < 9; k++) {
                        if (k != i && k != j) {
                            System.out.println(dwarf[k]);
                        }
                    }
                }
            }
        }
    }
}
