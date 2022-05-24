package valdes.com.company;

public class TreeHeap {
    private TreeNode[] heapArray;
    private int maxSize;
    private int currentSize;

    public TreeHeap(int maxSize) {
        this.maxSize = maxSize;
        this.currentSize = 0;
        heapArray = new TreeNode[maxSize];
    }

    public int[] getArrayFib(int value) {
        if (value == 0) {
            throw new IllegalArgumentException();
        }

        int[] arr = new int[value];

        for (int i = 0; i < arr.length; i++) {
            if (i < 2) {
                arr[i] = 1;
            } else {
                arr[i] = arr[i - 2] + arr[i - 1];
            }
            System.out.print(arr[i] + " ");
        }
        return arr;
    }

    public void printTree() {

        System.out.println();
        int countOfGaps = 32;
        int itemsPerRow = 1;
        int columnNumber = 0;
        String line = "___________________________________________________________________";
        System.out.println(line);
        for (int i = 0; i < currentSize; i++) {
            if (columnNumber == 0) {
                for (int k = 0; k < countOfGaps; k++) {
                    System.out.print(' ');
                }
            }
            System.out.print(heapArray[i].getValue());

            if (++columnNumber == itemsPerRow) {
                countOfGaps /= 2;
                itemsPerRow *= 2;
                columnNumber = 0;
                System.out.println();
            } else {
                for (int k = 0; k < countOfGaps * 2 - 2; k++) {
                    System.out.print(' ');
                }
            }
        }
        System.out.println("\n" + line);
    }

    public void insertFib(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            insertNode(arr[i]);
        }
    }

    public boolean insertNode(int value) {
        if (currentSize == maxSize) {
            return false;
        }
        TreeNode newNode = new TreeNode(value);
        heapArray[currentSize] = newNode;
        displaceUp(currentSize++);
        return true;
    }



    public TreeNode removeNode(int index) {
        if (index > 0 && currentSize > index) {
            TreeNode root = heapArray[index];
            heapArray[index] = heapArray[--currentSize];
            heapArray[currentSize] = null;
            displaceDown(index);
            return root;
        }
        return null;
    }

    private void displaceUp(int index) {
        int parentIndex = (index - 1) / 2;
        TreeNode bottom = heapArray[index];

        while (index > 0 && heapArray[parentIndex].getValue() < bottom.getValue()) {
            heapArray[index] = heapArray[parentIndex];
            index = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
        heapArray[index] = bottom;
    }

    private void displaceDown(int index) {
        int largerChild;
        TreeNode top = heapArray[index];
        while (index < currentSize / 2) {
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;
            if (rightChild < currentSize && heapArray[leftChild].getValue() < heapArray[rightChild].getValue()) {
                largerChild = rightChild;
            } else {
                largerChild = leftChild;
            }
            if (top.getValue() >= heapArray[largerChild].getValue()) {

                break;
            }
            heapArray[index] = heapArray[largerChild];
            index = largerChild;
        }
        heapArray[index] = top;
    }
}
