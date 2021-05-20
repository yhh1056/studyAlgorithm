package programmers.p42884;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 단속 카메라
 */

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[][]{{-20, 15}, {-14, -5}, {-18, -13}, {-5, -3}});
    }

    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(r -> r[1]));
        int count = 0;

        int min = -30001;
        for(int[] route : routes) {
            if(min < route[0]) {
                min = route[1];
                count++;
            }
        }
        return count;
    }
}
