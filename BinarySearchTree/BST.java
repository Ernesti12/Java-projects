package BinarySearchTree;

import java.util.Scanner;

public class BST{
    Object item;
    BST left;
    BST right;
    private BST root;
    public BST(Object item, BST left,BST right){
        this.item = item;
        this.left = left;
        this.right = right;
    }
    public BST(Object item){
        this(item, null, null);
    }
    public BST(){}
    public void insertV1(Object item){
        BST node = new  BST(item);
        BST p = this;
        while(p != null){
            if((int)item < (int)p.item){
                if(p.left == null) {p.left = node; break;}
                else p = p.left;
            }
            else{
                if(p.right == null){p.right = node; break;}
                else p = p.right;
            }

        }//end of while
    }//end of insert
    public void insertV2(Object item) {
        this.root = insertV2(this, item);
    }
    private BST insertV2(BST tree, Object item) {
        if (tree == null) {
            return new BST(item);
        }

        if ((int) item < (int) tree.item) {
            tree.left = insertV2(tree.left, item);
        } else {
            tree.right = insertV2(tree.right, item);
        }

        return tree;
    }
    public void build(){
        this.left = new BST(2);
        this.right = new BST(3);
        this.left.left = new BST(4);
        this.left.right = new BST(15);
        this.left.left.right = new BST(6);

        this.right.left = new BST(7);
        this.right.right = new BST(8);
        this.right.right.left = new BST(9);
    }
    public void preOrder(){
        System.out.print(this.item + " ");
        if(left != null) //traverse the left
            left.preOrder();
        if(right != null) //traverse the right
            right.preOrder();
    }
    public void inOrder(){
        if(left != null) //traverse the left
            left.inOrder();
        System.out.print(this.item + " ");
        if(right != null) //traverse the right
            right.inOrder();
    }
    public void postOrder(){
        if(left != null) //traverse the left
            left.postOrder();
        if(right != null) //traverse the right
            right.postOrder();
        System.out.print(this.item + " ");
    }
    public void levelOrder(){
        MyQueueLinked q = new MyQueueLinked();
        BST p = null;
        q.enqueue(this);
        while(!q.isEmpty()){
            p = (BST)q.qFront();//get the first element, cast to BST
            q.dequeue();//delete the front
            System.out.print(p.item + " ");
            if(p.left != null) q.enqueue(p.left);
            if(p.right != null) q.enqueue(p.right);
        }
    }
    public boolean isEmpty(){
        return this == null;
    }
    public int sum(){
        int sum = 0;
        int leftSum = 0, rightSum = 0;
        if(left != null) leftSum = leftSum + left.sum();
        if(right != null) rightSum = rightSum + right.sum();
        return leftSum + rightSum + (int)this.item;
    }
    public static void buildBST(BST tree) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter elements for the Binary Search Tree (BST), -999 to exit:");

        while (true) {
            System.out.print("Enter number: ");
            int number = scanner.nextInt();

            if (number == -999) {
                break;
            }

            if (tree.item == null) {
                // If it's the first input, set it as the root
                tree.item = number;
            } else {
                tree.insertV2(number);
            }
        }
    }
    public int countNodes() {
        return countNodes(this);
    }
    private int countNodes(BST node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + countNodes(node.left) + countNodes(node.right);
        }
    }
    public int smallest() {
        if (this.left == null && this.right == null) {
            return (int)this.item;
        } else if (this.left != null && this.right == null) {
            return this.left.smallest();
        } else if (this.left == null && this.right != null) {
            return this.right.smallest();
        } else {
            return Math.min(this.left.smallest(), this.right.smallest());
        }
    }
    public int largest() {
        if (this.left == null && this.right == null) {
            return (int)this.item;
        } else if (this.left != null && this.right == null) {
            return this.left.largest();
        } else if (this.left == null && this.right != null) {
            return this.right.largest();
        } else {
            return Math.max(this.left.largest(), this.right.largest());
        }
    }
    public boolean contains(Object item) {
        return this.item.equals(item);
    }
    public int getHeight() {
        return getHeight(this, 0);
    }
    private int getHeight(BST node, int currentHeight) {
        if (node == null) {
            return currentHeight;
        } else {
            int leftHeight = getHeight(node.left, currentHeight + 1);
            int rightHeight = getHeight(node.right, currentHeight + 1);
            return (leftHeight > rightHeight) ? leftHeight : rightHeight;
        }
    }
    public String getNonLeafNodeValues() {
        StringBuilder result = new StringBuilder();
        getNonLeafNodeValues(this, result);
        return result.toString().trim();
    }
    private void getNonLeafNodeValues(BST node, StringBuilder result) {
        if (node != null && (node.left != null || node.right != null)) {
            result.append(node.item).append(" ");
            getNonLeafNodeValues(node.left, result);
            getNonLeafNodeValues(node.right, result);
        }
    }
    public String getLeafNodeValues() {
        StringBuilder result = new StringBuilder();
        getLeafNodeValues(this, result);
        return result.toString().trim();
    }
    private void getLeafNodeValues(BST node, StringBuilder result) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                result.append(node.item).append(" ");
            }
            getLeafNodeValues(node.left, result);
            getLeafNodeValues(node.right, result);
        }
    }
    public boolean searchItem(Object item) {
        return searchItem(this, item);
    }
    private boolean searchItem(BST node, Object item) {
        if (node == null) {
            return false;
        }

        if (node.item.equals(item)) {
            return true;
        } else if ((int)item < (int)node.item) {
            return searchItem(node.left, item);
        } else {
            return searchItem(node.right, item);
        }
    }
    public void deleteItem(Object item) {
        this.root = deleteItem(this.root, item);
    }
    private BST deleteItem(BST root, Object item) {
        if (root == null) {
            return root;
        }

        if ((int)item < (int)root.item) {
            root.left = deleteItem(root.left, item);
        } else if ((int)item > (int)root.item) {
            root.right = deleteItem(root.right, item);
        } else {
            // Node with one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children: Get the inorder successor (smallest
            // in the right subtree)
            root.item = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteItem(root.right, root.item);
        }

        return root;
    }
    private Object minValue(BST root) {
        Object minValue = root.item;
        while (root.left != null) {
            minValue = root.left.item;
            root = root.left;
        }
        return minValue;
    }
    public static void displayBST(BST tree){

        System.out.println("-----------------------------------------------------------------");
        System.out.println("|                      Binary Search Tree                       |");
        System.out.println("-----------------------------------------------------------------");
        System.out.print("Preorder: ");
        tree.preOrder();
        System.out.println();
        System.out.print("Inorder: ");
        tree.inOrder();
        System.out.println();
        System.out.print("Postorder: ");
        tree.postOrder();
        System.out.println();
        System.out.print("Level order: ");
        tree.levelOrder();
        System.out.println();
        System.out.println("The sum  = " + tree.sum());
        System.out.println("The smallest number = " + tree.smallest());
        System.out.println("The largest number = " + tree.largest());
        System.out.println("Contains 100: " + tree.contains(100));
        System.out.println("Number of nodes: " + tree.countNodes());
        System.out.println("The height of the tree: " + tree.getHeight());
        System.out.println("Numbers from non-leaf nodes: " + tree.getNonLeafNodeValues());
        System.out.println("Numbers from leaf nodes: " + tree.getLeafNodeValues());
        System.out.println("-----------------------------------------------------------------");

    }
    private static class BuildThread extends Thread {
        private final BST tree;

        public BuildThread(BST tree) {
            this.tree = tree;
        }

        @Override
        public void run() {
            System.out.print("\nBuilding BST");
            // Simulate processing time (2 seconds)
            try {
                int intervals = 3;  // Number of intervals
                int intervalDuration = 800;  // Duration of each interval in milliseconds

                for (int i = 0; i < intervals; i++) {
                    Thread.sleep(intervalDuration);
                    System.out.print(".");
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("\nData saved.\n");
        }
    }
    private static class SearchingThread extends Thread {
        private final BST tree;
        private final int searchItem;

        public SearchingThread(BST tree, int searchItem) {
            this.tree = tree;
            this.searchItem = searchItem;
        }

        @Override
        public void run() {
            System.out.print("\nSearching");
            // Simulate processing time (2 seconds)
            try {
                int intervals = 3;  // Number of intervals
                int intervalDuration = 800;  // Duration of each interval in milliseconds

                for (int i = 0; i < intervals; i++) {
                    Thread.sleep(intervalDuration);
                    System.out.print(".");
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Perform the search operation
            boolean result = tree.searchItem(searchItem);
            System.out.println("\nSearch result: " + result + "\n");
        }
    }
    private static class DeletingThread extends Thread {
        private final BST tree;
        private final int deleteItem;

        public DeletingThread(BST tree, int deleteItem) {
            this.tree = tree;
            this.deleteItem = deleteItem;
        }

        @Override
        public void run() {
            System.out.print("\nFinding the item");
            // Simulate processing time (2 seconds)
            try {
                int intervals = 3;  // Number of intervals
                int intervalDuration = 800;  // Duration of each interval in milliseconds

                for (int i = 0; i < intervals; i++) {
                    Thread.sleep(intervalDuration);
                    System.out.print(".");
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (tree.searchItem(deleteItem)) {
                tree.deleteItem(deleteItem);
                System.out.println();
                System.out.println("Delete completed.");
                System.out.println();
            } else {
                System.out.println("\nItem not found. Delete operation aborted.\n");
            }
        }
    }

    public static void main(String[] args) {
        BST tree = new BST();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("------------------------------------------------------");
            System.out.println("|                        MENU                        |");
            System.out.println("------------------------------------------------------");
            System.out.println("| [1]. Build the BST.                                |");
            System.out.println("| [2]. Search an item.                               |");
            System.out.println("| [3]. Delete an item.                               |");
            System.out.println("| [4]. Display BST.                                  |");
            System.out.println("| [5]. Exit.                                         |");
            System.out.println("------------------------------------------------------");
            System.out.print("Please select an item from [1-5]: ");
            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    buildBST(tree);
                    BuildThread buildThread = new BuildThread(tree);
                    buildThread.start();

                    try {
                        buildThread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    if (tree.item == null){
                        System.out.println("\nThe tree is still empty.\n");
                        break;
                    }
                    int ch = 1;
                    while(ch == 1){
                        System.out.print("Enter an item to search: ");
                        int searchItem = sc.nextInt();
                        SearchingThread searchingThread = new SearchingThread(tree, searchItem);
                        searchingThread.start();

                        try {
                            searchingThread.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        System.out.print("Do you want to continue searching an item? [Y/N]: ");
                        char breakPoint1 = sc.next().charAt(0);

                        if(breakPoint1 == 'Y' || breakPoint1 == 'y'){}
                        else{
                            ch = 0;
                        }
                    }
                    break;
                case 3:
                    if (tree.item == null){
                        System.out.println("\nThe tree is still empty.\n");
                        break;
                    }
                    int flag = 1;
                    while(flag == 1){
                        System.out.print("Enter an item to delete: ");
                        int deleteItem = sc.nextInt();

                        DeletingThread deletingThread = new DeletingThread(tree, deleteItem);
                        deletingThread.start();

                        try {
                            deletingThread.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.print("Do you want to continue deleting an item? [Y/N]: ");
                        char breakPoint2 = sc.next().charAt(0);

                        if(breakPoint2 == 'Y' || breakPoint2 == 'y'){}
                        else{
                            flag = 0;
                        }
                    }
                    break;
                case 4:
                    if (tree.item == null){
                        System.out.println("\nThe tree is still empty.\n");
                        break;
                    }
                    displayBST(tree);
                    break;
                case 5:
                    System.out.println("----------------------------");
                    System.out.println("|          JIMCARRY        |");
                    System.out.println("----------------------------");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input, Please try again.");
                    break;
            }
        }
    }
}