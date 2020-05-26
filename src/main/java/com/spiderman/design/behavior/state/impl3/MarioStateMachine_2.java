package com.spiderman.design.behavior.state.impl3;

import com.spiderman.design.behavior.state.State;

/**
 * 状态模式
 */
public class MarioStateMachine_2 {
    private int score;
    /**
     * 不再使用枚举来表示状态
     */
    private IMario currentState;

    public MarioStateMachine_2() {
        this.score = 0;
        this.currentState = SmallMario.getInstance();
    }

    public void obtainMushRoom() {
        this.currentState.obtainMushRoom(this);
    }

    public void obtainCape() {
        this.currentState.obtainCape(this);
    }

    public void obtainFireFlower() {
        this.currentState.obtainFireFlower(this);
    }

    public void meetMonster() {
        this.currentState.meetMonster(this);
    }

    public int getScore() {
        return this.score;
    }

    public State getCurrentState() {
        return this.currentState.getName();
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setCurrentState(IMario currentState) {
        this.currentState = currentState;
    }
}