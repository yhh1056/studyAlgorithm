package programmers.p12918;

/**
 * 클레스 설명
 * <p>
 * author {yhh1056}
 * Create by {2020/07/03}
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("1234"));
    }

}
class Solution {
    public boolean solution(String s) {
        if (s.length() == 4 || s.length() == 6) {
            try {
                Integer.parseInt(s);
                return true;

            }catch (NumberFormatException e) {
                return false;
            }
        } else {
            return false;
        }

//
//        if (s.length() == 4 || s.length() == 6) {
//            for (int i = 0; i < s.length(); i++) {
//                char c = s.charAt(i);
//                if (c < '0' || c > '9') {
//                    return false;
//                }
//            }
//            return true;
//        }
//        return false;
    }
}
