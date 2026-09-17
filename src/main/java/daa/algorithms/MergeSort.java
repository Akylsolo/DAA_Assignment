package daa.algorithms;
import daa.metrics.Metrics;
public class MergeSort {
    private static final int CUTOFF = 15;
    public void sort(int[] arr, Metrics metrics) {
        if (arr == null || arr.length <= 1) return;
        int[] buffer = new int[arr.length]; // Буфер выделяется один раз тут
        sortRec(arr, buffer, 0, arr.length - 1, 0, metrics);
    }

    private void sortRec(int[] arr, int[] buffer, int left, int right, int depth, Metrics metrics) {
        metrics.updateDepth(depth);
        if (right - left <= CUTOFF) {
            InsertionSort.sortStatic(arr, left, right, metrics);
            return;
        }
        int mid = left + (right - left) / 2;
        sortRec(arr, buffer, left, mid, depth + 1, metrics);
        sortRec(arr, buffer, mid + 1, right, depth + 1, metrics);
        merge(arr, buffer, left, mid, right, metrics);
    }
    private void merge(int[] arr, int[] buffer, int left, int mid, int right, Metrics metrics) {
        System.arraycopy(arr, left, buffer, left, right - left + 1);
        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                arr[k] = buffer[j++];
            } else if (j > right) {
                arr[k] = buffer[i++];
            } else {
                metrics.incrementComparisons();
                if (buffer[j] <= buffer[i]) {
                    arr[k] = buffer[j++];
                } else {
                    arr[k] = buffer[i++];
                }
            }
        }
    }
}