package com.spiderman.design.behavior.state;

import com.spiderman.design.behavior.state.impl1.MarioStateMachine;
import com.spiderman.design.behavior.state.impl2.MarioStateMachine_1;
import com.spiderman.design.behavior.state.impl3.MarioStateMachine_2;

/**
 * 状态模式调用
 */
public class ApplicationDemo {
    public static void main(String[] args) {
        //分支逻辑法
        MarioStateMachine mario = new MarioStateMachine();
        mario.obtainMushRoom();
        System.out.println("mario score: " + mario.getScore() + "; state: " + mario.getCurrentState());
        mario.obtainFireFlower();
        System.out.println("mario score: " + mario.getScore() + "; state: " + mario.getCurrentState());
        mario.meetMonster();
        System.out.println("mario score: " + mario.getScore() + "; state: " + mario.getCurrentState());
        System.out.println("-------------------------------");
        //查表法
        MarioStateMachine_1 mario_1 = new MarioStateMachine_1();
        mario_1.obtainMushRoom();
        System.out.println("mario_1 score: " + mario_1.getScore() + "; state: " + mario_1.getCurrentState());
        mario_1.obtainFireFlower();
        System.out.println("mario_1 score: " + mario_1.getScore() + "; state: " + mario_1.getCurrentState());
        mario_1.meetMonster();
        System.out.println("mario_1 score: " + mario_1.getScore() + "; state: " + mario_1.getCurrentState());
        System.out.println("-------------------------------");
        //状态模式
        MarioStateMachine_2 mario_2 = new MarioStateMachine_2();
        mario_2.obtainMushRoom();
        System.out.println("mario_2 score: " + mario_2.getScore() + "; state: " + mario_2.getCurrentState());
        mario_2.obtainFireFlower();
        System.out.println("mario_2 score: " + mario_2.getScore() + "; state: " + mario_2.getCurrentState());
        mario_2.meetMonster();
        System.out.println("mario_2 score: " + mario_2.getScore() + "; state: " + mario_2.getCurrentState());
    }
}