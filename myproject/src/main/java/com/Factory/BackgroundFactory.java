package com.Factory;

import com.Type.SceneType;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.entity.components.IrremovableComponent;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.physics.box2d.dynamics.BodyType;
import com.almasb.fxgl.scene.Scene;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BackgroundFactory implements EntityFactory {
    PhysicsComponent physics = new PhysicsComponent();
    
   
    @Spawns("Background")
    public Entity spawnBackground(SpawnData data) {
        return FXGL.entityBuilder(data)
                .view(new Rectangle(data.<Integer>get("width"), data.<Integer>get("height"), Color.BLACK))
                .with(new IrremovableComponent())
                .zIndex(-100)
                .build();
    }

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

     @Spawns("spawn point")
     public Entity spawnpoint(SpawnData data) {
         physics.setBodyType(BodyType.STATIC);

         return FXGL.entityBuilder(data)
                 .type(SceneType.Spawns)
                 .at(data.getX(),data.getY())
                 .bbox(new HitBox(BoundingShape.box(data.<Integer>get("width"), data.<Integer>get("height"))))
                 .with(new PhysicsComponent())
                 .build();
     }

      //@Spawns("Background")
     //ublic Entity spawnBackground(SpawnData data) {
       //  return FXGL.entityBuilder(data)
         //        .view(new Rectangle(data.<Integer>get("width"), data.<Integer>get("height"), Color.BLACK))
           //      .with(new IrremovableComponent())
             //    .zIndex(-100)
               //  .build();
     //}
    
}
