package tests;
/*
 * Copyright (c) 2022.
 * XearlCommandLib
 * You are not allowed to copy this lib.
 * you are allowed to use this project in your project
 */

import org.xearl.commandlib.managment.CommandManager;

public class TestApp {

    public static void main(String[] args) {
        final CommandManager commandManager = new CommandManager(" ");
        commandManager.getLocalCommands().add(new TestCommand());
        commandManager.execute("Test console");
    }

}
