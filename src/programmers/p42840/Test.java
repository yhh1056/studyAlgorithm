package programmers.p42840;

import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        int[] st1 = {1, 2, 3, 4, 5};
        int[] st2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] st3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int point1 = 0;
        int point2 = 0;
        int point3 = 0;

        for (int i = 0; i < answers.length; i++) {
            if (st1[i % st1.length] == answers[i]) point1++;
            if (st2[i % st2.length] == answers[i]) point2++;
            if (st3[i % st3.length] == answers[i]) point3++;
        }

        int max = Math.max(Math.max(point1, point2), point3);

        ArrayList<Integer> list = new ArrayList<>();

        if (max == point1) {
            list.add(1);
        }
        if (max == point2) {
            list.add(2);
        }
        if (max == point3) {
            list.add(3);
        }

        int[] answer = new int[list.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}