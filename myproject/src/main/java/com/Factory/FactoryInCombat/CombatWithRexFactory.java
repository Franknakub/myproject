package com.Factory.FactoryInCombat;

import com.Type.Enemy.EnemyType;
import com.Type.Player.PlayerType;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.physics.box2d.dynamics.BodyType;
import static com.almasb.fxgl.dsl.FXGL.texture;

import com.Combat.OrderCombat;
import com.Component.StatusComponent;
import com.Component.CharecterEnemy.DamageEnemyComponent;
import com.Component.CharecterHero.AnimationControlComponent;
import com.Component.CharecterHero.CheckTurnComponent;
import com.Component.CharecterHero.CombatAnimationComponent;
import com.Component.CharecterHero.DamageHeroComponent;
import com.Component.Skill.SkillComponent;
import com.Component.Skill.SkillComponent2;
import com.Component.Skill.SkillComponent3;
import com.Skill.HeavyAttack;
import com.Skill.InfinityEdge;
import com.Skill.Skill;
public class CombatWithRexFactory implements EntityFactory {

     @Spawns("setenemy")
     public Entity setenemy(SpawnData data) {
         PhysicsComponent physics = new PhysicsComponent();
         physics.setBodyType(BodyType.STATIC);
      
      
          return FXGL.entityBuilder(data)
                 .type(EnemyType.LowEnemy)
                 .viewWithBBox(texture("Rex.png",128*3,128*3))
                 .with(new StatusComponent("Rex",100,50,100,100))
                 .with(new DamageEnemyComponent(40))
                 .with(physics)
                 //.bbox(new HitBox(BoundingShape.box(64,64)))
                 //.at(0,100)
                 .build();
                 
      }


      @Spawns("sethero")
     public Entity sethero(SpawnData data) {
         PhysicsComponent physics = new PhysicsComponent();
         physics.setBodyType(BodyType.DYNAMIC);
      
          return FXGL.entityBuilder(data)
              .type(PlayerType.Combat)  
              .with(physics)
              .with(new StatusComponent(FXGL.gets("Name"),FXGL.geti("HP"),FXGL.geti("Mana"),FXGL.geti("maxHP"),FXGL.geti("maxMana")))
              .with(new DamageHeroComponent(20))
              .with(new SkillComponent("InfinityEdge", 50, 40))
              .with(new SkillComponent2("HeavyAttack", 20, 20))
              .with(new SkillComponent3("Omega Slash Genesis", 80, 60))
              .with(new CombatAnimationComponent("Reid.png", 9, 6))  
              .with(new AnimationControlComponent("Reid.png",9,6))
              .with(new CheckTurnComponent()) 
              .build();
                 
      }
      @Spawns("setmage")
      public Entity setmage(SpawnData data) {
          PhysicsComponent physics = new PhysicsComponent();
          physics.setBodyType(BodyType.STATIC);
       
           return FXGL.entityBuilder(data)
              .type(PlayerType.Mage)
              .with(physics)
              .with(new DamageHeroComponent(20))
              .with(new StatusComponent(FXGL.gets("Namem"),FXGL.geti("HPm"),FXGL.geti("Manam"),FXGL.geti("maxHPm"),FXGL.geti("maxManam")))
              .with(new SkillComponent("Judradjim",60, 20),
                     new SkillComponent2("Zoltraak", 20, 10),
                     new SkillComponent3("Vollzanbel", 90, 60))
              .with(new CombatAnimationComponent("marsha.png", 9, 6))  
              .with(new AnimationControlComponent("marsha.png",9,6))
              .with(new CheckTurnComponent())
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
