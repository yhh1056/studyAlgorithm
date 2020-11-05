package programmers.p60057;

/**
 * 문자열 압축
 * author {yhh1056}
 * Create by {2020/11/03}
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.solution("abcabcdede");
    }

    public int solution(String s) {
        int answer = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            int result = compress(s, i);
            answer = Math.min(answer, result);
        }
        return answer;

    }

    private int compress(String s, int unit) {
        StringBuilder sb = new StringBuilder();
        String tmp = s.substring(0, unit);

        int index = unit;
        int count = 1;

        while (true) {
            if (index + unit > s.length()) {
                if (count == 1) {
                    sb.append(tmp);
                } else {
                    sb.append(count + tmp);
                }
                sb.append(s.substring(index));
                break;
            }
            String cur = s.substring(index, index + unit);
            if (cur.equals(tmp)) {
                count++;
            } else {
                if (count == 1) {
                    sb.append(tmp);
                } else {
                    sb.append(count + tmp);
                }
                tmp = cur;
                count = 1;
            }
            index += unit;
        }

        String result = sb.toString();
        return result.length();

    }
}

