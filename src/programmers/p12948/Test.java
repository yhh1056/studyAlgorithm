package programmers.p12948;
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("01012345678"));
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
