package valdes.com.company;

public class Main {

    public static void main(String[] args) {
        Tree tree = new Tree();
        int[] arr = tree.getArrayFib(6);
        tree.insertFib(arr);
        tree.printTree();
    }
}
