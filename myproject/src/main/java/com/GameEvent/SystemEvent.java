package com.GameEvent;

import java.util.List;

import com.Factory.BackgroundFactory;
import com.Factory.CharacterFactory;
import com.Factory.CombatWithRexFactory;
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
import javafx.scene.paint.Color;

public class SystemEvent {

    public static EventBus eventBus;

    Entity camera;
    public static void combat() {


      eventBus = FXGL.getEventBus();

      
      eventBus.addEventHandler(CombatScene.REXCOMBATODE, event -> {

         
            
            FXGL.getGameWorld().addEntityFactory(new CombatWithRexFactory());
            FXGL.setLevelFromMap("battle1.tmx");

            List<Entity> cameras = FXGL.getGameWorld().getEntitiesByType(PlayerType.Camera);
            Entity Camera = cameras.get(0);
            FXGL.getGameScene().getViewport().bindToEntity(Camera, FXGL.getAppWidth() /2, FXGL.getAppHeight() /2);
            FXGL.getGameScene().getViewport().setZoom(0.75/1.05);

            FXGL.set("Rex", "battle1.tmx");
            Level map = FXGL.getAssetLoader().loadLevel(FXGL.gets("Rex"), new TMXLevelLoader());
            int mapWidth = (int) map.getWidth();
            int mapHeight = (int) map.getHeight();
            FXGL.getGameScene().getViewport().setBounds(0, 0, mapWidth, mapHeight);
            FXGL.getGameScene().setBackgroundColor(Color.BLACK);
      });
     
  }
}
