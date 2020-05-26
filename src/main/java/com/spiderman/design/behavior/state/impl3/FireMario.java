package com.spiderman.design.behavior.state.impl3;

import com.spiderman.design.behavior.state.State;

public class FireMario implements IMario {
    private static final FireMario instance = new FireMario();

    private FireMario() {
    }

    public static FireMario getInstance() {
        return instance;
    }
    @Override
    public State getName() {
        return State.FIRE;
    }

    @Override
    public void meetMonster(MarioStateMachine_2 stateMachine) {
        stateMachine.setCurrentState(SmallMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() - 300);
    }
}
