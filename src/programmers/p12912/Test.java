package programmers.p12912;

/**
 * 클레스 설명
 * <p>
 * author {yhh1056}
 * Create by {2020/07/03}
 */
public class Test {
    public static void main(String[] args) {

    }

    class Solution {
        public long solution(int a, int b) {
//            Long answer = 0L;
//
//            if (a == b) {
//                return a;
//            }
//            if (a > b)  {
//                a = a + b;
//                b = a - b;
//                a = a - b;
//            }
//            for (int i = a; i <= b; i++) {
//                answer += i;
//            }
//            return answer;

            return SumAtoB(Math.min(a, b), Math.max(a, b));
        }

        private long SumAtoB(long a, long b) {
            return (b - a + 1) * (a + b) / 2;
        }
    }
}
