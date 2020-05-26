package com.spiderman.design.behavior.state.impl3;

import com.spiderman.design.behavior.state.State;

public class SmallMario implements IMario {
    private static final SmallMario instance = new SmallMario();

    private SmallMario() {
    }

    public static SmallMario getInstance() {
        return instance;
    }

    @Override
    public State getName() {
        return State.SMALL;
    }

    @Override
    public void obtainMushRoom(MarioStateMachine_2 stateMachine) {
        stateMachine.setCurrentState(SuperMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() + 100);
    }

    @Override
    public void obtainCape(MarioStateMachine_2 stateMachine) {
        stateMachine.setCurrentState(CapeMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() + 200);
    }

    @Override
    public void obtainFireFlower(MarioStateMachine_2 stateMachine) {
        stateMachine.setCurrentState(FireMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() + 300);
    }

}