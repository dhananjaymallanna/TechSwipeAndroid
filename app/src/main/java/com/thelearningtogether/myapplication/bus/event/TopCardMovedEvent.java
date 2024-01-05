package com.thelearningtogether.myapplication.bus.event;

public class TopCardMovedEvent {


    private final float posX;
    public TopCardMovedEvent(float posX) {
        this.posX = posX;
    }
    public float getPosX() {
        return posX;
    }
}