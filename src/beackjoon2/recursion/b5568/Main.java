package beackjoon2.recursion.b5568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA
 * User: yhh1056@naver.com
 * Date: 2021/04/27 Time: 11:27 오전
 */
public class Main {

    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        int depth = 0;
        permutation(array, depth, n, k);

        System.out.println(set);
        System.out.println(set.size());
    }

    private static void permutation(int[] array, int depth, int n, int k) {
        if (depth == k) {
            set.add(arrayToString(array, k));
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(array, depth, i);
            permutation(array, depth + 1, n, k);
            swap(array, depth, i);
        }
    }

    private static void swap(int[] array, int depth, int i) {
        int tmp = array[depth];
        array[depth] = array[i];
        array[i] = tmp;
    }

    private static String arrayToString(int[] array, int range) {
        String tmp = "";
        for (int i = 0; i < range; i++) {
            tmp += array[i];
        }
        return tmp;
    }

}
