import java.util.Scanner;
class BinarySearchTree {

class Node {
        int key;        
        Node left, right;
        public Node(int item) {
            key = item;
            left = right = null;
        }
    }
    Node root; 
    BinarySearchTree() {
        root = null;
    }
    
    void insert(int key) {
        root = insertRec(root, key);
    }
   
    Node insertRec(Node root, int key) {
        if (root == null) { 
            root = new Node(key);
            return root;
        }
        if (key < root.key) 
            root.left = insertRec(root.left, key);
        else if (key > root.key) 
            root.right = insertRec(root.right, key);
        return root;
    }
  
    boolean search(int key) {
        return searchRec(root, key);
    }
   
    boolean searchRec(Node root, int key) {
        if (root == null) 
            return false;
        if (root.key == key) 
            return true;
        if (key < root.key) 
            return searchRec(root.left, key);
        else 
            return searchRec(root.right, key);
    }

    void inorder() {
        inorderRec(root);
        System.out.println();
    }
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    void preorder() {
        preorderRec(root);
        System.out.println();
    }
    void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }
  
    void postorder() {
        postorderRec(root);
        System.out.println();
    }
    void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.key + " ");
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();
        System.out.print("Enter Number Of Elements To Insert: ");
        int n = sc.nextInt();
     
        System.out.println("Enter " + n + " Elements:");
        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            bst.insert(value);
        }
       
        System.out.print("Inorder Traversal   : ");
        bst.inorder();
        System.out.print("Preorder Traversal  : ");
        bst.preorder();
        System.out.print("Postorder Traversal : ");
        bst.postorder();
      
        System.out.print("Enter Element To Search: ");
        int searchKey = sc.nextInt();
       
        if (bst.search(searchKey))
            System.out.println(searchKey + " Found in BST.");
        else
            System.out.println(searchKey + " Not Found in BST.");
        sc.close();
    }
}


