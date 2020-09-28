package programmers.p68644;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * 두개뽑아서 더하기
 * author {yhh1056}
 * Create by {2020/09/28}
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.solution(new int[]{2,1,3,4,1});
    }

    public int[] solution(int[] numbers) {
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        int[] answer = new int[set.size()];
        Iterator<Integer> iter = set.iterator();
        int i = 0;
        while (iter.hasNext()) {
            answer[i++] = iter.next();
        }
        return answer;
    }

}
