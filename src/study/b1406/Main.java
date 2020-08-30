package study.b1406;

import java.io.*;
import java.util.Stack;

/**
 * author {yhh1056}
 * Create by {2020/08/30}
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        String word = br.readLine();
        for (int i = 0; i < word.length(); i++) {
            leftStack.push(word.charAt(i));
        }

        int len = Integer.parseInt(br.readLine());
        for (int i = 0; i < len; i++) {
            String command = br.readLine();
            if (command.startsWith("P")) {
                String[] commandP = command.split(" ");
                leftStack.push(commandP[1].charAt(0));
            } else if (command.startsWith("L")) {
                if (!leftStack.isEmpty()) {
                    rightStack.push(leftStack.pop());
                }
            } else if (command.startsWith("B")) {
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                }
            } else if (command.startsWith("D")) {
                if (!rightStack.isEmpty()) {
                    leftStack.push(rightStack.pop());
                }
            }
        }
        while (!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }
        while (!rightStack.isEmpty()) {
            bw.write(rightStack.pop());
        }
        br.close();
        bw.flush();
    }
}
