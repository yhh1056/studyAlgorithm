package programmers.p12917;

import java.util.Arrays;

/**
 * 문자열 내림차순 정렬하기
 * author {yhh1056}
 * Create by {2020/07/03}
 */

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("Zbcdefg"));
    }

    public String solution(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        return reverseString(String.valueOf(chars));
    }

    public static String reverseString(String s) {
        return (new StringBuffer(s)).reverse().toString();
    }
}