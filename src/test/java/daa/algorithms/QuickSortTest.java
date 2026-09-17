package daa.algorithms;

import daa.metrics.Metrics;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;
public class QuickSortTest {
    private final Random random = new Random();
    private final QuickSort quickSort = new QuickSort();

    @Test
    public void testCorrectnessOnRandomArrays() {
        for (int i = 0; i < 100; i++) {
            int[] original = generateRandomArray(1000);
            int[] expected = original.clone();
            Arrays.sort(expected);

            int[] actual = original.clone();
            quickSort.sort(actual, new Metrics());

            assertArrayEquals(expected, actual, "QuickSort failed on random array");
        }
    }

    @Test
    public void testDepthOnSortedArray() {
        int n = 100_000;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = i;

        Metrics metrics = new Metrics();
        quickSort.sort(arr, metrics);

        double maxAllowedDepth = 2 * (Math.log(n) / Math.log(2));
        assertTrue(metrics.getMaxDepth() <= maxAllowedDepth,
                "QuickSort max depth exceeded! Was: " + metrics.getMaxDepth());
    }

    @Test
    public void testEdgeCases() {
        int[] empty = {};
        quickSort.sort(empty, new Metrics());
        assertEquals(0, empty.length);

        int[] duplicates = {9, 9, 9, 9};
        quickSort.sort(duplicates, new Metrics());
        assertArrayEquals(new int[]{9, 9, 9, 9}, duplicates);
    }

    private int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = random.nextInt(10000);
        return arr;
    }
}