package com.Factory;


import static com.almasb.fxgl.dsl.FXGL.texture;

import com.Component.AnimationComponent;
import com.Component.ControllerComponent;
import com.Type.PlayerType;
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
import com.almasb.fxgl.physics.box2d.dynamics.FixtureDef;
import com.Type.EnemyType;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;


public class CharacterFactory implements EntityFactory{
    @Spawns("Player")
    public Entity newPlayerCharacter(SpawnData data){
        PhysicsComponent physics = new PhysicsComponent();
        physics.setBodyType(BodyType.DYNAMIC);
       
        
       
    
     

        return FXGL.entityBuilder()
                .type(PlayerType.Hero)
                //.view(texture("Actor1.png",128,128))
                .bbox(new HitBox(BoundingShape.box(64,64)))
                .at(0,0)
                .with(physics)
                .with(new CollidableComponent(true))
                .with(new ControllerComponent())
                .with(new AnimationComponent("testplayer.png"))
               
                .build(); 


   
    }

    @Spawns("LowEnemy")
    public Entity spawnEnermy(SpawnData data) {
        PhysicsComponent physics = new PhysicsComponent();
        physics.setBodyType(BodyType.STATIC);
     
     
         return FXGL.entityBuilder()
                .type(EnemyType.LowEnemy)
                .view(texture("Rex.png",128,128))
                .with(physics)
                .at(0,100)
                .bbox(new HitBox(BoundingShape.box(25,25)))
                .build();
                
     }
}

