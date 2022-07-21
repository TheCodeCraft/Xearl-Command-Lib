/*
 * Copyright (c) 2022.
 * XearlCommandLib
 * You are not allowed to copy this lib.
 * you are allowed to use this project in your project
 */

package org.xearl.commandlib.managment;

import lombok.Getter;
import org.xearl.commandlib.CommandBase;
import org.xearl.commandlib.node.*;

import java.util.*;
import java.util.stream.Collectors;

@Getter
public class CommandManager {

    private final List<CommandBase> localCommands;

    private final String separator;

    public CommandManager(String separator) {
        this.localCommands = new ArrayList<>();
        this.separator = separator;
    }

    /**
     * to execute a command
     * @param name the command
     */
    public void execute(String name) {
        String[] strArgs = name.split(this.separator);
        final CommandBase base = getCommandFromName(strArgs[0]);
        String[] argsToExecute = Arrays.copyOfRange(strArgs, 1, strArgs.length);
        if (validateCommand(base)) {
            final CommandNodeTree nodeTree = new CommandNodeTree();
            int index = 0;
            for (String arg : argsToExecute) {
                nodeTree.getNodes().add(new CommandNode(index, arg));
                index++;
            }

            base.execute(nodeTree);
        }
    }

    public boolean validateCommand(CommandBase command) {
        if (command == null) {
            return false;
        }
        return !isStringEmptyOrNull(command.getName());
    }

    private boolean isStringEmptyOrNull(String s) {
        return s.equals("") || s == null;
    }

    /**
     * the name says.. you can use it in your minecraft chat... :I
     * @param str the current typed string
     * @return the list
     */
    public List<String> getCompletions(String str) {
        return this.getLocalCommands().stream().filter(this::validateCommand).map(CommandBase::getName).filter(name -> name.startsWith(str.substring(1))).collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Find a Command by only the Class.
     * @param clazz the class
     * @return founded BaseCommand
     */
    public CommandBase getCommandFromClass(Class<? extends CommandBase> clazz) {
        return this.getLocalCommands().stream().filter(command -> command.getClass().equals(clazz)).findFirst().orElse(null);
    }

    /**
     * Find a Command by only the name in equalsIgnoreCase.
     * @param name the class
     * @return founded BaseCommand
     */
    public CommandBase getCommandFromName(String name) {
        return this.getLocalCommands().stream().filter(command -> command.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

}
