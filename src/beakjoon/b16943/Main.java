package beakjoon.b16943;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Created by yhh1056
 * Date: 2021/06/08 Time: 12:15 오후
 *
 * 순열로 숫자를 만든 뒤 정렬해서 기준보다 작은 가장 큰 수를 만든다.
 * 시간복잡도 O(n!) 범위가 10^9이고 시간 제한도 2초이기 떄문에 팩토리얼도 충분
 * 소요시간 35분
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        int a = Integer.parseInt(A);
        int b = Integer.parseInt(B);


        if (a == b) {
            System.out.println(a);
            return;
        }

        Set<Integer> set = new HashSet<>();

        String[] split = A.split("");

        int min = 1;
        for (int i = 0; i < split.length - 1; i++) {
            min *= 10;
        }

        boolean[] visit = new boolean[split.length];
        recursion(split, "", set, visit, min);

        int[] array = set.stream().mapToInt(integer -> integer).toArray();

        Arrays.sort(array);
        int answer = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > b) {
                break;
            }
            answer = array[i];
        }
        System.out.println(answer);
    }

    private static void recursion(String[] split, String result, Set<Integer> list, boolean[] visit, int min) {
        if (result.length() == split.length) {
            int madeNumber = Integer.parseInt(result);

            if (min <= madeNumber) {
                list.add(madeNumber);
            }
            return;
        }

        for (int i = 0; i < split.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                recursion(split, result + split[i], list, visit, min);
                visit[i] = false;
            }
        }
    }

}
