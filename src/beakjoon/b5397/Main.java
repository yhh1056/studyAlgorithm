package beakjoon.b5397;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;

/**
 * Created by yhh1056
 * Date: 2021/05/31 Time: 8:16 오후
 * 키로거
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            char[] passwords = br.readLine().toCharArray();

            int pointer = 0;
            LinkedList<Character> input = new LinkedList<>();

            for (char password : passwords) {
                switch (password) {
                    case ('<'):
                        if (pointer > 0) {
                            pointer--;
                        }
                        break;
                    case '>':
                        if (pointer < input.size()) {
                            pointer++;
                        }
                        break;
                    case '-':
                        if (!input.isEmpty()) {
                            if (pointer > 0) {
                                input.remove(pointer - 1);
                                pointer--;
                            }
                        }
                        break;
                    default:
                        input.add(pointer++, password);
                        break;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (char c : input) {
                sb.append(c);
            }
            System.out.println(sb.toString());
        }
    }

    public static String solutionByListIterator(String input) {

        char[] passwords = input.toCharArray();

        LinkedList<Character> linkedList = new LinkedList<>();

        ListIterator<Character> list = linkedList.listIterator();

        for (char password : passwords) {
            switch(password) {
                case '<' :
                    if (list.hasPrevious()) {
                        list.previous();
                    }
                    break;
                case '>' :
                    if (list.hasNext()) {
                        list.next();
                    }
                    break;
                case '-' :
                    if(list.hasPrevious()) {
                        list.previous();
                        list.remove();
                    }
                    break;
                default :
                    list.add(password);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character character : linkedList) {
            sb.append(character);
        }

        return sb.toString();
    }

    public static String solutionByStack(String input) {

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        char[] passwords = input.toCharArray();
        for (char password : passwords) {

            switch (password) {
                case '<' :
                    if (!left.isEmpty()) {
                        right.push(left.pop());
                    }
                    break;
                case '>' :
                    if (!right.isEmpty()) {
                        left.push(right.pop());
                    }
                    break;
                case '-' :
                    if (!left.isEmpty()) {
                        left.pop();
                    }
                    break;
                default :
                    left.push(password);
            }
        }
        StringBuilder sb = new StringBuilder();

        for (Character character : left) {
            sb.append(character);
        }

        while (!right.isEmpty()) {
            sb.append(right.pop());
        }
        return sb.toString();
    }



}
