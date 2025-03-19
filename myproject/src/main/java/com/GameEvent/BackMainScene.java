package com.GameEvent;

import javafx.event.Event;
import javafx.event.EventType;

public class BackMainScene  extends Event{
    
    public static final EventType<BackMainScene> BACKTOMAINSCENE
    = new EventType<>(Event.ANY, "BackMainScene");



    
    public BackMainScene(EventType<? extends Event> eventType) {
        super(eventType);
    }

}
