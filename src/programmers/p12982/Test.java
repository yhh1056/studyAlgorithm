package programmers.p12982;

import java.util.Arrays;

/**
 * author {yhh1056}
 * Create by {2020/08/06}
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);

        for (int i : d) {
            budget -= i;
            if (budget < 0) {
                return answer;
            }
            answer++;
        }
        return answer;
    }
}



//class Solution {
//    public String solution(String phone_number) {
//        StringBuilder answer = new StringBuilder();
//        String[] array = phone_number.split("");
//        int secretLength = phone_number.length() - 4;
//
//        changeSecret(array, secretLength);
//
//        for (String s: array) {
//            answer.append(s);
//        }
//
//        return answer.toString();
//    }
//
//    public void changeSecret(String[] array, int secretLength) {
//        for (int i = 0; i < secretLength; i++) {
//            array[i] = "*";
//        }
//    }
//}
