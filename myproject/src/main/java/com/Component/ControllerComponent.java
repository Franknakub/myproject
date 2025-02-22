package com.Component;


import static com.almasb.fxgl.dsl.FXGL.image;
import static com.almasb.fxgl.dsl.FXGL.texture;

import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.util.Duration;

public class ControllerComponent extends Component{

    private PhysicsComponent physics;
    private double velocityX ;
    private double velocityY ;
    private AnimationComponent animation;

  
    
    
    

    @Override
    public void onUpdate(double tpf) {
        
    physics.setVelocityX(velocityX); 
    physics.setVelocityY(velocityY);

        
    if (FXGLMath.abs(velocityX) < 1) {
        velocityX = 0;
          }

    if (FXGLMath.abs(velocityY) < 1) {
        velocityY = 0;
         }

         

         
    }

    public void moveLeft() {

        velocityX = -200;
        entity.setScaleX(1);
       
        animation.walkLeft();
       

    }

    public void moveRight() {

        velocityX = 200;
        entity.setScaleX(1);
        animation.walkRight();
    }

    public void moveUp() {

        velocityY = -200;
        entity.setScaleX(1);
        animation.walkUp();
    }

    public void moveDown() {

        velocityY = 200;
        entity.setScaleX(1);
        animation.walkDown();
    }
    
    public void stop() {
        velocityX = 0;
        velocityY = 0;
        
        if(animation.checkwalk() == "walkUp"){

            animation.idleUp();

        }else if (animation.checkwalk() == "walkDown"){

            animation.idleDown();

        }else if (animation.checkwalk() == "walkRight"){

            animation.idleRight();

        }else if(animation.checkwalk() == "walkLeft"){

            animation.idleLeft();
        }else{

            animation.idleDown();
        }
    }
    

    



    @Override
    public void onAdded() {

        double width = entity.getWidth();
        double height = entity.getHeight();

  
        animation = new AnimationComponent("Actor1.png");
        entity.getViewComponent().addChild(animation.getTexture());

        physics = entity.getComponent(PhysicsComponent.class);

        
            entity.getTransformComponent().setScaleOrigin(new Point2D(width / 2, height / 2));
        
        
       

    }


    
}
