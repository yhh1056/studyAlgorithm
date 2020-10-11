package beakjoon.b4256;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 트리
 * author {yhh1056}
 * Create by {2020/10/08}
 */
public class Main {
    static int[] preOrder;
    static int[] inOrder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            preOrder = new int[n];
            inOrder = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                preOrder[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                inOrder[j] = Integer.parseInt(st.nextToken());
            }
            Tree tree = new Tree();
            tree.buildTreeByInPre(inOrder, preOrder);
            tree.printPostOrder(tree.root);
            System.out.println();
        }

    }
}

class Tree {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    Node root;
    //포스트오더 또는 프리오더를 어디까지 읽었는지 저장하는 변수
    static int pIndex = 0;

    public void buildTreeByInPre(int[] inOrder, int[] preOrder) {
        pIndex = 0;
        root = buildTreeByInPre(inOrder, preOrder, 0, inOrder.length - 1);
    }

    private Node buildTreeByInPre(int[] inOrder, int[] preOrder, int start, int end) {
        if (start > end) {
            return null;
        }
        Node node = new Node(preOrder[pIndex++]);
        if (start == end) {
            return node;
        }
        int mid = search(inOrder, start, end, node.data);
        node.left = buildTreeByInPre(inOrder, preOrder, start, mid - 1);
        node.right = buildTreeByInPre(inOrder, preOrder, mid + 1 , end);
        return node;
    }

//    public void buildTreeByInPost(int in[], int post[]) {
//        pIndex = post.length - 1;
//        root = buildTreeByInPost(in, post, 0, in.length - 1);
//    }
//
//    private Node buildTreeByInPost(int[] in, int[] post, int start, int end) {
//        if (start > end) {
//            return null;
//        }
//        Node node = new Node(post[pIndex--]);
//        if (start == end) {
//            return node;
//        }
//        int mid = search(in, start, end, node.data);
//        node.right = buildTreeByInPost(in, post, mid + 1, end);
//        node.left = buildTreeByInPost(in, post, start, mid - 1);
//        return node;
//    }

    private int search(int[] arr, int start, int end, int value) {
        for (int i = start; i <= end; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return 0;
    }

    /**
     * 출력 방식 선택
     */

//    public void printPreOrder(Node root) {
//        System.out.print(root.data + " ");
//        if (root.left != null) {
//            printPreOrder(root.left);
//        }
//        if (root.right != null) {
//            printPreOrder(root.right);
//        }
//    }
//
//    public void printInOrder(Node root) {
//        if (root.left != null) {
//            printInOrder(root.left);
//        }
//        System.out.print(root.data + " ");
//        if (root.right != null) {
//            printInOrder(root.right);
//        }
//    }

    public void printPostOrder(Node root) {
        if (root.left != null) {
            printPostOrder(root.left);
        }
        if (root.right != null) {
            printPostOrder(root.right);
        }
        System.out.print(root.data + " ");
    }
}
