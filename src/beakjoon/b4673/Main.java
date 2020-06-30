package beakjoon.b4673;

public class Main {
    public static void main(String[] args) {
        int array[] = new int[10001];
        int notSelfNumber = 0;

        for (int i = 1; i < array.length; i++) {
            notSelfNumber = calculator(i);
            if (notSelfNumber <= 10000){
                array[notSelfNumber] = 1;
            }
        }

        for (int i = 1; i < array.length; i ++) {
            if (array[i] != 1) {
                System.out.println(i);
            }
        }
    }

    private static int calculator(int i) {
        int notSelfNumber = i;
        while (i > 0) {
            notSelfNumber += i % 10;
            i /= 10;
        }
        return notSelfNumber;
    }
}
