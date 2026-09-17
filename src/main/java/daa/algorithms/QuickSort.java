package daa.algorithms;
import daa.metrics.Metrics;
public class QuickSort {
    public void sort(int[] arr, Metrics metrics) {
        if (arr == null || arr.length <= 1) return;
        sortRec(arr, 0, arr.length - 1, 0, metrics);
    }
    private void sortRec(int[] arr, int low, int high, int depth, Metrics metrics) {
        while (low < high) {
            metrics.updateDepth(depth);
            int[] bounds = Partition.partition3Way(arr, low, high, metrics);
            int lt = bounds[0];
            int gt = bounds[1];
            if (lt - low < high - gt) {
                sortRec(arr, low, lt - 1, depth + 1, metrics);
                low = gt + 1;
            } else {
                sortRec(arr, gt + 1, high, depth + 1, metrics);
                high = lt - 1;
            }
            depth++;
        }
    }
}