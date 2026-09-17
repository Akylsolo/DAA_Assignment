package daa.algorithms;
import daa.metrics.Metrics;
public class InsertionSort {
    public static void sortStatic(int[] arr, int left, int right, Metrics metrics) {
        for (int i = left + 1; i <= right; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= left) {
                metrics.incrementComparisons();
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                    j--;
                } else {
                    break;
                }
            }
            arr[j + 1] = temp;
        }
    }
    public void sort(int[] arr, Metrics metrics) {
        sortStatic(arr, 0, arr.length - 1, metrics);
    }
}