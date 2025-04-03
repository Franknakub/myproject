package com.Factory.FactoryInMain;

import static com.almasb.fxgl.dsl.FXGL.texture;

import com.Component.SpawnComponent;
import com.Component.StatusComponent;
import com.Component.CharecterEnemy.AnimationEnemyComponent;
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

public class CharacterScene3Factory implements EntityFactory { 
   
    @Spawns("SpawnPoint3")
    public Entity newSpawnPointPlayer(SpawnData data){
            return FXGL.entityBuilder()
                   .type(SceneType.SpawnPoint3)
                   .with(new SpawnComponent("Reid",data.getX(),data.getY()))
                   .build();
        

        }

        @Spawns("SpawnEnemy3")
    public Entity spawnEnemy2(SpawnData data) {
        PhysicsComponent physics = new PhysicsComponent();
        physics.setBodyType(BodyType.STATIC);
     
     
         return FXGL.entityBuilder(data)
                .type(EnemyType.BossMonster)
                .bbox(new HitBox(BoundingShape.box(64,64))) 
                .with(new AnimationEnemyComponent("DuessaAni.png", 1, 3))
                .with(physics)
                //.bbox(new HitBox(BoundingShape.box(64,64)))
                //.at(0,100)
                .build();
                
     }

     @Spawns("FleeFromJourney")
     public Entity FleeFromJourney(SpawnData data){
        return FXGL.entityBuilder()
               .type(SceneType.FleeFromJourney)
               .with(new SpawnComponent("Reid",data.getX(),data.getY()))
               .build();
    

    }

 

     

     

    
}
