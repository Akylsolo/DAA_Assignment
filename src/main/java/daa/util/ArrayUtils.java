package daa.util;
import java.util.Random;
public class ArrayUtils {
    private static final Random RND = new Random();

    public static int[] generate(InputType type, int n) {
        int[] arr = new int[n];
        if (type == InputType.RANDOM) {
            for (int i = 0; i < n; i++) arr[i] = RND.nextInt();
        } else if (type == InputType.SORTED) {
            for (int i = 0; i < n; i++) arr[i] = i;
        } else if (type == InputType.DUPLICATES) {
            for (int i = 0; i < n; i++) arr[i] = RND.nextInt(10);
        }
        return arr;
    }
    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) return false;
        }
        return true;
    }
}