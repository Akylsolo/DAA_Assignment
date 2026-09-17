package daa.algorithms;
import daa.metrics.Metrics;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;
public class MergeSortTest {
    private final Random random = new Random();
    private final MergeSort mergeSort = new MergeSort();
    @Test
    public void testCorrectnessOnRandomArrays() {
        for (int i = 0; i < 100; i++) {
            int[] original = generateRandomArray(1000);
            int[] expected = original.clone();
            Arrays.sort(expected);

            int[] actual = original.clone();
            mergeSort.sort(actual, new Metrics());

            assertArrayEquals(expected, actual, "MergeSort failed on random array");
        }
    }
    @Test
    public void testEdgeCases() {
        int[] empty = {};
        mergeSort.sort(empty, new Metrics());
        assertEquals(0, empty.length);

        int[] single = {42};
        mergeSort.sort(single, new Metrics());
        assertEquals(42, single[0]);

        int[] duplicates = {5, 5, 5, 5, 5};
        mergeSort.sort(duplicates, new Metrics());
        assertArrayEquals(new int[]{5, 5, 5, 5, 5}, duplicates);

        int[] sorted = {1, 2, 3, 4, 5};
        mergeSort.sort(sorted, new Metrics());
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, sorted);
    }

    private int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = random.nextInt(10000);
        return arr;
    }
}