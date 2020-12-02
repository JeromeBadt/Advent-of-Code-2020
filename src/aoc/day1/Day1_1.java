package aoc.day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class Day1_1 {
    private final static int sum = 2020;

    public static void main(String[] args) throws IOException {
        twoSum();
    }

    public static void twoSum() throws IOException {
        final var set = new HashSet<Integer>();

        final var br = new BufferedReader(new FileReader("input\\day1.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            final var a = Integer.parseInt(line);
            final var b = sum - a;

            if (set.contains(b)) {
                System.out.println(a * b);
                return;
            }

            set.add(a);
        }
    }
}