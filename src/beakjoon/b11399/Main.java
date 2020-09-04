package beakjoon.b11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * author {yhh1056}
 * Create by {2020/09/04}
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> line = new PriorityQueue<>();
        for (int i = 0; i < len; i++) {
            line.offer(Integer.parseInt(st.nextToken()));
        }
        int time = 0;
        while (!line.isEmpty()) {
            time += (len * line.poll());
            len--;
        }
        System.out.println(time);
    }
}
