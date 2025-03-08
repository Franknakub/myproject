package com.GameEvent;

import com.almasb.fxgl.cutscene.Cutscene;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.level.Level;
import com.almasb.fxgl.entity.level.tiled.TMXLevelLoader;
import com.almasb.fxgl.event.EventBus;
import com.almasb.fxgl.texture.Texture;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SystemEvent {

    public static EventBus eventBus;
    public void combat(){

    eventBus = FXGL.getEventBus();
      eventBus.addEventHandler(CombatMode.REXCOMBATODE, event -> {
                
        
            Texture rexCombatScene = FXGL.getAssetLoader().loadTexture("assets/textures/testscenecombat.jpg");
             rexCombatScene.setFitWidth(FXGL.getAppWidth());
            rexCombatScene.setFitHeight(FXGL.getAppHeight());
            FXGL.getGameScene().addUINode(rexCombatScene);
               
                
            });




    
    }
}
