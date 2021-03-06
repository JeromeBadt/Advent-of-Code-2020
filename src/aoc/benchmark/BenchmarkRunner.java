package aoc.benchmark;

import aoc.day1.Day1_1;
import aoc.day1.Day1_2;
import aoc.day2.Day2;
import aoc.day3.Day3;
import aoc.day4.Day4_1;
import aoc.day4.Day4_2;
import aoc.day5.Day5;
import aoc.day6.Day6;
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

    @Benchmark
    public void day3_1() throws IOException {
        Day3.traverse1();
    }

    @Benchmark
    public void day3_2() throws IOException {
        Day3.traverse2();
    }

    @Benchmark
    public void day4_1() throws IOException {
        Day4_1.validatePassports();
    }

    @Benchmark
    public void day4_2() throws IOException {
        Day4_2.validatePassports();
    }

    @Benchmark
    public void day5_1() throws IOException {
        Day5.parse1();
    }

    @Benchmark
    public void day5_2() throws IOException {
        Day5.parse2();
    }

    @Benchmark
    public void day6_1() throws IOException {
        Day6.parse1();
    }

    @Benchmark
    public void day6_2() throws IOException {
        Day6.parse2();
    }
}
