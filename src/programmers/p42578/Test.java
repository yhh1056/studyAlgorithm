package programmers.p42578;

import java.util.HashMap;

/**
 * author {yhh1056}
 * Create by {2020/08/12}
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new String[][]{{"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}});
    }
}

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        int answer = 1;
        for (String[] clothe : clothes) {
            if (hashMap.containsKey(clothe[1])) {
                hashMap.put(clothe[1], hashMap.get(clothe[1]) + 1);
            } else {
                hashMap.put(clothe[1], 1);
            }
        }
        for (String key : hashMap.keySet()) {
            answer *= (hashMap.get(key) + 1);
        }
        System.out.println(hashMap);
        System.out.println(answer - 1);
        return answer - 1;
    }
}
