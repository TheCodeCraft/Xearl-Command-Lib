/*
 * Copyright (c) 2022.
 * XearlCommandLib
 * You are not allowed to copy this lib.
 * you are allowed to use this project in your project
 */

package org.xearl.commandlib.utils;

import org.xearl.commandlib.CommandBase;
import org.xearl.commandlib.annotations.CommandTarget;
import org.xearl.commandlib.managment.CommandManager;

import java.lang.reflect.Field;

public class CommandRegistration {

    public CommandRegistration(String pack, CommandManager manager) {
        final ReflectionUtil reflectionUtil = new ReflectionUtil();
        reflectionUtil.getTypesAnnotatedWith(pack, CommandTarget.class).forEach(clazz -> {
            try {
                manager.getLocalCommands().add((CommandBase) clazz.newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }

    public CommandRegistration(Class<?> clazz, CommandManager manager) throws InstantiationException, IllegalAccessException {
        final ReflectionUtil reflectionUtil = new ReflectionUtil();
        for (Field field : clazz.getFields()) {
            manager.getLocalCommands().add((CommandBase) field.getType().newInstance());
        }
    }

}
