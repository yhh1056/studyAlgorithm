package programmers.p42839;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * author {yhh1056}
 * Create by {2020/09/16}
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution("101");

    }

    public int solution(String numbers) {
        List<String> arr = new ArrayList<>();
        String[] nums = numbers.split("");
        Collections.addAll(arr, nums);

        List<String> result = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length + 1; i++) {
            reculsion(arr, result, arr.size(), i, set);
        }

        return set.size();
    }

    private void reculsion(List<String> arr, List<String> result, int n, int r, HashSet<Integer> set) {
        if (r == 0) {
            StringBuilder strNum = new StringBuilder();
            for (String s : result) {
                strNum.append(s);
            }
            if (!strNum.toString().equals("")) {
                int num = Integer.parseInt(strNum.toString());
                if (isPrime(num)) {
                    set.add(num);
                }
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            result.add(arr.remove(i));
            reculsion(arr, result, n - 1, r - 1, set);
            arr.add(i, result.remove(result.size() - 1));
        }
    }
    private boolean isPrime(int n) {
        int sqrt = (int) Math.sqrt(n);

        if (n == 2) {
            return true;
        }

        if (n % 2 == 0 || n == 1) {
            return false;
        }

        for (int i = 3; i <= sqrt; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
