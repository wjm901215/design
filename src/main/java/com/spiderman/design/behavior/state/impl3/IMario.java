package com.spiderman.design.behavior.state.impl3;

import com.spiderman.design.behavior.state.State;

/**
 * 所有状态类的接口
 */
public interface IMario {
    State getName();

    default void obtainMushRoom(MarioStateMachine_2 stateMachine) {
        //do nothing
    }

    default void obtainCape(MarioStateMachine_2 stateMachine) {
        //do nothing
    }

    default void obtainFireFlower(MarioStateMachine_2 stateMachine) {
        //do nothing
    }

    default void meetMonster(MarioStateMachine_2 stateMachine) {
        //do nothing
    }
}
