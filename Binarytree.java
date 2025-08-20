import java.util.Scanner;

public class Binarytree {
    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    Node root;

    public Binarytree() {
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

    public boolean search(int key) {
        return searchRec(root, key);
    }

    private boolean searchRec(Node root, int key) {
        if (root == null || root.data == key) {
            return root != null;
        }
        if (key < root.data) {
            return searchRec(root.left, key);
        }
        return searchRec(root.right, key);
    }

    public void inOrder() {
        System.out.print("In-order: ");
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
        System.out.print("Pre-order: ");
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
        System.out.print("Post-order: ");
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
        Binarytree bst = new Binarytree();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int numNodes = scanner.nextInt();

        if (numNodes <= 0) {
            System.out.println("Please enter a positive number.");
            scanner.close();
            return;
        }

        System.out.println("Enter " + numNodes + " values:");
        for (int i = 0; i < numNodes; i++) {
            System.out.print("Value " + (i + 1) + ": ");
            bst.insert(scanner.nextInt());
        }

        bst.inOrder();
        bst.preOrder();
        bst.postOrder();

        System.out.print("Enter a value to search: ");
        int searchValue = scanner.nextInt();
        System.out.println(searchValue + (bst.search(searchValue) ? " found" : " not found"));

        scanner.close();
    }
}
 


