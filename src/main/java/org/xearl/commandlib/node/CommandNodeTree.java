/*
 * Copyright (c) 2022.
 * XearlCommandLib
 * You are not allowed to copy this lib.
 * you are allowed to use this project in your project
 */

package org.xearl.commandlib.node;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CommandNodeTree {

    private final List<CommandNode> nodes = new ArrayList<>();

    public CommandNode getNode(int index) {
        return nodes.stream().filter(argument -> argument.getIndex() == index).findFirst().orElse(new EmptyNode(index, "EmptyNode"));
    }

    public CommandNode[] getNodesArray() {
        return (CommandNode[]) nodes.toArray();
    }

}
