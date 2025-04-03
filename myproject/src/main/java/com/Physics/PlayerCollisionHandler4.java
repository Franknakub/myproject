package com.Physics;

import com.GameEvent.CombatScene;
import com.GameEvent.NextScene;
import com.GameEvent.SystemEvent;
import com.Type.SceneType;
import com.Type.Player.PlayerType;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.physics.CollisionHandler;

import com.GameEvent.BackMainScene;



import javafx.event.Event;

public class PlayerCollisionHandler4 extends CollisionHandler{

    PlayerType playerType;
    SceneType sceneType;

    public PlayerCollisionHandler4(PlayerType playerType, SceneType sceneType) {
        super(playerType, sceneType);
        this.playerType = playerType;
        this.sceneType = sceneType;
    }

    @Override
    protected void onCollisionBegin(Entity player, Entity scene) {

        player = FXGL.getGameWorld().getEntitiesByType(PlayerType.Hero).get(0);
        FXGL.set("lastPlayerX", player.getX());
        FXGL.set("lastPlayerY", player.getY());

        

       SystemEvent.eventBus.fireEvent(new NextScene(NextScene.SCENE3TO2));
       
      
        
    }
}