/*
 * Copyright (c) 2022.
 * XearlCommandLib
 * You are not allowed to copy this lib.
 * you are allowed to use this project in your project
 */

package org.xearl.commandlib.node;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommandNode {

    private final int index;

    private final String content;

    private NodeProcessor processor;

    public void createProcessor(NodeProcessor processor) {
        this.processor = processor;
        processor.process(this);
    }

    public double getContentDouble() {
        return Double.parseDouble(content);
    }

    public int getContentInteger() {
        return Integer.parseInt(content);
    }

    public float getContentFloat() {
        return Float.parseFloat(content);
    }

    public boolean getContentBoolean() {
        return Boolean.getBoolean(content);
    }

    public char[] getContentCharArray() {
        return content.toCharArray();
    }

    public int getIndex() {
        return index;
    }

    public String getContentString() {
        return content;
    }

    public NodeProcessor getProcessor() {
        return processor;
    }
}
