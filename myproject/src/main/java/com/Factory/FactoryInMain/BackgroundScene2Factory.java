package com.Factory.FactoryInMain;

import com.Type.SceneType;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.physics.box2d.dynamics.BodyType;

public class BackgroundScene2Factory implements EntityFactory {
    PhysicsComponent physics = new PhysicsComponent();   

    @Spawns("Wall")
    public Entity spawnWall(SpawnData data) {
        
        physics.setBodyType(BodyType.STATIC);
        return FXGL.entityBuilder(data)
                .type(SceneType.Wall)
                 .at(data.getX(),data.getY())
                .bbox(new HitBox(BoundingShape.box(data.<Integer>get("width"),data.<Integer>get("height"))))
                .with(new PhysicsComponent())
                .build();
    }



    @Spawns("Scene2to3")
    public Entity spawnNextScene(SpawnData data) {
        return FXGL.entityBuilder(data)
                .type(SceneType.Scene2to3)
                .at(data.getX(),data.getY())
                .with(new CollidableComponent(true))
                .bbox(new HitBox(BoundingShape.box(data.<Integer>get("width"), data.<Integer>get("height"))))
                .with(new PhysicsComponent())
                .build();
    }

    @Spawns("Scene2to1")
    public Entity spawnBackScene1(SpawnData data) {
        return FXGL.entityBuilder(data)
                .type(SceneType.Scene2to1)
                .at(data.getX(),data.getY())
                .with(new CollidableComponent(true))
                .bbox(new HitBox(BoundingShape.box(data.<Integer>get("width"), data.<Integer>get("height"))))
                .with(new PhysicsComponent())
                .build();
            }
    
            
    }

