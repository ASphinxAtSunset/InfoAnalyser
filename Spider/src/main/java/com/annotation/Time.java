package com.annotation;

import java.lang.annotation.*;

/**
 * Created by Gene on 2017/11/9.
 */
@Target(ElementType.METHOD)
public @interface Time {
    String value() default "";
}
