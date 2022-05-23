package valdes.com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите до какого по счету числа Фибоначи создать дерево");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        TreeHeap tree = new TreeHeap(30);
        int[] arr = tree.getArrayFib(n);
        tree.insertFib(arr);
        tree.printTree();

    }
}
