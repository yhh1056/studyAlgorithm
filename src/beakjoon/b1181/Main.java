package beakjoon.b1181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * 단어 정렬
 * author {yhh1056}
 * Create by {2020/09/03}
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int len = Integer.parseInt(br.readLine());

        HashSet<String> hashSet = new HashSet<>();

        for (int i = 0; i < len; i++) {
            hashSet.add(br.readLine());
        }

        ArrayList<String> list = new ArrayList<>(hashSet);
        list.sort((o1, o2) -> {
            if (o1.length() > o2.length()) {
                return 1;
            } else if (o1.length() < o2.length()) {
                return -1;
            } else {
                return o1.compareTo(o2);
            }
        });

        for (String s : list) {
            System.out.println(s);
        }
    }
}
