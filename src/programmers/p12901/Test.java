package programmers.p12901;

import java.util.Calendar;

/**
 * author {yhh1056}
 * Create by {2020/07/06}
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(5, 6);
    }
}
class Solution {
    public String solution(int a, int b) {
        String answer = "";

        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, a - 1, b);

        int day = calendar.get(Calendar.DAY_OF_WEEK);

        switch (day) {
            case 1:
                answer = "SUN";
                break;
            case 2:
                answer = "MON";
                break;
            case 3:
                answer = "TUE";
                break;
            case 4:
                answer = "WED";
                break;
            case 5:
                answer = "THU";
                break;
            case 6:
                answer = "FRI";
                break;
            case 7:
                answer = "SAT";
                break;
        }
        return answer;
    }
}
