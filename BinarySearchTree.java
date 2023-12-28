package PracticeBst;

public class BinarySearchTree {
    Node root;
    public void insert(Node node){
        root = insertHelper(root, node);
    }
    private Node insertHelper(Node root, Node node){
        int data = node.data;

        if(root == null){
            root = node;
            return root;
        } else if(data < root.data){
            root.left = insertHelper(root.left, node);
        } else {
            root.right = insertHelper(root.right, node);
        }
        return root;
    }
    public void display(){
            displayHelper(root);
    }
    private void displayHelper(Node root){
        if(root != null){
            displayHelper(root.left);
            System.out.print(" " + root.data);
            displayHelper(root.right);
        }
    }

    //left to root to right -Inorder traversal
    public void inorder(){
        inorderHelper(root);
    }
    private void inorderHelper(Node root){
        if(root != null){
            inorderHelper(root.left);
            System.out.print(" " + root.data);
            inorderHelper(root.right);
        }
    }

    //root to left to right
    public void preOrder(){
            preOrderHelper(root);
    }
    private void preOrderHelper(Node root){
        if(root != null){
            System.out.print(" " + root.data);
            preOrderHelper(root.left);
            preOrderHelper(root.right);
        }
    }
    //left to right to root
    public void postOrder(){
        postOrderHelper(root);
    }
    private void postOrderHelper(Node root){
        if(root != null){
            postOrderHelper(root.left);
            postOrderHelper(root.right);
            System.out.print(" " + root.data);
        }
    }
    public boolean search(int data){
        return searchHelper(root, data);
    }
    private boolean searchHelper(Node root, int data){
        if(root == null){
            return false;
        } else if(root.data == data){
            return true;
        } else if(root.data > data){
            return searchHelper(root.left, data);
        } else{
            return searchHelper(root.right, data);
        }
    }
    public void remove(int data){
        if(search(data)){
            removeHelper(root,data);
        } else{
            System.out.println(data + " could not be found.");
        }
    }
    private Node removeHelper(Node root, int data){
        if(root == null){
            return root;
        } else if(data < root.data){
            root.left = removeHelper(root.left, data);
        } else if(data > root.data){
            root.right = removeHelper(root.right, data);
        } else {
            if(root.left == null && root.right == null){
                root = null;
            }else if(root.left != null){
                root.data = successor(root);
                root.right = removeHelper(root.left, root.data);
            }else{
                root.data = predecessor(root);
                root.left = removeHelper(root.right, root.data);
            }
        }
        return root;

    }
    private int successor(Node root){
        root = root.right;
        while(root.left != null){
            root = root.left;
        }
        return root.data;
    }
    private int predecessor(Node root){
        root = root.left;
        while(root.right != null){
            root = root.right;
        }
        return root.data;
    }
    public boolean isEmpty() {
        return root == null;
    }

}
