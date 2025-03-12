package com.GameEvent;

import com.Type.GameModeType;
import com.almasb.fxgl.dsl.FXGL;

import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.control.DialogEvent;

public class CombatScene extends Event{

        
    public static final EventType<CombatScene> REXCOMBATODE
    = new EventType<>(Event.ANY, "RexCombatMode");
   

        
        public CombatScene(EventType<? extends Event> eventType) {
            super(eventType);
        }



}
