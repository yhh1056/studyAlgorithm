package beakjoon.b15596;

public class Test {
    long sum(int[] a) {
        long answer = 0;
        for (int i = 0; i < a.length; i++) {
            answer += a[i];
        }
        return answer;
    }
}
