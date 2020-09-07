package programmers.p42889;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * 실패율
 * author {yhh1056}
 * Create by {2020/09/07}
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(8, new int[]{1,2,3,4,5,6,7});
    }
}

class Solution {
    public int[] solution(int N, int[] stages) {
        double[] answer = new double[N];
        Queue<Integer> queue = new LinkedList<>();
        Arrays.sort(stages);

        for (int i : stages) {
            queue.offer(i);
        }

        int level = 1;
        for (int i = 0; i < N; i++) {
            double count = 0;
            while (!queue.isEmpty() && queue.peek() == level) {
                queue.poll();
                count++;
            }
            level++;
            if (queue.size() + count == 0) {
                answer[i] = 0;
            } else {
                answer[i] = count / (queue.size() + count);
            }
        }

        //answer배열의 높은 값의 인덱스를 가져옴
        return IntStream.range(0, answer.length)
                .boxed().sorted(Comparator.comparingDouble(i -> answer[(int) i]).reversed())
                .mapToInt(ele -> ele + 1).toArray();
    }
}