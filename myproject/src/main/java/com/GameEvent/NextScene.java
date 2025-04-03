package com.GameEvent;

import javafx.event.Event;
import javafx.event.EventType;

public class NextScene extends Event{

    public static final EventType<NextScene> NEXTSCENE
    = new EventType<>(Event.ANY, "NextScene");

    public static final EventType<NextScene> SCENE2TO1
    = new EventType<>(Event.ANY, "Scene2to1");



     public NextScene(EventType<? extends Event> eventType) {
        super(eventType);
    }
    
}