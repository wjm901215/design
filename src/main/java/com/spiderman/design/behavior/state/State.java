package com.spiderman.design.behavior.state;

/**
 * 状态枚举
 */
public enum State {
    SMALL(0), SUPER(1), CAPE(2), FIRE(3);
    private int value;

    State(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}