package daa.algorithms;
import daa.metrics.Metrics;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;
public class QuickSelectTest {
    private final Random random = new Random();
    private final QuickSelect quickSelect = new QuickSelect();

    @Test
    public void testCorrectnessOnRandomArrays() {
        for (int i = 0; i < 100; i++) {
            int[] arr = generateRandomArray(1000);
            int[] sorted = arr.clone();
            Arrays.sort(sorted);

            int k = random.nextInt(arr.length);
            int result = quickSelect.select(arr.clone(), k, new Metrics());

            assertEquals(sorted[k], result, "QuickSelect failed to find k-th element");
        }
    }

    @Test
    public void testInvalidInputs() {
        int[] empty = {};
        int[] arr = {1, 2, 3};
        assertThrows(IllegalArgumentException.class, () -> quickSelect.select(empty, 0, new Metrics()));
        assertThrows(IllegalArgumentException.class, () -> quickSelect.select(arr, -1, new Metrics()));
        assertThrows(IllegalArgumentException.class, () -> quickSelect.select(arr, 5, new Metrics()));
    }
    private int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = random.nextInt(10000);
        return arr;
    }
}