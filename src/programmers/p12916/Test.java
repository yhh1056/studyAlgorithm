package programmers.p12916;

/**
 * 클레스 설명
 * <p>
 * author {yhh1056}
 * Create by {2020/07/03}
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solution("pPoooyY"));
    }
}

class Solution {
    boolean solution(String s) {
        String up = s.toUpperCase();
//        String p = "P";
//        String y = "Y";
//        int count = 0;
//        for (int i = 0; i < up.length(); i++) {
//            if (p.charAt(0) == up.charAt(i)) {
//                count++;
//            } else if(y.charAt(0) == up.charAt(i)) {
//                count--;
//            }
//        }
//        if (count == 0) {
//            return true;
//        } else  {
//            return false;
//        }
//        /**
//         * return count == 0;  <- 런타임 에러
//         */
        return up.chars().filter(i -> 'P' == i).count() == up.chars().filter(i -> 'Y' == i).count();
    }
}
