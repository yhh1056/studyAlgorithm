package beackjoon2.recursion.b9742;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA
 * User: yhh1056@naver.com
 * Date: 2021/04/27 Time: 10:19 오전
 */
public class Main {

    static Map<Integer, String> map = new HashMap<>();
    static int index;
    static int y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ((line=br.readLine())!= null) {
            String[] split = line.split(" ");
            String x = split[0];
            y = Integer.parseInt(split[1]);

            index = 0;
            char[] chars = x.toCharArray();
            boolean[] visited = new boolean[chars.length];
            char[] result = new char[chars.length];
            int depth = 0;

            permutation(chars, visited, result, depth);
            String value = map.get(y);

            if (value != null) {
                System.out.println(x + " " + y + " = " + value);
            } else {
                System.out.println(x + " " + y + " = " + "No permutation");
            }

            map.clear();

        }
    }

    private static void permutation(char[] chars, boolean[] visited, char[] result, int depth) {
        if (depth == chars.length) {
            index += 1;
            if (y == index) {
                map.put(index, String.valueOf(result));
                return;
            }
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                result[depth] = chars[i];
                permutation(chars, visited, result, depth + 1);
                visited[i] = false;
            }
        }
    }
}
