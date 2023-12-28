package PracticeBst;

import java.util.Scanner;
public class DisplayTree {
    static Scanner sc = new Scanner(System.in);
    static BinarySearchTree tree = new BinarySearchTree();

    public static void main(String[] args) {
        displayBST();
    }
    public static void displayBST(){

        boolean flag = true;
        do{
            System.out.println("==============================================");
            System.out.println("|           Binary Search Tree               |");
            System.out.println("==============================================");
            System.out.println("| I. Input                                   |");
            System.out.println("| D. Display                                 |");
            System.out.println("| S. Search                                  |");
            System.out.println("| E. Delete                                  |");
            System.out.println("| X. Exit                                    |");
            System.out.println("==============================================");
            System.out.print("Enter your choice: ");
            char choice = Character.toLowerCase(sc.next().charAt(0));

            switch(choice){
                case 'i':
                    inputBST();
                    break;
                case 'd':
                    displayOnChoice();
                    break;
                case 's':
                    searchData();
                    break;
                case 'e':
                    removeData();
                    break;
                case 'x':
                    System.out.println("Program terminated.");
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid Choice, Please select the right choice provided.");
                    break;
            }
        } while(flag);
    }
    public static void removeData(){
        if(tree.isEmpty()){
            System.out.println("The tree doesn't exist yet.");
            return;  // Exit the method if the tree is empty
        }
        System.out.print("Enter an Item to delete: ");
        int deleteItem = sc.nextInt();
        if(tree != null){
            tree.remove(deleteItem);
            System.out.println("The data " + deleteItem + " is deleted from the tree.");
        }else{
            System.out.println("The data " + deleteItem + " Doesn't exist.");
        }
    }
    public static void searchData(){
        if (tree.isEmpty()) {
            System.out.println("The tree doesn't exist yet.");
            return;  // Exit the method if the tree is empty
        }
        System.out.print("\nEnter an Item to search: ");
        int searchingData = sc.nextInt();
        System.out.println("\nThe " + searchingData + " returns " + tree.search(searchingData) + "\n");
    }
    public static void inputBST(){
        System.out.println("\n\n==============================================");
        System.out.println("|                 Build a tree               |");
        System.out.println("==============================================");
        while(true){
            System.out.print("Enter a number: ");
            int number = sc.nextInt();

            if(number == -999){
                break;
            }
            tree.insert(new Node(number));
        }
        System.out.println("==============================================\n\n");
    }
    public static void displayOnChoice(){

        if (tree.isEmpty()) {
            System.out.println("The tree doesn't exist yet.");
            return;  // Exit the method if the tree is empty
        }
        boolean flag = true;
        do{
            System.out.println("==============================================");
            System.out.println("[         Select a display order             ]");
            System.out.println("==============================================");
            System.out.println("[ 1. Display InOrder                         ]");
            System.out.println("[ 2. Display PreOrder                        ]");
            System.out.println("[ 3. Display PostOrder                       ]");
            System.out.println("[ 0. Exit                                    ]");
            System.out.println("==============================================");
            System.out.print("Select a choice: ");
            int newChoice = sc.nextInt();

            switch(newChoice){
                case 1:
                    System.out.println("\n==============================================");
                    System.out.println("[                   InOrder                  ]");
                    System.out.println("==============================================");
                    tree.inorder();
                    System.out.println("\n==============================================\n");
                    break;
                case 2:
                    System.out.println("\n==============================================");
                    System.out.println("[                 PreOrder                   ]");
                    System.out.println("==============================================");
                    tree.preOrder();
                    System.out.println("\n==============================================\n");
                    break;
                case 3:
                    System.out.println("\n==============================================");
                    System.out.println("[                 PostOrder                  ]");
                    System.out.println("==============================================");
                    tree.postOrder();
                    System.out.println("\n==============================================\n");
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid Choice, Please select the right choice provided.");
                    break;
            }
        }while(flag);
    }

}
