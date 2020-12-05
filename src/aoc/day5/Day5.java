package aoc.day5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.IntStream;

public class Day5 {
    public static void main(String[] args) throws IOException {
        parse1();
        parse2();
    }

    public static void parse1() throws IOException {
        seatIdStream().max().ifPresent(System.out::println);
    }

    public static void parse2() throws IOException {
        final var seatIds = seatIdStream().sorted().toArray();

        for (var i = 0; i < seatIds.length - 1; i++) {
            final var seat = seatIds[i] + 1;
            if (seatIds[i + 1] != seat) {
                System.out.println(seat);
                return;
            }
        }
    }

    private static IntStream seatIdStream() throws IOException {
        final var lines = Files.lines(Paths.get("input\\day5.txt"));
        return lines.mapToInt(line -> {
            final var binaryLine = line.replaceAll("[FL]", "0").replaceAll("[BR]", "1");
            final var row = Integer.parseInt(binaryLine.substring(0, 7), 2);
            final var column = Integer.parseInt(binaryLine.substring(7), 2);

            return row * 8 + column;
        });
    }
}
