package kakao.test2021;

import java.util.*;

public class Solution2 {
    static boolean[] visit;
    static Map<String, Integer> map;
    static int bestOrderCount;
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};

        List<String> result = new ArrayList<>();
        for (int i = 0; i < course.length; i++) {
            int r = course[i];

            map = new HashMap<>();
            bestOrderCount = 0;
            for (int j = 0; j < orders.length; j++) {
                int n = orders[j].length();
                visit = new boolean[n];
                char[] order = orders[j].toCharArray();
                int start = 0;
                Arrays.sort(order);
                combination(order, start, n, r);
            }


            for (String key : map.keySet()) {
                if (map.get(key) == bestOrderCount && bestOrderCount != 1) {
                    result.add(key);
                }
            }

        }

        Collections.sort(result);

        return result.toArray(new String[result.size()]);
    }

    public void combination(char[] orders, int start, int n, int r) {
        if (r == 0) {
            String combiMenu = "";
            for (int i = 0; i < n; i++) {
                if (visit[i]) {
                    combiMenu += String.valueOf(orders[i]);
                }
            }
            if (map.containsKey(combiMenu)) {
                map.put(combiMenu, map.get(combiMenu) + 1);
            } else {
                map.put(combiMenu, 1);
            }

            bestOrderCount = Math.max(bestOrderCount, map.get(combiMenu));

            return;
        }

        for (int i = start; i < n; i++) {
            visit[i] = true;
            combination(orders, i + 1, n, r - 1);
            visit[i] = false;
        }

    }
}
