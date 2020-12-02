package aoc.day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.stream.Collectors;


public class Day1_2 {
    private final static int sum = 2020;

    public static void main(String[] args) {
        threeSum();
    }

    public static void threeSum() {
        final var set = getSet();
        for (final var a : set) {
            if (twoSum(a, set)) return;
        }
    }

    private static HashSet<Integer> getSet() {
        try {
            final var lines = Files.lines(Paths.get("input\\day1.txt"));
            return lines.map(Integer::parseInt).collect(Collectors.toCollection(HashSet::new));
        } catch (IOException e) {
            e.printStackTrace();
            return new HashSet<>();
        }
    }

    private static boolean twoSum(int a, HashSet<Integer> set) {
        final var sum = Day1_2.sum - a;

        for (final var b : set) {
            if (b.equals(a)) {
                continue;
            }

            final var c = sum - b;

            if (set.contains(c)) {
                System.out.println(a * b * c);
                return true;
            }
        }

        return false;
    }
}
