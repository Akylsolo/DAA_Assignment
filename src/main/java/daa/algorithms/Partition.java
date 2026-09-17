package daa.algorithms;
import daa.metrics.Metrics;
import java.util.Random;
public class Partition {
    private static final Random random = new Random();
    public static int[] partition3Way(int[] arr, int low, int high, Metrics metrics) {
        int pivotIdx = low + random.nextInt(high - low + 1);
        swap(arr, low, pivotIdx);
        int pivot = arr[low];

        int lt = low, gt = high, i = low + 1;
        while (i <= gt) {
            metrics.incrementComparisons();
            if (arr[i] < pivot) {
                swap(arr, lt++, i++);
            } else if (arr[i] > pivot) {
                metrics.incrementComparisons();
                swap(arr, i, gt--);
            } else {
                metrics.incrementComparisons();
                i++;
            }
        }
        return new int[]{lt, gt};
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}