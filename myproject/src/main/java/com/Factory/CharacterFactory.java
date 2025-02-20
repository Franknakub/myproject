package com.Factory;


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
        physics.setFixtureDef(new FixtureDef().restitution(0));
        
       
    
     

        return FXGL.entityBuilder()
                .type(PlayerType.Hero)
                .view(new Rectangle(25, 25, Color.BLUE))
                .bbox(new HitBox(BoundingShape.box(16,13)))
                .at(0,0)
                .with(physics)
                .with(new CollidableComponent(true))
                .with(new ControllerComponent())
                
               
                .build(); 


   
    }

    @Spawns("LowEnemy")
    public Entity spawnEnermy(SpawnData data) {
        PhysicsComponent physics = new PhysicsComponent();
        physics.setBodyType(BodyType.DYNAMIC);
     
     
 
    
         return FXGL.entityBuilder()
                .type(EnemyType.LowEnemy)
                .view(new Rectangle(25, 25, Color.BLACK))
                 .with(physics)
                 .at(0,40)
                 .bbox(new HitBox(BoundingShape.box(25,25)))
                 .build();
                
     }
}
// import static com.almasb.fxgl.dsl.FXGL.texture;

// import com.Component.ControllerComponent;
// import com.Component.PlayerComponent;
// import com.Type.EnemyType;
// import com.Type.PlayerType;
// import com.almasb.fxgl.dsl.FXGL;
// import com.almasb.fxgl.entity.Entity;
// import com.almasb.fxgl.entity.EntityFactory;
// import com.almasb.fxgl.entity.SpawnData;
// import com.almasb.fxgl.entity.Spawns;
// import com.almasb.fxgl.entity.components.IrremovableComponent;
// import com.almasb.fxgl.physics.BoundingShape;
// import com.almasb.fxgl.physics.HitBox;
// import com.almasb.fxgl.physics.PhysicsComponent;
// import com.almasb.fxgl.physics.box2d.dynamics.BodyDef;
// import com.almasb.fxgl.physics.box2d.dynamics.BodyType;
// import com.almasb.fxgl.physics.box2d.dynamics.FixtureDef;

// import javafx.scene.paint.Color;
// import javafx.scene.shape.Rectangle;

// import com.almasb.fxgl.entity.EntityFactory;

// public class CharacterFactory implements EntityFactory{

//     @Spawns("Player")
//     public Entity spawnPlayer(SpawnData data) {
//         PhysicsComponent physics = new PhysicsComponent();
//         physics.setBodyType(BodyType.DYNAMIC);
       

//         return FXGL.entityBuilder()
//                 .type(PlayerType.Hero)
//                 .viewWithBBox(new Rectangle(25, 25, Color.BLUE))
//                 .with(physics)
//                 .bbox(new HitBox(BoundingShape.box(25,25)))
//                 .at(640,360)
//                 .with(new ControllerComponent())
//                 .with(new PlayerComponent(data.getX(), data.getY()))
//                 .build();
//     }

//     @Spawns("LowEnemy")
//     public Entity spawnEnermy(SpawnData data) {
//         PhysicsComponent physics = new PhysicsComponent();
//         physics.setBodyType(BodyType.DYNAMIC);
     
     
 
    
//         return FXGL.entityBuilder()
//                 .type(EnemyType.LowEnemy)
//                 .view(new Rectangle(25, 25, Color.BLACK))
//                 .with(physics)
//                 .at(640,400)
//                 .bbox(new HitBox(BoundingShape.box(25,25)))
//                 .build();
                
//     }

    

   
    
// }
