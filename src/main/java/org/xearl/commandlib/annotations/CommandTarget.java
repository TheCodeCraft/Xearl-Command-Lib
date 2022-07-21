/*
 * Copyright (c) 2022.
 * XearlCommandLib
 * You are not allowed to copy this lib.
 * you are allowed to use this project in your project
 */

package org.xearl.commandlib.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface CommandTarget {

    String name();
    String description() default "no description";
    String[] aliases() default {""};

}