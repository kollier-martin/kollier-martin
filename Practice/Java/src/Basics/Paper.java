package io.beansprout.Basics;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Paper extends PaperComparator {
    private Type type;
    private String spacing;
    private Float margin;

    public void print() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return type + ": (Spacing: " + spacing + ", Margin: " + margin + ")";
    }

    enum Type {
        NOTEBOOK,
        CONSTRUCTION,
        COPY,
        PARCHMENT,
        SAND
    } // Could do separate classes, but this is just practice
}
