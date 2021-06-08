package programmers.p42587;
import java.util.*;

/**
 * Created by yhh1056
 * Date: 2021/06/08 Time: 1:07 오후
 *
 * 프린터
 */

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{2, 1, 3, 2}, 2));
    }
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<File> queue = new LinkedList<>();
        Queue<Integer> prioty = new PriorityQueue<>(Collections.reverseOrder());
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < priorities.length; i++) {
            File file = new File(i, priorities[i]);
            queue.offer(file);
            prioty.offer(priorities[i]);
        }


        int max = prioty.poll();
        while (!queue.isEmpty()) {
            File file = queue.poll();

            if (file.num == max) {
                answer++;
                if (!prioty.isEmpty()) {
                    max = prioty.poll();
                }
                list.add(file.index);
            } else {
                queue.offer(file);
            }

        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == location) {
                answer = i;
            }
        }

        return answer + 1;
    }
}

class File implements Comparator<File> {

    int index;
    int num;

    File(int index, int num) {
        this.index = index;
        this.num = num;
    }

    @Override
    public int compare(File f1, File f2) {
        return f1.num - f2.num;
    }

}
