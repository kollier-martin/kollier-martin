package io.beansprout.Basics;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Repeatables {
    @Repeatable(value = Authors.class)
    @Retention(RetentionPolicy.RUNTIME)
    @interface Author {
        String name();

        String method();

        String date();

        String modifyReason();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @interface Authors {
        Author[] value();
    }
}
