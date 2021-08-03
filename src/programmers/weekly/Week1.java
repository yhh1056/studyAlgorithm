package programmers.weekly;

/**
 * Created by yhh1056
 * Date: 2021/08/03 Time: 4:08 오후
 */
public class Week1 {

    public long solution(int price, int money, int count) {
        long totalPrice = 0;

        for (int i = 1; i <= count; i++) {
            totalPrice += price * i;
        }

        if (money - totalPrice >= 0) {
            return 0;
        }

        return totalPrice - money;
    }

}
