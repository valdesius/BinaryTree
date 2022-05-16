package valdes.com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Tree tree = new Tree();
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        int prev = tree.countPrevNum(tree.count(value));
        tree.insertNode(value);
        tree.insertNode(2);
        tree.insertNode(9);
        tree.insertNode(11);
        tree.insertNode(88);
        tree.printTree();

    }
}
