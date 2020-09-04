package beakjoon.b11652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.TreeMap;

/**
 * author {yhh1056}
 * Create by {2020/09/04}
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());

        TreeMap<Long, Integer> hashMap = new TreeMap<>();

        int count = 0;
        for (int i = 0; i < len; i++) {
            Long key = Long.parseLong(br.readLine());
            if (hashMap.containsKey(key)) {
                hashMap.put(key, hashMap.get(key) + 1);
            } else {
                hashMap.put(key, count);
            }
        }

        int maxValue = Collections.max(hashMap.values());

        for (Long key : hashMap.keySet()) {
            if (maxValue == hashMap.get(key)) {
                System.out.println(key);
                break;
            }
        }
    }
}
