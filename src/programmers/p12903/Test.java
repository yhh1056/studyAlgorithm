package programmers.p12903;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("yhh1056"));
    }


}
class Solution {
    public String solution(String s) {
        int len = s.length();
        int middleNumber = len / 2;

        if (s.length() % 2 != 0) {
            return s.substring(middleNumber, middleNumber + 1);
        }
        return s.substring(middleNumber - 1, middleNumber + 1);

    }
}
