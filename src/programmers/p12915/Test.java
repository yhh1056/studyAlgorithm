package programmers.p12915;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeMap;

/**
 * author {yhh1056}
 * Create by {2020/07/18}
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new String[]{"aa", "ds", "adsjklv", "asdjov", "cdas", "vbjopsd", "asdljasld", "dnds", "av"}, 1);
    }
}

class FailSolution {
    public String[] solution(String[] strings, int n) {
        //Key는 n에 해당하는 알파벳을 정렬한 다음 value 출력
        TreeMap<String, String> treeMap = new TreeMap<>();
        Arrays.sort(strings);
        //키는 중복될 수 없으므로 i를 추가해서 중복으로 없어지는 경우를 차단한다.
        for (int i = 0; i < strings.length; i++) {
            treeMap.put(String.valueOf(strings[i].charAt(n)) + i, strings[i]);
        }
        int size = 0;
        //키를 정렬한다.
        Arrays.sort(new Set[]{treeMap.keySet()});

        for (String key : treeMap.keySet()) {
            strings[size++] = treeMap.get(key);
        }
        System.out.println(Arrays.toString(strings));
        return strings;
    }
}

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.charAt(n) == o2.charAt(n)) {
                    return o1.compareTo(o2);
                } else {
                    return o1.charAt(n) - o2.charAt(n);
                }
            }
        });
        System.out.println(Arrays.toString(strings));
        return strings;
    }
}


