package beakjoon.b4690;

/**
 * 완전 세제곱
 * author {yhh1056}
 * Create by {2020/09/14}
 */
public class Main {
    public static void main(String[] args) {
        for (int i = 6; i <= 100; i++) {
            for (int j = 2; j <= 100; j++) {
                for (int k = j + 1; k <= 100; k++) {
                    for (int l = k + 1; l <= 100; l++) {
                        if (i * i * i == (j * j * j) + (k * k * k) + (l * l * l)) {
                            System.out.println("Cube = " + i + ", Triple = (" + j + "," + k + "," + l + ")");
                        }
                    }
                }
            }
        }
    }
}
