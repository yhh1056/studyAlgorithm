package programmers.p12948;

/**
 * 프로그래머스 핸드폰 번호 가리기 문제;
 *
 * author {yhh1056}
 * Create by {2020/06/29}
 */
public class Test {

        public static void main(String[] args) {
            Solution solution = new Solution();
            solution.solution("01012341234");

            Solution2 solution2 = new Solution2();
            solution2.solution("01012341234");

        }
}

class Solution {
    public String solution(String phone_number) {
        StringBuilder encryptionPhoneNumber = new StringBuilder();
        String secret = "*";
        int numberCiphers = phone_number.length() - 4;
        String showPhoneNumber = phone_number.substring(numberCiphers, phone_number.length());

        for (int i = 0; i < numberCiphers; i++) {
            encryptionPhoneNumber.append(secret);
        }
        encryptionPhoneNumber = encryptionPhoneNumber.append(showPhoneNumber);
        return String.valueOf(encryptionPhoneNumber);
    }
}

class Solution2 {
    public String solution(String phone_number) {
        char[] answer = phone_number.toCharArray();
        for (int i = 0; i < answer.length - 4; i++) {
            answer[i] = '*';
        }
        return String.valueOf(answer);
    }
}
