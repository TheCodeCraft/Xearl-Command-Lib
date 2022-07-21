package tests;
/*
 * Copyright (c) 2022.
 * XearlCommandLib
 * You are not allowed to copy this lib.
 * you are allowed to use this project in your project
 */

import org.xearl.commandlib.CommandBase;
import org.xearl.commandlib.annotations.CommandTarget;
import org.xearl.commandlib.node.CommandNode;
import org.xearl.commandlib.node.CommandNodeTree;

@CommandTarget(name = "Test", description = "Sus", aliases = {"sUSaL"})
public class TestCommand extends CommandBase {

    @Override
    public void execute(CommandNodeTree nodeTree) {
        nodeTree.getNode(0).createProcessor(node -> {
            System.out.println(node.getContentString());
        });
    }
}
