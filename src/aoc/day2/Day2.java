package aoc.day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day2 {
    public static void main(String[] args) throws IOException {
        parse1();
        parse2();
    }

    public static void parse1() throws IOException {
        final var lines = Files.lines(Paths.get("input\\day2.txt"));
        final var validCount = lines.mapToLong(Line::isValid1).sum();

        System.out.println(validCount);
    }

    public static void parse2() throws IOException {
        final var lines = Files.lines(Paths.get("input\\day2.txt"));
        final var validCount = lines.mapToLong(Line::isValid2).sum();

        System.out.println(validCount);
    }

    private static int countOccurrences(final String str, final char searchChar) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == searchChar) {
                count++;
            }
        }

        return count;
    }

    private static class Line {
        private static int min;
        private static int max;
        private static char character;
        private static String password;

        private static void parse(final String line) {
            var split = line.split("-");
            min = Integer.parseInt(split[0]);
            split = split[1].split(" ");
            max = Integer.parseInt(split[0]);
            character = split[1].charAt(0);
            password = split[2];
        }

        private static long isValid1(final String line) {
            parse(line);
            final var occurrences = countOccurrences(password, character);

            return occurrences >= min && occurrences <= max
                    ? 1L
                    : 0L;
        }

        private static long isValid2(final String line) {
            parse(line);

            return password.charAt(min - 1) == character ^ password.charAt(max - 1) == character
                    ? 1L
                    : 0L;
        }
    }
}
