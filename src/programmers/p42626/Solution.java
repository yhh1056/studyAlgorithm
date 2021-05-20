package programmers.p42626;

import java.util.PriorityQueue;

/**
 * author {yhh1056}
 * Create by {2020/08/11}
 */
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(new int[]{1,2,3}, 13);
        System.out.println(result);
    }

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> scovilles = new PriorityQueue<>();
        for (int s : scoville) {
            scovilles.offer(s);
        }

        int answer = 0;
        while (scovilles.peek() < K) {
            if (scovilles.size() == 1) {
                return -1;
            }

            int poll1 = scovilles.poll();
            int poll2 = scovilles.poll();
            int mix = poll1 + poll2 + poll2;

            scovilles.add(mix);

            if (scovilles.size() == 1 && scovilles.peek() == K) {
                return answer++;
            }
            answer++;
        }

        return answer;
    }
}


