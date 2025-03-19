package com.project;
import com.badlogic.gdx.Game;
import com.Component.AnimationComponent;
import com.Component.ControllerComponent;
import com.Component.InteractComponent;
import com.Factory.BackgroundFactory;
import com.Factory.CharacterFactory;
import com.GameEvent.SystemEvent;
import com.Type.PlayerType;
import com.UI.StatusUI;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.level.Level;
import com.almasb.fxgl.entity.level.tiled.TMXLevelLoader;

import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.UserAction;
import com.almasb.fxgl.physics.PhysicsWorld;

import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.ApplicationListener;



import static com.almasb.fxgl.dsl.FXGL.*;

public class App extends GameApplication {

    private Entity player;
    private Entity Enemy;
    private Level map;
    private StatusUI statusUI;
    
    

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(1280);
        settings.setHeight(720);
        settings.setTitle("Final Journey");
        settings.setVersion("Alpha");
        settings.setFullScreenAllowed(true);
        settings.setFullScreenFromStart(true);
        settings.setDeveloperMenuEnabled(true);
    }

    @Override
    protected void initPhysics() {
        PhysicsWorld gamephysic = FXGL.getPhysicsWorld();  
        gamephysic.setGravity(0,0 );
    }

   

    //   private static Entity getPlayer() {
    //    return FXGL.getGameWorld().getSingleton(PlayerType.Hero);
    //  }
            
            
               
            
    @Override
    protected void initGameVars(Map<String, Object> vars) {

        vars.put("map1", "scene1.tmx");
        vars.put("Name", "Harold");
        vars.put("HP", 100);
        vars.put("Mana", 100);

        vars.put("Phase", "Exploration");
        
       
    }

   
 

    @Override
    protected void initGame() {
        
        getGameScene().setBackgroundColor(Color.BLACK); 
        FXGL.getGameWorld().addEntityFactory(new CharacterFactory());
        FXGL.getGameWorld().addEntityFactory(new BackgroundFactory());

       
        
        map = FXGL.getAssetLoader().loadLevel(FXGL.gets("map1"), new TMXLevelLoader());
        //FXGL.getGameWorld().setLevel(map);
        FXGL.setLevelFromMap("scene1.tmx");

        SystemEvent.combat();
        
        player = FXGL.getGameWorld().getEntitiesByType(PlayerType.Hero).get(0);
        
        FXGL.getGameScene().getViewport().bindToEntity(player,FXGL.getAppWidth()/2, FXGL.getAppHeight()/2);
        FXGL.getGameScene().getViewport().setZoom(1.5);
        int mapWidth = (int) map.getWidth();
        int mapHeight = (int) map.getHeight();

        FXGL.getGameScene().getViewport().setBounds(-10000/2, 0, mapWidth+150, mapHeight);
        FXGL.getGameScene().getViewport().setLazy(true);

       
        
    }

    
   

    @Override
    protected void initInput() {

       
        FXGL.getInput().addAction(new UserAction("Right") {
        @Override
        protected void onAction() {
            if (FXGL.gets("Phase") == "Exploration"){
            player.getComponent(ControllerComponent.class).moveRight();
            }
        }

        @Override
        protected void onActionEnd() {
            if (FXGL.gets("Phase") == "Exploration"){
            player.getComponent(ControllerComponent.class).stop();
            }
        }
        }, KeyCode.D);

        FXGL.getInput().addAction(new UserAction("Left") {
        @Override
        protected void onAction() {
            if(FXGL.gets("Phase") == "Exploration"){
                player.getComponent(ControllerComponent.class).moveLeft();
             }
            }

        @Override
        protected void onActionEnd() {
            if(FXGL.gets("Phase") == "Exploration"){
            player.getComponent(ControllerComponent.class).stop();
            }
        }
        }, KeyCode.A);

        FXGL.getInput().addAction(new UserAction("Up") {
        @Override
        protected void onAction() {
            if(FXGL.gets("Phase") == "Exploration"){
                player.getComponent(ControllerComponent.class).moveUp();
              }
            }

        @Override
        protected void onActionEnd() {
            if(FXGL.gets("Phase") == "Exploration"){
                player.getComponent(ControllerComponent.class).stop();
                }
            }
        }, KeyCode.W);

        FXGL.getInput().addAction(new UserAction("Down") {
            @Override
            protected void onAction() {
                if(FXGL.gets("Phase") == "Exploration"){
                player.getComponent(ControllerComponent.class).moveDown();
                }
            }

            @Override
            protected void onActionEnd() {
                if(FXGL.gets("Phase") == "Exploration"){
                player.getComponent(ControllerComponent.class).stop();
                }
            }
        }, KeyCode.S);

        
        FXGL.getInput().addAction(new UserAction("Interact") {
            @Override
            protected void onAction() {
                if(FXGL.gets("Phase") == "Exploration"){
                player.getComponent(InteractComponent.class).interact();
                }
            }
        }, KeyCode.E);
    
        

        
    }


    @Override
    protected void initUI() {
       
        statusUI = new StatusUI();
        FXGL.getGameScene().addUINode(statusUI.getVBox());
        
    }


}