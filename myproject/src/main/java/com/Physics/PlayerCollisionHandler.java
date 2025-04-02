package com.Physics;

import com.Type.SceneType;
import com.Type.Player.PlayerType;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.physics.CollisionHandler;
import com.almasb.fxgl.scene.Scene;

public class PlayerCollisionHandler extends CollisionHandler{

    public PlayerCollisionHandler() {
        super(PlayerType.Hero,SceneType.NextScene); 
        
    }

    @Override
    protected void onCollisionBegin(Entity a, Entity b) {
        
    }

}