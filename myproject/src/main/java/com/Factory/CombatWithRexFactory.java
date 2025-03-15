package com.Factory;

import com.Type.EnemyType;
import com.Type.PlayerType;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.physics.box2d.dynamics.BodyType;
import static com.almasb.fxgl.dsl.FXGL.texture;

import com.Combat.OrderCombat;
import com.Component.DamageComponent;
import com.Component.StatusComponent;
public class CombatWithRexFactory implements EntityFactory {

     @Spawns("setenemy")
     public Entity setenemy(SpawnData data) {
         PhysicsComponent physics = new PhysicsComponent();
         physics.setBodyType(BodyType.STATIC);
      
      
          return FXGL.entityBuilder(data)
                 .type(EnemyType.LowEnemy)
                 .viewWithBBox(texture("Rex.png",128*3,128*3))
                 .with(new StatusComponent("Rex",100,50))
                 .with(new DamageComponent(10))
                 .with(physics)
                 //.bbox(new HitBox(BoundingShape.box(64,64)))
                 //.at(0,100)
                 .build();
                 
      }


      @Spawns("sethero")
     public Entity sethero(SpawnData data) {
         PhysicsComponent physics = new PhysicsComponent();
         physics.setBodyType(BodyType.STATIC);
      
      
          return FXGL.entityBuilder(data)
                 .type(PlayerType.Hero)
                 .viewWithBBox(texture("Karee.png",128*3,128*3))
                 .with(physics)
                 .with(new StatusComponent("Harold",101,50))
                 .with(new DamageComponent(20))
                 //.bbox(new HitBox(BoundingShape.box(64,64)))
                 //.at(0,100)
                 .build();
                 
      }

      @Spawns("setcamera")
      public Entity setcamera(SpawnData data) {
          PhysicsComponent physics = new PhysicsComponent();
          physics.setBodyType(BodyType.STATIC);
       
       
           return FXGL.entityBuilder(data)
                  .type(PlayerType.Camera)
                  
                  .with(physics)
                  //.bbox(new HitBox(BoundingShape.box(64,64)))
                  //.at(0,100)
                  .build();
                  
       }

}
