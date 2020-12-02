package aoc.benchmark;

import aoc.day1.Day1_1;
import aoc.day1.Day1_2;
import aoc.day2.Day2;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Warmup(iterations = 20, time = 200, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 50, time = 200, timeUnit = TimeUnit.MILLISECONDS)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@BenchmarkMode(Mode.AverageTime)
public class BenchmarkRunner {

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(BenchmarkRunner.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @Benchmark
    public void day1_1() throws IOException {
        Day1_1.twoSum();
    }

    @Benchmark
    public void day1_2() {
        Day1_2.threeSum();
    }

    @Benchmark
    public void day2_1() throws IOException {
        Day2.parse1();
    }

    @Benchmark
    public void day2_2() throws IOException {
        Day2.parse2();
    }
}
