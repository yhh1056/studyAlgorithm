package beakjoon.b1406;

import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        String input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            left.push(input.charAt(i));
        }
        String word = br.readLine();
        int len = Integer.parseInt(word);

        for (int i = 0; i < len; i++) {
            String command = br.readLine();
            if (command.startsWith("L")) {
                if(!left.empty()) {
                    right.push(left.pop());
                }
            } else if (command.startsWith("D")) {
                if(!right.empty()) {
                    left.push(right.pop());
                }
            } else if (command.startsWith("B")) {
                if(!left.empty()) {
                    left.pop();
                }
            } else if (command.startsWith("P")) {
                String[] pCommand = command.split(" ");
                left.push(pCommand[1].toCharArray()[0]);
            }
        }

        while(!left.empty()) {
            right.push(left.pop());
        }
        while(!right.empty()) {
            bw.write(right.pop());
        }
        br.close();
        bw.flush();
        bw.close();
    }
}