package com.project;

import com.Component.ControllerComponent;
import com.Component.PlayerComponent;
import com.Factory.CharacterFactory;
import com.Type.PlayerType;
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



import static com.almasb.fxgl.dsl.FXGL.*;

public class App extends GameApplication {

     Entity player ;

    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(1280);
        settings.setHeight(720);
        settings.setTitle("Final Journey");
        settings.setVersion("Alpha");
    }

    @Override
    protected void initPhysics() {
        PhysicsWorld gamephysic = FXGL.getPhysicsWorld();  // Initialize after FXGL engine starts
        gamephysic.setGravity(0,0 );
    }

   

    


      

               //   private static Entity getPlayer() {
                //    return FXGL.getGameWorld().getSingleton(PlayerType.Hero);
              //  }
            
            
               
            
                @Override
    protected void initGameVars(Map<String, Object> vars) {
        vars.put("pixelsMoved", 0);
    }

   

    @Override
    protected void initGame() {
        
        
     

                FXGL.getGameWorld().addEntityFactory(new CharacterFactory());

                player = FXGL.spawn("Player");

               Entity Enemy = FXGL.spawn("LowEnemy");
               

              


                //Level map = FXGL.getAssetLoader().loadLevel("Mainmap.tmx", new TMXLevelLoader());

                //FXGL.getGameWorld().setLevel(map);

               
              
        
            FXGL.getGameScene().getViewport().bindToEntity(player ,FXGL.getAppWidth()/2, FXGL.getAppHeight()/2);

            
       
    }

    @Override
    protected void initInput() {
        /*FXGL.onKey(KeyCode.A, "Move Left", () -> getPlayer().getComponent(PlayerComponent.class).left());
                    FXGL.onKey(KeyCode.D, "Move Right", () -> getPlayer().getComponent(PlayerComponent.class).right());
                    FXGL.onKey(KeyCode.W, "Move Up", () -> getPlayer().getComponent(PlayerComponent.class).up());
                    FXGL.onKey(KeyCode.S, "Move Down", () -> getPlayer().getComponent(PlayerComponent.class).down());
                
            */
            FXGL.getInput().addAction(new UserAction("Right") {
            @Override
            protected void onAction() {
                player.getComponent(ControllerComponent.class).moveRight();
            }

            @Override
            protected void onActionEnd() {
                player.getComponent(ControllerComponent.class).stop();
            }
        }, KeyCode.D);

        FXGL.getInput().addAction(new UserAction("Left") {
            @Override
            protected void onAction() {
                player.getComponent(ControllerComponent.class).moveLeft();
            }

            @Override
        protected void onActionEnd() {
            player.getComponent(ControllerComponent.class).stop();
        }
        }, KeyCode.A);

        FXGL.getInput().addAction(new UserAction("Up") {
            @Override
            protected void onAction() {
                player.getComponent(ControllerComponent.class).moveUp();
            }

            @Override
            protected void onActionEnd() {
                player.getComponent(ControllerComponent.class).stop();
            }
        }, KeyCode.W);


        FXGL.getInput().addAction(new UserAction("Down") {
            @Override
            protected void onAction() {
                player.getComponent(ControllerComponent.class).moveDown();
            }

            @Override
            protected void onActionEnd() {
                player.getComponent(ControllerComponent.class).stop();
            }
        }, KeyCode.S);
         
                
             }


    @Override
    protected void initUI() {
        Text textHP = new Text("HP");
        Text myHP = new Text();
        textHP.setTranslateX(50);
        textHP.setTranslateY(100); 
        myHP.setTranslateX(100); 
        myHP.setTranslateY(100);

        myHP.textProperty().bind(getWorldProperties().intProperty("pixelsMoved").asString());

        getGameScene().addUINode(myHP);
        getGameScene().addUINode(textHP);
        
    }


}