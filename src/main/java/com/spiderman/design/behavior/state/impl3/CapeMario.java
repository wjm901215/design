package com.spiderman.design.behavior.state.impl3;

import com.spiderman.design.behavior.state.State;

public class CapeMario implements IMario {
    private static final CapeMario instance = new CapeMario();

    private CapeMario() {
    }

    public static CapeMario getInstance() {
        return instance;
    }
    @Override
    public State getName() {
        return State.CAPE;
    }

    @Override
    public void meetMonster(MarioStateMachine_2 stateMachine) {
        stateMachine.setCurrentState(SmallMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() - 200);
    }
}
