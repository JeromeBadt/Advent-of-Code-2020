package aoc.day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.Predicate;

import static aoc.util.Util.regexExtract;

public class Day4_2 {
    public static void main(String[] args) throws IOException {
        validatePassports();
    }

    public static void validatePassports() throws IOException {
        var lines = getPassports();
        var validPassports = Arrays.stream(lines).filter(Passport::validate).count();

        System.out.println(validPassports);
    }

    private static String[] getPassports() throws IOException {
        var input = Files.readAllLines(Paths.get("input\\day4.txt"));
        return input.stream()
                .reduce("", (passports, line) -> line.length() > 0 ? passports + line + " " : passports + ",")
                .split(",");
    }


    private static class Record {
        final String matcher;
        final Predicate<String> validator;

        private Record(final String matcher, final Predicate<String> validator) {
            this.matcher = matcher;
            this.validator = validator;
        }

        private boolean validate(final String line) {
            var record = regexExtract(line, matcher);

            if (record == null) {
                return false;
            }

            return validator.test(record);
        }
    }

    private static class Passport {
        private static boolean validate(final String line) {
            Record[] records = {
                    new Record("byr:(\\d{4})\\b", e -> {
                        final var byr = Integer.parseInt(e);
                        return byr >= 1920 && byr <= 2002;
                    }),
                    new Record("iyr:(\\d{4})\\b", e -> {
                        final var iyr = Integer.parseInt(e);
                        return iyr >= 2010 && iyr <= 2020;
                    }),
                    new Record("eyr:(\\d{4})\\b", e -> {
                        final var eyr = Integer.parseInt(e);
                        return eyr >= 2020 && eyr <= 2030;
                    }),
                    new Record("hgt:((\\d{3}cm)|(\\d{2}in))\\b", e -> {
                        final var height = Integer.parseInt(e.substring(0, e.length() - 2));
                        return e.endsWith("cm")
                                ? height >= 150 && height <= 193
                                : height >= 59 && height <= 76;
                    }),
                    new Record("hcl:(#[0-9a-f]{6})\\b", e -> true),
                    new Record("ecl:(amb|blu|brn|gry|grn|hzl|oth)\\b", e -> true),
                    new Record("pid:([0-9]{9})\\b", e -> true)
            };

            return Arrays.stream(records).allMatch(record -> record.validate(line));
        }
    }
}
