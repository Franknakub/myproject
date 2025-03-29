package com.Factory.FactoryInCombat;

import com.Type.Enemy.EnemyType;
import com.Type.Player.PlayerType;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.physics.box2d.dynamics.BodyType;
import static com.almasb.fxgl.dsl.FXGL.texture;

import com.Combat.OrderCombat;
import com.Component.StatusComponent;
import com.Component.CharecterEnemy.DamageEnemyComponent;
import com.Component.CharecterHero.DamageHeroComponent;
public class CombatWithRexFactory implements EntityFactory {

     @Spawns("setenemy")
     public Entity setenemy(SpawnData data) {
         PhysicsComponent physics = new PhysicsComponent();
         physics.setBodyType(BodyType.STATIC);
      
      
          return FXGL.entityBuilder(data)
                 .type(EnemyType.LowEnemy)
                 .viewWithBBox(texture("Rex.png",128*3,128*3))
                 .with(new StatusComponent("Rex",100,50))
                 .with(new DamageEnemyComponent(20))
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
                 .type(PlayerType.Combat)
                 .viewWithBBox(texture("Karee.png",128*3,128*3))
                 .with(physics)
                 .with(new StatusComponent(FXGL.gets("Name"),FXGL.geti("HP"),FXGL.geti("Mana")))
                 .with(new DamageHeroComponent(100))
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
