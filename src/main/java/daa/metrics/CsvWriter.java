package daa.metrics;
import java.io.PrintWriter;
import java.util.List;
public class CsvWriter {
    public static void write(List<Result> results, String filename) {
        try (PrintWriter pw = new PrintWriter(filename)) {
            pw.println("algorithm,input,n,time_ms,comparisons,max_depth");
            for (Result r : results) {
                pw.printf("%s,%s,%d,%.3f,%d,%d\n",
                        r.algorithm(), r.input(), r.n(), r.timeMs(), r.comparisons(), r.maxDepth());
            }
        } catch (Exception e) {
            System.err.println("Failed to write CSV: " + e.getMessage());
        }
    }
}