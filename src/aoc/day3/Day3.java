package aoc.day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Day3 {
    private static List<String> map;
    private static int mapWidth;

    public static void main(String[] args) throws IOException {
        traverse1();
        traverse2();
    }

    public static void traverse1() throws IOException {
        map = Files.readAllLines(Paths.get("input\\day3.txt"));
        mapWidth = map.get(0).length();

        final var result = new Slope(3, 1).traverse();

        System.out.println(result);
    }

    public static void traverse2() throws IOException {
        map = Files.readAllLines(Paths.get("input\\day3.txt"));
        mapWidth = map.get(0).length();

        final Slope[] slopes = {
                new Slope(1, 1),
                new Slope(3, 1),
                new Slope(5, 1),
                new Slope(7, 1),
                new Slope(1, 2)
        };

        final var result = Arrays
                .stream(slopes)
                .mapToLong(Slope::traverse)
                .reduce(1, (partialProduct, treeCount) -> partialProduct * treeCount);

        System.out.println(result);
    }

    private static class Slope {
        private final int right;
        private final int down;

        private Slope(final int right, final int down) {
            this.right = right;
            this.down = down;
        }

        private long traverse() {
            long treeCount = 0;

            for (int x = right, y = down; y < map.size(); y += down, x = (x + right) % mapWidth) {
                if (map.get(y).charAt(x) == '#') {
                    treeCount++;
                }
            }

            return treeCount;
        }
    }
}
