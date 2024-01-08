package org.example.entity;

public class Snake implements SpecialEnity{

    private int toPosition;

    private int fromPosition;

    public Snake(int toPosition, int fromPosition) {
        this.toPosition = toPosition;
        this.fromPosition = fromPosition;
    }

    @Override
    public int toPosition() {
        return toPosition;
    }

    @Override
    public int fromPosition() {
        return fromPosition;
    }
}
