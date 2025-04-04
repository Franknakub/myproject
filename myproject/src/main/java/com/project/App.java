package com.project;
import com.badlogic.gdx.Game;
import com.Component.SpawnComponent;
import com.Component.CharecterHero.AnimationComponent;
import com.Component.CharecterHero.ControllerComponent;
import com.Component.CharecterHero.InteractComponent;
import com.Factory.FactoryInCombat.CombatWithDM;
import com.Factory.FactoryInCombat.CombatWithRexFactory;
import com.Factory.FactoryInCombat.FinalJourney;
import com.Factory.FactoryInMain.BackgroundScene1Factory;
import com.Factory.FactoryInMain.BackgroundScene2Factory;
import com.Factory.FactoryInMain.BackgroundScene3Factory;
import com.Factory.FactoryInMain.CharacterFactory;
import com.Factory.FactoryInMain.CharacterScene2Factory;
import com.Factory.FactoryInMain.CharacterScene3Factory;
import com.GameEvent.CombatScene;
import com.GameEvent.SystemEvent;
import com.Physics.PlayerCollisionHandler;
import com.Physics.PlayerCollisionHandler2;
import com.Physics.PlayerCollisionHandler3;
import com.Physics.PlayerCollisionHandler4;
import com.Type.SceneType;
import com.Type.Player.PlayerType;
import com.UI.StatusUI;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.app.MenuItem;
import com.almasb.fxgl.core.serialization.Bundle;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.level.Level;
import com.almasb.fxgl.entity.level.tiled.TMXLevelLoader;

import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.UserAction;
import com.almasb.fxgl.physics.CollisionHandler;
import com.almasb.fxgl.physics.PhysicsWorld;
import com.almasb.fxgl.profile.DataFile;
import com.almasb.fxgl.profile.SaveLoadHandler;

import javafx.geometry.Point2D;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.w3c.dom.CharacterData;

import static com.almasb.fxgl.dsl.FXGL.*;

public class App extends GameApplication {

    private Entity player;
    private Entity Enemy;
    private Level map;
    private StatusUI statusUI;
    private static App instance;
    double lastX;
    double lastY;
    private boolean isLoadedGame = false;

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
        settings.setMainMenuEnabled(true);
        settings.setEnabledMenuItems(EnumSet.allOf(MenuItem.class));
    }

    @Override
    protected void onPreInit() {
        getSaveLoadService().addHandler(new SaveLoadHandler() {
            
            @Override
            public void onSave(DataFile data) {

    FXGL.set("isLoadedGame", true);
    player = FXGL.getGameWorld().getEntitiesByType(PlayerType.Hero).get(0);

    FXGL.set("lastPlayerX", player.getX());
    FXGL.set("lastPlayerY", player.getY());

    var bundle = new Bundle("gameData");

    bundle.put("Name", FXGL.gets("Name"));
    bundle.put("HP", FXGL.geti("HP"));
    bundle.put("Mana", FXGL.geti("Mana"));
    bundle.put("maxHP", FXGL.geti("maxHP"));
    bundle.put("maxMana", FXGL.geti("maxMana"));

    bundle.put("Namem", FXGL.gets("Namem"));
    bundle.put("HPm", FXGL.geti("HPm"));
    bundle.put("Manam", FXGL.geti("Manam"));
    bundle.put("Phasem", FXGL.getb("Phasem"));
    bundle.put("maxHPm", FXGL.geti("maxHPm"));
    bundle.put("maxManam", FXGL.geti("maxManam"));

    bundle.put("lastPlayerX", FXGL.getd("lastPlayerX"));
    bundle.put("lastPlayerY", FXGL.getd("lastPlayerY"));

    bundle.put("scene", FXGL.geti("scene"));
    bundle.put("Nah", FXGL.getb("Nah"));

    bundle.put("Checkd2", FXGL.getb("Checkd2"));
    bundle.put("Checkd3", FXGL.getb("Checkd3"));

    bundle.put("isLoadedGame", FXGL.getb("isLoadedGame"));
    System.out.println("isLoadedGame: " + FXGL.getb("isLoadedGame"));

    data.putBundle(bundle);
            }

    @Override
    public void onLoad(DataFile data) {

        
       
        // Retrieve the bundle from the data file
        var bundle = data.getBundle("gameData");

        FXGL.set("Name", bundle.get("Name"));
        FXGL.set("HP", bundle.get("HP"));
        FXGL.set("Mana", bundle.get("Mana"));
        FXGL.set("maxHP", bundle.get("maxHP"));
        FXGL.set("maxMana", bundle.get("maxMana"));
    
        FXGL.set("Namem", bundle.get("Namem"));
        FXGL.set("HPm", bundle.get("HPm"));
        FXGL.set("Manam", bundle.get("Manam"));
        FXGL.set("Phasem", bundle.get("Phasem"));
        FXGL.set("maxHPm",bundle.get("maxHPm"));
        FXGL.set("maxManam", bundle.get("maxManam"));
    
        FXGL.set("lastPlayerX", bundle.get("lastPlayerX"));
        FXGL.set("lastPlayerY", bundle.get("lastPlayerY"));
    
        FXGL.set("scene", bundle.get("scene"));
        FXGL.set("Nah", bundle.get("Nah"));
    
        FXGL.set("Checkd2",bundle.get("Checkd2"));
        FXGL.set("Checkd3", bundle.get("Checkd3"));
    
        FXGL.set("isLoadedGame", bundle.get("isLoadedGame"));
   
    }
        });
    }

        @Override
        protected void initPhysics() {
            PhysicsWorld physics = FXGL.getPhysicsWorld();
            physics.setGravity(0, 0);
            physics.addCollisionHandler(new PlayerCollisionHandler(PlayerType.Hero,SceneType.Scene1to2));
            physics.addCollisionHandler(new PlayerCollisionHandler2(PlayerType.Hero,SceneType.Scene2to1));
            physics.addCollisionHandler(new PlayerCollisionHandler3(PlayerType.Hero,SceneType.Scene2to3));
            physics.addCollisionHandler(new PlayerCollisionHandler4(PlayerType.Hero,SceneType.Scene3to2));
           
        }

   

 
            
            
               
            
    @Override
    protected void initGameVars(Map<String, Object> vars) {

        vars.put("Phase", true);

        vars.put("map1", "scene1.tmx");
        vars.put("map2", "scene2.tmx");
        vars.put("map3","scene3.tmx");

        vars.put("Name", "Reid");
        vars.put("HP", 350);
        vars.put("Mana", 200);
       
        vars.put("maxHP", 350);
        vars.put("maxMana", 200);

       
        vars.put("Namem", "Magia");
        vars.put("HPm", 200);
        vars.put("Manam", 250);
        vars.put("Phasem", true);
        vars.put("maxHPm", 200);
        vars.put("maxManam", 250);


        
        vars.put("lastPlayerX", lastX);
        vars.put("lastPlayerY", lastY);
        
        vars.put("scene", 1);
        vars.put("Nah",true);

        vars.put("Checkd2",false);

        vars.put("Checkd3",false);

        vars.put("time", 0.0);

        vars.put("isLoadedGame", false);

    }

    public static void setPlayer(Entity newPlayer) {
        instance.player = newPlayer;
    }

    public static Entity getPlayer() {
        return instance.player;
    }

   
 

    @Override
    protected void initGame() {
        instance = this;
        
        getGameScene().setBackgroundColor(Color.BLACK); 
        FXGL.getGameWorld().addEntityFactory(new CharacterFactory());
        FXGL.getGameWorld().addEntityFactory(new BackgroundScene1Factory());
        FXGL.getGameWorld().addEntityFactory(new CombatWithRexFactory());
        FXGL.getGameWorld().addEntityFactory(new BackgroundScene2Factory());
        FXGL.getGameWorld().addEntityFactory(new CharacterScene2Factory());
        FXGL.getGameWorld().addEntityFactory(new CharacterScene3Factory());
        FXGL.getGameWorld().addEntityFactory(new BackgroundScene3Factory());
        FXGL.getGameWorld().addEntityFactory(new CombatWithDM());
        FXGL.getGameWorld().addEntityFactory(new FinalJourney());
        
       
        
        
        //FXGL.getGameWorld().setLevel(map);


        FXGL.setLevelFromMap("scene1.tmx");

        SystemEvent.combat();

        System.out.println("isLoadedGame: " + FXGL.getb("isLoadedGame"));

         if (FXGL.getb("isLoadedGame") == false) {
            System.out.println("New Game");
            this.getSpawnDefault();  
        } else {
            System.out.println("Loaded Game");
            spawnPlayerAtSavedPosition();  
        }

        map = FXGL.getAssetLoader().loadLevel(FXGL.gets("map1"), new TMXLevelLoader());

        player = FXGL.getGameWorld().getEntitiesByType(PlayerType.Hero).get(0);
        FXGL.getGameScene().getViewport().bindToEntity(player, FXGL.getAppWidth()/2, FXGL.getAppHeight()/2);
        FXGL.getGameScene().getViewport().setZoom(1.5);
        int mapWidth = (int) map.getWidth();
        int mapHeight = (int) map.getHeight();
        FXGL.getGameScene().getViewport().setBounds(-10000/2, 0, mapWidth + 150, mapHeight);
        FXGL.getGameScene().getViewport().setLazy(true);
       
        
    }

    public void spawnPlayerAtSavedPosition() {
        double lastX = FXGL.getd("lastPlayerX");
        double lastY = FXGL.getd("lastPlayerY");

        player = FXGL.spawn("Reid", new SpawnData(lastX, lastY));

      
       

    }

      

     public void getSpawnDefault(){
        List<Entity> entities = FXGL.getGameWorld().getEntitiesByType((SceneType.SpawnPoints));
        for(Entity entity : entities){
            System.out.println(1);
            SpawnComponent component = entity.getComponent(SpawnComponent.class);
            FXGL.spawn(component.getName(),new SpawnData(component.getPosition()));     
            }

       

        }
    

    
   

    @Override
    protected void initInput() {

       
        FXGL.getInput().addAction(new UserAction("Right") {
        @Override
        protected void onAction() {
            if (FXGL.getb("Phase") == true){
            player.getComponent(ControllerComponent.class).moveRight();
            }
        }

        @Override
        protected void onActionEnd() {
            if (FXGL.getb("Phase") == true){
            player.getComponent(ControllerComponent.class).stop();
            }
        }
        }, KeyCode.D);

        FXGL.getInput().addAction(new UserAction("Left") {
        @Override
        protected void onAction() {
            if(FXGL.getb("Phase") == true){
                player.getComponent(ControllerComponent.class).moveLeft();
             }
            }

        @Override
        protected void onActionEnd() {
            if(FXGL.getb("Phase") == true){
            player.getComponent(ControllerComponent.class).stop();
            }
        }
        }, KeyCode.A);

        FXGL.getInput().addAction(new UserAction("Up") {
        @Override
        protected void onAction() {
            if(FXGL.getb("Phase") == true){
                player.getComponent(ControllerComponent.class).moveUp();
              }
            }

        @Override
        protected void onActionEnd() {
            if(FXGL.getb("Phase") == true){
                player.getComponent(ControllerComponent.class).stop();
                }
            }
        }, KeyCode.W);

        FXGL.getInput().addAction(new UserAction("Down") {
            @Override
            protected void onAction() {
                if(FXGL.getb("Phase") == true){
                player.getComponent(ControllerComponent.class).moveDown();
                }
            }

            @Override
            protected void onActionEnd() {
                if(FXGL.getb("Phase") == true){
                player.getComponent(ControllerComponent.class).stop();
                }
            }
        }, KeyCode.S);

        
        FXGL.getInput().addAction(new UserAction("Interact") {
            @Override
            protected void onAction() {
                if(FXGL.getb("Phase") == true){
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