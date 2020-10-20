package beakjoon.b5052;

import java.io.*;
import java.util.Arrays;

/**
 * 전화번호 목록
 * author {yhh1056}
 * Create by {2020/10/20}
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int len = Integer.parseInt(br.readLine());
            String[] nums = new String[len];

            for (int j = 0; j < len; j++) {
                nums[j] = br.readLine();
            }
            Arrays.sort(nums);
            Trie trie = new Trie();
            boolean answer = true;

            for (int j = 0; j < len; j++) {
                answer = trie.insert(nums[j]);
                if (!answer) {
                    break;
                }
            }

            System.out.println(answer ? "YES" : "NO");
        }
    }
}
class Node {
    Node[] child;
    boolean visit;
    public Node() {
        child = new Node[10];
        visit = false;
    }
}

class Trie {
    public Node root;

    public Trie() {
        root = new Node();
    }

    public boolean insert(String numbers) {
        Node check = root;

        for (int i = 0; i < numbers.length(); i++) {
            int num = numbers.charAt(i) - '0';
            if (check.child[num] == null) {
                check.child[num] = new Node();
            }
            check = check.child[num];
            if (check.visit) {
                return false;
            }
        }

        check.visit = true;
        return true;
    }
}
