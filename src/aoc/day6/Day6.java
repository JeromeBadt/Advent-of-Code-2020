package aoc.day6;

import aoc.util.Util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Day6 {
    public static void main(String[] args) throws IOException {
        parse1();
        parse2();
    }

    public static void parse1() throws IOException {
        final var input = Files.readString(Path.of("input\\day6.txt"));
        final var groups = input
                .replace("\n\n", ",")
                .replace("\n", "")
                .split(",");

        final var sum = Arrays.stream(groups).mapToLong(group -> group.chars().distinct().count()).sum();
        System.out.println(sum);
    }

    public static void parse2() throws IOException {
        final var input = Files.readString(Path.of("input\\day6.txt"));
        final var groups = input.strip().split("\n\n");

        final var sum = Arrays.stream(groups).mapToLong(group -> {
            final var peopleInGroup = Util.countOccurrences(group, '\n') + 1;
            final var groupStr = group.replace("\n", "");

            return groupStr.chars().distinct().filter(ch -> Util.countOccurrences(groupStr, (char) ch) == peopleInGroup).count();
        }).sum();

        System.out.println(sum);
    }
}
