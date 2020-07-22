package programmers.p12926;


/**
 * author {yhh1056}
 * Create by {2020/07/22}
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution("x Y", 3);
    }
}

class Solution {
    public String solution(String s, int n) {
        String answer;
        char space = 32;

        char[] chars = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == space) {
                chars[i] = space;
            } else {
                chars[i] = s.charAt(i);
            }
        }

        for (int i = 0; i < chars.length; i ++) {
            if (chars[i] == space ) {
                chars[i] = space;
            } else if (chars[i] <= 90 && chars[i] + n > 90) {
                chars[i] += n - 26;
            } else if (chars[i] <= 122 && chars[i] + n > 122) {
                chars[i] += n - 26;
            } else {
                chars[i] += n;
            }
        }
        answer = String.valueOf(chars);
        System.out.println(answer);
        return answer;
    }
}
