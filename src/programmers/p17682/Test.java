package programmers.p17682;

/**
 * author {yhh1056}
 * Create by {2020/08/07}
 */
public class Test {
    public static void main(String[] args) {
        String s = "1D2S#10S";
        Solution solution = new Solution();
        System.out.println(solution.solution(s));
    }
}

class Solution {
    public int solution(String dartResult) {
        int count = 0;
        int number = 0;
        int[] score = new int[3];

        String[] strings = dartResult.split("");

        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals("1") && strings[i + 1].equals("0")) {
                number = 10;
                score[count] = number;
                count++;
                i++;
            } else if (strings[i].matches("[\\d]")) {
                number = Integer.parseInt(strings[i]);
                score[count] = number;
                count++;
            } else {
                switch (strings[i]) {
                    case "S" -> score[count - 1] = number;
                    case "D" -> score[count - 1] = (int) Math.pow(number, 2);
                    case "T" -> score[count - 1] = (int) Math.pow(number, 3);
                    case "*" -> {
                        if (count > 1) {
                            score[count - 2] *= 2;
                        }
                        score[count - 1] *= 2;
                    }
                    case "#" -> score[count - 1] *= -1;
                }
            }

        }
        return score[0] + score[1] + score[2];
    }
}
