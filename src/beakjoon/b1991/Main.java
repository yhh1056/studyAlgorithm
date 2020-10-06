package beakjoon.b1991;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 트리 순회
 * author {yhh1056}
 * Create by {2020/10/06}
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Tree tree = new Tree();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            tree.add(st.nextToken(), st.nextToken(), st.nextToken());
        }

        tree.preOrder(tree.root);
        System.out.println();
        tree.inorder(tree.root);
        System.out.println();
        tree.postOrder(tree.root);

    }
}

class Node {
    String data;
    Node left;
    Node right;

    public Node(String data) {
        this.data = data;
    }
}

class Tree {
    Node root;

    public void add(String data, String leftData, String rightData) {
        if (root == null) {
            if (!data.equals(".")) {
                root = new Node(data);
            }
            if (!leftData.equals(".")) {
                root.left = new Node(leftData);
            }
            if (!rightData.equals(".")) {
                root.right = new Node(rightData);
            }
        } else {
            search(root, data, leftData, rightData);
        }
    }

    private void search(Node root, String data, String leftData, String rightData) {
        if (root == null) {
            return;
        }
        if (root.data.equals(data)) {
            if (!leftData.equals(".")) {
                root.left = new Node(leftData);
            }
            if (!rightData.equals(".")) {
                root.right = new Node(rightData);
            }
        } else {
            search(root.left, data, leftData, rightData);
            search(root.right, data, leftData, rightData);
        }
    }

    public void preOrder(Node root) {
        System.out.print(root.data);
        if (root.left != null) {
            preOrder(root.left);
        }
        if (root.right != null) {
            preOrder(root.right);
        }
    }

    public void inorder(Node root) {
        if (root.left != null) {
            inorder(root.left);
        }
        System.out.print(root.data);
        if (root.right != null) {
            inorder(root.right);
        }
    }

    public void postOrder(Node root) {
        if (root.left != null) {
            postOrder(root.left);
        }
        if (root.right != null) {
            postOrder(root.right);
        }
        System.out.print(root.data);
    }
}

