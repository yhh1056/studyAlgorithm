package programmers.p43162;

/**
 * 네트워크
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(5, new int[][]{
                {1, 1, 0, 1, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1}});
    }

    static boolean[] visit;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];

        for (int node = 0; node < n; node++) {
            if (!visit[node]) {
                dfs(computers, node);
                answer++;
            }
        }

        System.out.println(answer);
        return answer;
    }

    private void dfs(int[][] computers, int node) {
        visit[node] = true;

        for (int j = 0; j < computers.length; j++) {
            if (!visit[j] && computers[node][j] == 1) {
                dfs(computers, j);
            }
        }
    }



}
