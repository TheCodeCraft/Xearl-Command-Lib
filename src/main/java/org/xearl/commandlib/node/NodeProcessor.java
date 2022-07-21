/*
 * Copyright (c) 2022.
 * XearlCommandLib
 * You are not allowed to copy this lib.
 * you are allowed to use this project in your project
 */

package org.xearl.commandlib.node;

/**
 * Needed for processing nodes
 */
@FunctionalInterface
public interface NodeProcessor {

    void process(CommandNode node);

}