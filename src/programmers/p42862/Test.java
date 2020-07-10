package programmers.p42862;

import java.util.Arrays;

/**
 * author {yhh1056}
 * Create by {2020/07/10}
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(5, new int[]{2,4}, new int[]{1,3,5}));
    }
}

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n + 2];
        //임의로 맨앞 맨뒤 사람 추가
        students[0] = -9999;
        students[students.length - 1] = -9999;

        int spareAthleticSuit = 1;
        int stillAthleticSuit = -1;
        int canPhysicalEducation = 0;

        //도둑 맞은 사람은 -1
        for (int l : lost) {
            students[l] -= 1 ;
        }
        //여유분 가져온 사람은 1;
        for (int r : reserve) {
            students[r] += 1;
        }

        for (int i = 1; i < n + 1; i++) {
            //도난 당한 사람일 때
            if (students[i] == stillAthleticSuit) {
                //앞사람 먼저 조회
                if (students[i - 1] == spareAthleticSuit) {
                    students[i - 1] = canPhysicalEducation;
                    students[i] = canPhysicalEducation;
                //앞사람 조회 후 뒷사람 조회
                } else if (students[i + 1] == spareAthleticSuit) {
                    students[i] = canPhysicalEducation;
                    students[i + 1] = canPhysicalEducation;
                }
            }
        }

        return (int) Arrays.stream(students).filter(s -> s >= canPhysicalEducation).count();
    }
}
