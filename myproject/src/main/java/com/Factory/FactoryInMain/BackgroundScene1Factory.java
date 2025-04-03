package com.Factory.FactoryInMain;

import com.Type.SceneType;
import com.Type.Player.PlayerType;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.handlers.CollectibleHandler;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.entity.components.IrremovableComponent;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.physics.box2d.dynamics.BodyType;
import com.almasb.fxgl.scene.Scene;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BackgroundScene1Factory implements EntityFactory {
    PhysicsComponent physics = new PhysicsComponent();   

    @Spawns("abyss zone")
    public Entity spawnWall(SpawnData data) {
        
        physics.setBodyType(BodyType.STATIC);
        return FXGL.entityBuilder(data)
                .type(SceneType.Wall)
                 .at(data.getX(),data.getY())
                .bbox(new HitBox(BoundingShape.box(data.<Integer>get("width"),data.<Integer>get("height"))))
                .with(new PhysicsComponent())
                .build();
    }

    @Spawns("prop")
    public Entity spawnProp(SpawnData data) {

        //physics.setBodyType(BodyType.STATIC);
        return FXGL.entityBuilder(data)
                .type(SceneType.Prop)
                .at(data.getX(),data.getY())
                .bbox(new HitBox(BoundingShape.box(data.<Integer>get("width"), data.<Integer>get("height"))))
                .with(new PhysicsComponent())
                .build();
    }

    @Spawns("Scene1to2")
    public Entity spawnNextScene(SpawnData data) {

        physics.setBodyType(BodyType.STATIC);
        return FXGL.entityBuilder(data)
                .type(SceneType.Scene1to2)
                .at(data.getX(),data.getY())
                .with(new CollidableComponent(true))
                .bbox(new HitBox(BoundingShape.box(data.<Integer>get("width"), data.<Integer>get("height"))))
                .with(new PhysicsComponent())
                .build();
    }

    

   

      
    
}
