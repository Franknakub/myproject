package com.GameEvent;

import com.Type.GameModeType;
import com.almasb.fxgl.dsl.FXGL;

import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.control.DialogEvent;

public class CombatScene extends Event{

        
    public static final EventType<CombatScene> REXCOMBATMODE
    = new EventType<>(Event.ANY, "RexCombatMode");

    public static final EventType<CombatScene> DREGANMALRIK
    = new EventType<>(Event.ANY, "DREGANMALRIK");

    public static final EventType<CombatScene> FINALJOURNEY
    = new EventType<>(Event.ANY,"FINALJOURNEY");

    
   

        
        public CombatScene(EventType<? extends Event> eventType) {
            super(eventType);
        }



}
