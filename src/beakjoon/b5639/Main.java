package beakjoon.b5639;

import java.io.*;
/**
 * 이진 검색 트리
 * author {yhh1056}
 * Create by {2020/10/06}
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Tree tree = new Tree();
        String str = "";
        while (true) {
            str = br.readLine();
            if (str == null || str.length() == 0) {
                break;
            }
            int node = Integer.parseInt(str);
            tree.add(node);
        }
        tree.postOrder(tree.root);
    }
}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}

class Tree {
    Node root;

    public void add(int node) {
        if (root == null) {
            root = new Node(node);
        } else {
            search(root, node);
        }
    }

    private void search(Node root, int node) {
        if (root.data > node) {
            if (root.left == null) {
                root.left = new Node(node);
            } else {
                search(root.left, node);
            }
        }
        if (root.data < node) {
            if (root.right == null) {
                root.right = new Node(node);
            } else {
                search(root.right, node);
            }
        }
    }

    public void postOrder(Node root) {
        if (root.left != null) {
            postOrder(root.left);
        }
        if (root.right != null) {
            postOrder(root.right);
        }
        System.out.println(root.data);
    }
}