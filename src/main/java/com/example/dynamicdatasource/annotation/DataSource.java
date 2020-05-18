package com.example.dynamicdatasource.annotation;

import java.lang.annotation.*;

@Target({ ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String name() default "";
}
