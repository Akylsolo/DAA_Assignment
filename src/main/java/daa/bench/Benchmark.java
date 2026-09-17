package daa.bench;

import daa.algorithms.*;
import daa.metrics.Metrics;
import daa.metrics.Result;
import daa.util.ArrayUtils;
import daa.util.InputType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public final class Benchmark {
    private static final int[] SIZES = {1000, 10000, 100000, 1000000};
    private static final int RUNS = 5;

    @FunctionalInterface
    public interface Task {
        void run(int[] data, Metrics metrics);
    }

    public List<Result> run() {
        List<Result> results = new ArrayList<>();

        InsertionSort is = new InsertionSort();
        MergeSort ms = new MergeSort();
        QuickSort qs = new QuickSort();
        QuickSelect qsSelect = new QuickSelect();
        benchmark("InsertionSort", 10000, true, is::sort, results);
        benchmark("MergeSort", Integer.MAX_VALUE, true, ms::sort, results);

        benchmark("QuickSelect", Integer.MAX_VALUE, false,
                (data, metrics) -> qsSelect.select(data, data.length / 2, metrics), results);

        return results;
    }
    private void benchmark(String algorithm, int maxN, boolean mustSort, Task task, List<Result> out) {
        try {
            for (InputType input : InputType.values()) {
                for (int n : SIZES) {
                    if (n > maxN) {
                        continue;
                    }
                    Result result = medianOfRuns(algorithm, input, n, mustSort, task);
                    out.add(result);
                    System.out.printf(Locale.ROOT, "%-14s %-11s n=%-9d %10.3f ms   comparisons=%-10d max_depth=%d\n",
                            algorithm, input.label(), n, result.timeMs(), result.comparisons(), result.maxDepth());
                }
            }
        } catch (UnsupportedOperationException e) {
            System.out.println("[skip] " + algorithm + ": " + e.getMessage());
        }
    }
    private Result medianOfRuns(String algorithm, InputType input, int n, boolean mustSort, Task task) {
        Result[] runs = new Result[RUNS];

        for (int r = 0; r < RUNS; r++) {
            int[] data = ArrayUtils.generate(input, n);
            Metrics metrics = new Metrics();

            long start = System.nanoTime();
            task.run(data, metrics);
            long end = System.nanoTime();

            if (mustSort && !ArrayUtils.isSorted(data)) {
                throw new IllegalStateException(algorithm + " did not sort the array properly!");
            }

            double timeMs = (end - start) / 1_000_000.0;
            runs[r] = new Result(algorithm, input.label(), n, timeMs, metrics.getComparisons(), metrics.getMaxDepth());
        }
        Arrays.sort(runs, Comparator.comparingDouble(Result::timeMs));
        return runs[RUNS / 2];
    }
}