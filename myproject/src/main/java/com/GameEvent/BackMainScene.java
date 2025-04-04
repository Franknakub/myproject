package com.GameEvent;

import javafx.event.Event;
import javafx.event.EventType;

public class BackMainScene  extends Event{
    
    public static final EventType<BackMainScene> BACKTOMAINSCENE
    = new EventType<>(Event.ANY, "BackMainScene");

    public static final EventType<BackMainScene> BACKTOMAINSCENEIFWIN
    = new EventType<>(Event.ANY, "BackMainScene2");

    public static final EventType<BackMainScene> BACKTOMAINSCENEIFWIN2
    = new EventType<>(Event.ANY,"BackToMainScene2");

    public static final EventType<BackMainScene> BACKTOMAINSCENEIFWIN3
    = new EventType<>(Event.ANY,"BackToMainScene3");

    
    public BackMainScene(EventType<? extends Event> eventType) {
        super(eventType);
    }

}
