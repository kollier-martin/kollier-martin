package Basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        List<Paper> paperList = new ArrayList<>();
        paperList.add(new Paper(Paper.Type.NOTEBOOK, "Wide Rule", 0.05F));
        paperList.add(new Paper(Paper.Type.NOTEBOOK, "College Rule", 0.10F));
        paperList.add(new Paper(Paper.Type.CONSTRUCTION, "Blank", 0.00F));

        wholeNumbers(100);
        paperStream(paperList);
        numStream();
    }

    public static void paperStream(List<Paper> paperList) {
        System.out.println("All paper with a margin greater than 0.04");
        paperList
                .parallelStream()
                .filter(type -> type.getMargin() > 0.04F)
                .forEach(System.out::println);

        System.out.println();

        System.out.println("Sorted by margin");
        paperList
                .parallelStream()
                .sorted((p1, p2) -> p1.compare(p1, p2))
                .forEachOrdered(System.out::println);

        System.out.println();
    }

    public static void numStream() {
        int[] numbers = {12, 21, 32, 45, 52, 63};

        Arrays.stream(numbers)
                .filter(n -> n % 3 == 0) // Any number divisible by 3
                .map(n -> ++n) // Add one to above
                .filter(n -> n % 8 == 0) // Any number divisible by 8 after map
                .forEach(System.out::println);
    }

    public static void wholeNumbers(int i) {
        System.out.print("Sum of the first " + i + " numbers: ");
        Stream.iterate(0, n -> n + 1)
                .limit(++i)
                .reduce(Integer::sum)
                .ifPresent(System.out::println);
    }
}
