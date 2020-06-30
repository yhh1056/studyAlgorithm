package beakjoon.b5543;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by yhh1056 on 2020-05-29.
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> priceList = new ArrayList<>();

        int hamburger = 0;
        int beverage = 0;
        int price;
        int salePrice = 50;

        for (int i = 0; i < 5; i++) {
            price = scanner.nextInt();
            priceList.add(price);

            if (i < 3) {
                Collections.sort(priceList);
                hamburger = priceList.get(0);
            }

            if (i >= 3) {
                Collections.sort(priceList);
                beverage = priceList.get(0);
            }
        }
        int hamburgerAndBeveragePrice = hamburger + beverage - salePrice;
        System.out.println(hamburgerAndBeveragePrice);
    }
}
