package com.Factory.FactoryInMain;


import static com.almasb.fxgl.dsl.FXGL.texture;

import com.Component.SpawnComponent;
import com.Component.StatusComponent;
import com.Component.CharecterHero.AnimationComponent;
import com.Component.CharecterHero.ControllerComponent;
import com.Component.CharecterHero.InteractComponent;
import com.Type.SceneType;
import com.Type.Enemy.EnemyType;
import com.Type.Player.PlayerType;
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

import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;


public class CharacterFactory implements EntityFactory{
    
    @Spawns("Reid")
    public Entity Player(SpawnData data){
        PhysicsComponent physics = new PhysicsComponent();
        physics.setBodyType(BodyType.DYNAMIC);
       
        return FXGL.entityBuilder(data)
                .type(PlayerType.Hero)
                .bbox(new HitBox(BoundingShape.box(40,50)))           
                .with(physics)
                .with(new CollidableComponent(true))
                .with(new ControllerComponent())
                .with(new AnimationComponent("Actor1.png",3,4))
                .with(new InteractComponent("filetext.txt"))
                .with(new StatusComponent(FXGL.gets("Name"),FXGL.geti("HP"),FXGL.geti("Mana"),FXGL.geti("maxHP"),FXGL.geti("maxMana")))
                .build(); 

   
    }

    @Spawns("spawn point")
    public Entity newSpawnPointPlayer(SpawnData data){
            return FXGL.entityBuilder()
                   .type(SceneType.SpawnPoints)
                   .bbox(new HitBox(BoundingShape.box(10, 10)))
                   .with(new SpawnComponent("Reid",data.getX(),data.getY()))
                   .build();
        

        }

    @Spawns("spawn enemy")
    public Entity spawnEnermy(SpawnData data) {
        PhysicsComponent physics = new PhysicsComponent();
        physics.setBodyType(BodyType.STATIC);
     
     
         return FXGL.entityBuilder(data)
                .type(EnemyType.LowEnemy)
                .viewWithBBox(texture("Rex.png",128,128))
                .with(physics)
                //.bbox(new HitBox(BoundingShape.box(64,64)))
                //.at(0,100)
                .build();
                
     }

     @Spawns("backScene1")
     public Entity spawnBackScene1(SpawnData data) {
        return FXGL.entityBuilder(data)
                .type(SceneType.BackScene1)
                .build();

    

    
}
}

