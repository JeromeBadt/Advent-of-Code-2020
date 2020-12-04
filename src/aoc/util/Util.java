package aoc.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
    public static int countOccurrences(final String str, final char searchChar) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == searchChar) {
                count++;
            }
        }

        return count;
    }

    public static String regexExtract(final String str, final String regex) {
        final var p = Pattern.compile(regex);
        Matcher m = p.matcher(str);

        if (m.find()) {
            return m.group(1);
        }

        return null;
    }
}
