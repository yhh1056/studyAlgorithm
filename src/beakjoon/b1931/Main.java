package beakjoon.b1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * author {yhh1056}
 * Create by {2020/09/04}
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int len = Integer.parseInt(br.readLine());

        ArrayList<Time> times = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            Time time = new Time(start, end);
            times.add(time);
        }

        Collections.sort(times);

        int end = 0;
        int count = 0;
        for (Time m : times) {
            if (end <= m.start) {
                count++;
                end = m.end;
            }
        }
        System.out.println(count);


    }
}

class Time implements Comparable<Time> {
    int start;
    int end;

    public Time(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Time o) {
        if (this.end > o.end) {
            return 1;
        }
        if (this.end == o.end) {
            if (this.start > o.start) {
                return 1;
            }
        }
        return -1;
    }
}
