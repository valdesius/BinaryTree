package valdes.com.company;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class FibonacciArrayTest {

    @ParameterizedTest
    @ValueSource(ints = {5, 7, 9, 1, 15, 2, 0})
    void test(int number) {
        TreeHeap tree = new TreeHeap(30);
        int arr[] = tree.getArrayFib(number);
        Assert.assertArrayEquals(arr, tree.getArrayFib(number));
    }
}