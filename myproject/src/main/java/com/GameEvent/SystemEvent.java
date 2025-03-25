package com.GameEvent;

import java.util.List;

import com.Factory.BackgroundFactory;
import com.Factory.CharacterFactory;
import com.Factory.CombatWithRexFactory;
import com.Type.PlayerType;
import com.UI.ActionButtonUI;
import com.almasb.fxgl.cutscene.Cutscene;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.action.Action;
import com.almasb.fxgl.entity.level.Level;
import com.almasb.fxgl.entity.level.tiled.TMXLevelLoader;
import com.almasb.fxgl.event.EventBus;
import com.almasb.fxgl.texture.Texture;
import com.project.App;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class SystemEvent {

    public static EventBus eventBus;
    private static Entity camera;
    private static Entity player;
    private static ActionButtonUI actionButtonUI = null;
    
            public static void combat() {
        
              eventBus = FXGL.getEventBus();
                
              eventBus.addEventHandler(CombatScene.REXCOMBATMODE, event -> {
        
                  FXGL.set("Phase", false);
                 
                  FXGL.getGameWorld().addEntityFactory(new CombatWithRexFactory());
                  FXGL.setLevelFromMap("battle1.tmx");
        
                  camera = FXGL.getGameWorld().getEntitiesByType(PlayerType.Camera).get(0);
    
                  FXGL.getGameScene().getViewport().unbind();
                  FXGL.getGameScene().getViewport().bindToEntity(camera, FXGL.getAppWidth() /2, FXGL.getAppHeight() /2);
                  FXGL.getGameScene().getViewport().setZoom(0.75/1.05);
    
                  FXGL.set("Rex", "battle1.tmx");
                  Level map = FXGL.getAssetLoader().loadLevel(FXGL.gets("Rex"), new TMXLevelLoader());
                  int mapWidth = (int) map.getWidth();
                  int mapHeight = (int) map.getHeight();
                  FXGL.getGameScene().getViewport().setBounds(0, 0, mapWidth, mapHeight);
                  FXGL.getGameScene().setBackgroundColor(Color.BLACK);
                  actionButtonUI = new ActionButtonUI();
                  FXGL.getGameScene().addUINode(actionButtonUI.getHBox());
    
          });
    
          eventBus.addEventHandler(BackMainScene.BACKTOMAINSCENE, event-> {
              FXGL.set("Phase", true);
           
              FXGL.setLevelFromMap("scene1.tmx");
    
              Level map = FXGL.getAssetLoader().loadLevel(FXGL.gets("map1"), new TMXLevelLoader());
              FXGL.getGameScene().setBackgroundColor(Color.BLACK);
    
              Entity newPlayer = FXGL.getGameWorld().getEntitiesByType(PlayerType.Hero).get(0);
                      
              App.setPlayer(newPlayer);
              FXGL.getGameScene().getViewport().unbind();
              FXGL.getGameScene().getViewport().bindToEntity(newPlayer,FXGL.getAppWidth()/2, FXGL.getAppHeight()/2);
              FXGL.getGameScene().getViewport().setZoom(1.5);
              int mapWidth = (int) map.getWidth();
              int mapHeight = (int) map.getHeight();
      
              FXGL.getGameScene().getViewport().setBounds(-10000/2, 0, mapWidth+150, mapHeight);
              FXGL.getGameScene().getViewport().setLazy(true);
      
              if (actionButtonUI != null) {
                actionButtonUI.remove();
                actionButtonUI = null;
            }
             
          
       
  
          
      });

      


     
  }
}
