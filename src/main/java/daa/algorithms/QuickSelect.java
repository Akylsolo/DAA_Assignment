package daa.algorithms;
import daa.metrics.Metrics;
public class QuickSelect {
    public int select(int[] arr, int k, Metrics metrics) {
        if (arr == null || arr.length == 0 || k < 0 || k >= arr.length) {
            throw new IllegalArgumentException("Invalid input or k is out of bounds");
        }
        return selectRec(arr, k, 0, arr.length - 1, 0, metrics);
    }
    private int selectRec(int[] arr, int k, int low, int high, int depth, Metrics metrics) {
        metrics.updateDepth(depth);
        if (low == high) return arr[low];

        int[] bounds = Partition.partition3Way(arr, low, high, metrics);
        int lt = bounds[0];
        int gt = bounds[1];
        if (k >= lt && k <= gt) return arr[lt];
        if (k < lt) return selectRec(arr, k, low, lt - 1, depth + 1, metrics);
        return selectRec(arr, k, gt + 1, high, depth + 1, metrics);
    }
}