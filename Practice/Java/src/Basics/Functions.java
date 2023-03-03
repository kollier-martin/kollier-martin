package Basics;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Functions {
    public static void main(String[] args) {
        List<Paper> paperList = new ArrayList<>() {
            {
                add(new Paper(Paper.Type.NOTEBOOK, "Wide Rule", 0.05F));
                add(new Paper(Paper.Type.NOTEBOOK, "College Rule", 0.10F));
                add(new Paper(Paper.Type.CONSTRUCTION, "Blank", 0.00F));
            }
        };

        //region Supplier
        System.out.println("====== Enter Supplier ======");
        for (Paper p : paperList) {
            print(() -> p);
        }
        System.out.println("====== Exiting Supplier ======\n");
        //endregion

        //region Consumer
        System.out.println("====== Enter Consumer ======");
        log(paperList, System.out::println);
        System.out.println("====== Exiting Consumer ======\n");
        //endregion

        //region Predicate
        System.out.println("====== Enter Predicate ======");
        System.out.println("Notebook Paper:");
        evaluate(paperList, (n) -> n.getType().equals(Paper.Type.NOTEBOOK));

        System.out.println();

        System.out.println("Construction Paper:");
        evaluate(paperList, (n) -> n.getType().equals(Paper.Type.CONSTRUCTION));
        System.out.println("====== Exit Predicate ======\n");
        //endregion

        //region Function
        System.out.println("====== Enter Function ======");
        for (Paper p : paperList) {
            double calculation = calculate(p.getMargin(), currentInt -> currentInt * 5.10);
            System.out.println("Previous Value: " + p.getMargin() + ", After Value: " + calculation);
        }
        System.out.println("====== Exiting Function ======");
        //endregion
    }

    public static void print(Supplier<? extends Paper> supplier) {
        supplier.get().print();
    }

    public static void log(List<Paper> strList, Consumer<Paper> consumer) {
        for (Paper s : strList) {
            consumer.accept(s);
        }
    }

    public static void evaluate(List<Paper> list, Predicate<Paper> predicate) {
        for (Paper p : list) {
            if (predicate.test(p)) {
                System.out.println("\t" + p);
            }
        }
    }

    public static double calculate(Float e, Function<Float, Double> func) {
        return func.apply(e);
    }
}
