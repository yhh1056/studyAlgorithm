package programmers.p43164;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 여행경로
 */
public class Solution {

    boolean[] visited;
    ArrayList<String> answers;

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(
                new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}});
    }

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        answers = new ArrayList<>();

        String start = "ICN";

        dfs(0, start, "ICN", tickets);

        Collections.sort(answers);
        System.out.println(answers);
        return answers.get(0).split(" ");
    }

    private void dfs(int count, String start, String answer, String[][] tickets) {
        if (count == tickets.length) {
            answers.add(answer);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            String startPoint = tickets[i][0];
            String endPoint = tickets[i][1];

            if (!visited[i] && start.equals(startPoint)) {
                visited[i] = true;
                dfs(count + 1, endPoint, answer + " " + endPoint, tickets);
                visited[i] = false;
            }
        }
    }


}
