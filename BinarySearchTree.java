
import java.util.Scanner;

public class BinarySearchTree {
    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    public void inOrder() {
        System.out.print("In-order traversal: ");
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.data + " ");
            inOrderRec(root.right);
        }
    }

    public void preOrder() {
        System.out.print("Pre-order traversal: ");
        preOrderRec(root);
        System.out.println();
    }

    private void preOrderRec(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    public void postOrder() {
        System.out.print("Post-order traversal: ");
        postOrderRec(root);
        System.out.println();
    }

    private void postOrderRec(Node root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of nodes to insert: ");
        int numNodes = scanner.nextInt();

        if (numNodes <= 0) {
            System.out.println("Please enter a positive number of nodes.");
            scanner.close();
            return;
        }

        System.out.println("Enter " + numNodes + " integer values for the BST:");
        for (int i = 0; i < numNodes; i++) {
            System.out.print("Enter value " + (i + 1) + ": ");
            int value;
            try {
                value = scanner.nextInt();
                bst.insert(value);
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next();
                i--;
            }
        }

        bst.inOrder();
        bst.preOrder();
        bst.postOrder();

        scanner.close();
    }
}   

