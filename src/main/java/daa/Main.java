package daa;
import daa.bench.Benchmark;
import daa.metrics.CsvWriter;
import daa.metrics.Result;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Запуск бенчмарка,подождите, это может занять пару минут");
        Benchmark benchmark = new Benchmark();
        List<Result> results = benchmark.run();
        CsvWriter.write(results, "results.csv");

        System.out.println("Готово! Результаты успешно сохранены в файл results.csv");
    }
}