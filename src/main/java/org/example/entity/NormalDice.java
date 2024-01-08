package org.example.entity;

public class NormalDice implements Dice{
    @Override
    public int nextPosition() {
        return (int) (Math.random() * 6) + 1;
    }

    @Override
    public String diceType() {
        return "Normal Dice";
    }
}
