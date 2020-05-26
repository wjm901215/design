package com.spiderman.design.behavior.state.impl1;

import com.spiderman.design.behavior.state.State;

/**
 * 状态机实现方式一：分支逻辑法
 */
public class MarioStateMachine {
    private int score;
    private State currentState;

    public MarioStateMachine() {
        this.score = 0;
        this.currentState = State.SMALL;
    }

    public void obtainMushRoom() {
        if (this.currentState == State.SMALL) {
            this.currentState = State.SUPER;
            this.score += 100;
        }
    }


    public void obtainCape() {
        if (this.currentState == State.SMALL||this.currentState == State.SUPER) {
            this.currentState=State.CAPE;
            this.score+=200;
        }
    }

    public void obtainFireFlower() {
        if (this.currentState == State.SMALL||this.currentState == State.SUPER) {
            this.currentState=State.FIRE;
            this.score+=300;
        }
    }

    public void meetMonster() {
        if (this.currentState == State.SUPER) {
            this.score-=100;
        }else if (this.currentState == State.CAPE) {
            this.score-=200;
        }else if (this.currentState == State.FIRE) {
            this.score-=300;
        }
        this.currentState=State.SMALL;
    }

    public int getScore() {
        return this.score;
    }

    public State getCurrentState() {
        return this.currentState;
    }
}

