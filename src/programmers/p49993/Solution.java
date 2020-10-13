package programmers.p49993;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 스킬트리
 * author {yhh1056}
 * Create by {2020/10/13}
 */
class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("CBD", new String[]{"BACDE", "AAA","CBADF", "AECB", "BDA"}));
    }
}

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        String[] skills = skill.split("");

        for (int i = 0; i < skill_trees.length; i++) {
            for (int j = 0; j < skills.length; j++) {
                skill_trees[i] = skill_trees[i].replace(skills[j], String.valueOf(j));
            }
            skill_trees[i] = skill_trees[i].replaceAll("[^0-9]","");
            System.out.println("skill_trees = " + skill_trees[i]);
            if (skill_trees[i].isEmpty()) {
                answer++;
            }
            String[] split = skill_trees[i].split("");

            int count = 0;
            for (int j = 0; j < split.length; j++) {
                if (split[j].equals(String.valueOf(j))) {
                    count++;
                }
            }
            if (count == split.length) {
                answer++;
            }
        }

        return answer;
    }

}