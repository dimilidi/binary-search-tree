package binarySearchTree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("----------------------");
            System.out.println("Binary Search Tree:");
            System.out.println("----------------------");
            printTree(BinarySearchTree.getRoot(), "", false);

            System.out.println("\nWhat do you want to do?");
            System.out.println("Type 'insert' followed by the value to insert (e.g., 'insert 40')");
            System.out.println("Type 'delete' followed by the value to delete (e.g., 'delete 40')");
            System.out.println("Type 'find' followed by the value to find (e.g., 'find 40')");
            System.out.println("Type 'exit' to quit.");

            String input = scanner.nextLine();
            String[] parts = input.split(" ");

            if (parts.length == 1 && "exit".equals(parts[0])) {
                System.out.println("Exiting program.");
                break;
            } else if (isValid(parts)) continue;



            if (isValid(parts)) continue;

            String command = parts[0];
            int value = Integer.parseInt(parts[1]);

            switch (command) {
                case "insert":
                    bst.insert(value);
                    break;
                case "delete":
                    if (bst.search(value)) {
                       bst.delete(value);
                    } else {
                        System.out.println('❗' +  " No such element " + value + " in the tree. Choose an existing element in order to delete it.");
                    }
                    break;
                case "find":
                    System.out.println("Path to " + value + " in BST: " + bst.findPath(value));
                    break;
                case "exit":
                    System.out.println("Exiting program.");
                    running = false;
                    break;
                default:
                    System.out.println("❌" + " Invalid command. Please try again.");
            }
        }

        scanner.close();
    }

    private static boolean isValid(String[] parts) {
        if (parts.length < 2) {
            System.out.println("❌" + " Invalid input. Please try again.");
            return true;
        }
        return false;
    }

    private static void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }

    private static void printTree(TreeNode root, String prefix, boolean isLeft) {
        if (root != null) {
            printTree(root.right, prefix + (isLeft ? "│   " : "    "), false);
            System.out.println(prefix + (isLeft ? "└── " : "┌── ") + root.val);
            printTree(root.left, prefix + (isLeft ? "    " : "│   "), true);
        }
    }
}