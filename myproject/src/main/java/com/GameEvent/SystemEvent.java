package com.GameEvent;

import java.util.List;

import com.Type.PlayerType;
import com.almasb.fxgl.cutscene.Cutscene;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.level.Level;
import com.almasb.fxgl.entity.level.tiled.TMXLevelLoader;
import com.almasb.fxgl.event.EventBus;
import com.almasb.fxgl.texture.Texture;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SystemEvent {

    public EventBus eventBus;

    Entity camera ;
    public void combat() {

      
      camera = FXGL.spawn("setcamera");
      
      eventBus = FXGL.getEventBus();
      
      // Register the event handler first
      //eventBus.addEventHandler(CombatMode.REXCOMBATODE, event -> {
          FXGL.set("scenecombat1", "battle1.tmx");       
          Level rexCombat = FXGL.getAssetLoader().loadLevel(FXGL.gets("scenecombat1"), new TMXLevelLoader());
          FXGL.getGameWorld().setLevel(rexCombat);
          FXGL.getGameScene().getViewport().bindToEntity(camera, FXGL.getAppWidth() / 2, FXGL.getAppHeight() / 2);
      //});
      
      // Get the camera entity from the game world
      
      
      // Fire the combat mode event after handler registration
      eventBus.fireEvent(new CombatMode(CombatMode.REXCOMBATODE));
  }
}
