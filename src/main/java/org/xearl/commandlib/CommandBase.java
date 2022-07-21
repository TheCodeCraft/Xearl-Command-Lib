/*
 * Copyright (c) 2022.
 * XearlCommandLib
 * You are not allowed to copy this lib.
 * you are allowed to use this project in your project
 */

package org.xearl.commandlib;

import lombok.Getter;
import org.xearl.commandlib.annotations.CommandTarget;
import org.xearl.commandlib.node.CommandNodeTree;

/**
 * Command base for every command
 */
@Getter
public abstract class CommandBase {

    private final String name, description;
    private final String[] aliases;

    /**
     * Only used for setting up commands
     */
    public CommandBase() {
        final CommandTarget targetAnnotation = this.getClass().getAnnotation(CommandTarget.class);
        this.name = targetAnnotation.name();
        this.description = targetAnnotation.description();
        this.aliases = targetAnnotation.aliases();
    }

    public abstract void execute(CommandNodeTree nodeTree);

}
