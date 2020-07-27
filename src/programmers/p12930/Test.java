package programmers.p12930;


/**
 * author {yhh1056}
 * Create by {2020/07/27}
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("try hello  world"));
    }
}

class Solution {
    public String solution(String s) {
        String answer;
        answer = s.toUpperCase();
        char[] chars = answer.toCharArray();

        //앞문자가 대문자라면 소문자로 치환
        for (int i = 1; i < chars.length; i++) {
            if (62 <= chars[i - 1] && chars[i - 1] <= 90) {
                chars[i] = Character.toLowerCase(chars[i]);
            }
        }
        answer = String.valueOf(chars);
        return answer;
    }
}
