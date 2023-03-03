package Basics;

import java.util.Comparator;

public class PaperComparator implements Comparator<Paper> {
    @Override
    public int compare(Paper o1, Paper o2) {
        return o1.getMargin().compareTo(o2.getMargin());
    }
}
