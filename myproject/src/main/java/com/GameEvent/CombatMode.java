package com.GameEvent;

import com.Type.GameModeType;
import com.almasb.fxgl.dsl.FXGL;

import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.control.DialogEvent;

public class CombatMode extends Event{

        
    public static final EventType<CombatMode> REXCOMBATODE
    = new EventType<>(Event.ANY, "RexCombatMode");
   

        
        public CombatMode(EventType<? extends Event> eventType) {
            super(eventType);
        }



}
