package com.GameEvent;

import javafx.event.Event;
import javafx.event.EventType;

public class NextScene extends Event{

    public static final EventType<NextScene> NEXTSCENE
    = new EventType<>(Event.ANY, "NextScene");



     public NextScene(EventType<? extends Event> eventType) {
        super(eventType);
    }
    
}