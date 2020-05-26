package com.spiderman.design.behavior.state.impl2;

import com.spiderman.design.behavior.state.State;

/**
 * 状态机实现方式二：查表法
 */
public class MarioStateMachine_1 {
    private int score;
    private State currentState;

    public MarioStateMachine_1() {
        this.score = 0;
        this.currentState = State.SMALL;
    }

    private static final State[][] transitionTable = {
            {State.SUPER, State.CAPE, State.FIRE, State.SMALL},
            {State.SUPER, State.CAPE, State.FIRE, State.SMALL},
            {State.CAPE, State.CAPE, State.CAPE, State.SMALL},
            {State.FIRE, State.FIRE, State.FIRE, State.SMALL}};
    private static final int[][] actionTable = {
            {+100, +200, +300, +0},
            {+0, +200, +300, -100},
            {+0, +0, +0, -200},
            {+0, +0, +0, -300}};

    public void obtainMushRoom() {
        executeEvent(Event.GOT_MUSHROOM);
    }


    public void obtainCape() {
        executeEvent(Event.GOT_CAPE);
    }

    public void obtainFireFlower() {
        executeEvent(Event.GOT_FIRE);
    }

    public void meetMonster() {
        executeEvent(Event.MET_MONSTER);
    }

    private void executeEvent(Event event) {
        int stateValue = currentState.getValue();
        int eventValue = event.getValue();
        this.currentState = transitionTable[stateValue][eventValue];
        this.score += actionTable[stateValue][eventValue];
    }

    public int getScore() {
        return this.score;
    }

    public State getCurrentState() {
        return this.currentState;
    }
}

