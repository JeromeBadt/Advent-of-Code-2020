package aoc.day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static aoc.util.Util.countOccurrences;

public class Day2 {
    public static void main(String[] args) throws IOException {
        parse1();
        parse2();
    }

    public static void parse1() throws IOException {
        final var lines = Files.lines(Paths.get("input\\day2.txt"));
        final var validCount = lines.filter(Line::isValid1).count();

        System.out.println(validCount);
    }

    public static void parse2() throws IOException {
        final var lines = Files.lines(Paths.get("input\\day2.txt"));
        final var validCount = lines.filter(Line::isValid2).count();

        System.out.println(validCount);
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

        private static boolean isValid1(final String line) {
            parse(line);
            final var occurrences = countOccurrences(password, character);

            return occurrences >= min && occurrences <= max;
        }

        private static boolean isValid2(final String line) {
            parse(line);

            return password.charAt(min - 1) == character ^ password.charAt(max - 1) == character;
        }
    }
}
