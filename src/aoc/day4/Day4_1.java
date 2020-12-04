package aoc.day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Day4_1 {
    public static void main(String[] args) throws IOException {
        validatePassports();
    }

    public static void validatePassports() throws IOException {
        var lines = getPassports();
        var validPassports = Arrays.stream(lines).filter(Passport::validate1).count();

        System.out.println(validPassports);
    }

    private static String[] getPassports() throws IOException {
        var input = Files.readAllLines(Paths.get("input\\day4.txt"));
        return input.stream()
                .reduce("", (passports, line) -> line.length() > 0 ? passports + line + " " : passports + ",")
                .split(",");
    }

    private static class Passport {
        private static boolean validate1(final String line) {
            final var birthYear = line.contains("byr");
            final var issueYear = line.contains("iyr");
            final var expirationYear = line.contains("eyr");
            final var height = line.contains("hgt");
            final var hairColor = line.contains("hcl");
            final var eyeColor = line.contains("ecl");
            final var passportId = line.contains("pid");

            return birthYear && issueYear && expirationYear && height && hairColor && eyeColor && passportId;
        }
    }
}
