package io.beansprout.Basics.Generics.Models;

public class House extends Building {
    int age = 10;

    @Override
    public String toString() {
        return "House {\n" +
                "  age: " + age + ",\n" +
                '}';
    }
}
