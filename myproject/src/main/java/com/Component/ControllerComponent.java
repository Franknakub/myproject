package com.Component;


import static com.almasb.fxgl.dsl.FXGL.texture;

import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.physics.PhysicsComponent;

import javafx.geometry.Point2D;

public class ControllerComponent extends Component{

    private PhysicsComponent physics;
    public int velocityX ;
    public int velocityY ;
    


    public void moveLeft() {

        velocityX = -200;
        entity.setScaleX(1);

    }

    public void moveRight() {

        velocityX = 200;
        entity.setScaleX(1);

    }

    public void moveUp() {

        velocityY = -200;
        entity.setScaleX(1);

    }

    public void moveDown() {

        velocityY = 200;
        entity.setScaleX(1);

    }
    
    public void stop() {
        velocityX = 0;
        velocityY = 0;
    }
    

    @Override
    public void onUpdate(double tfp) {
    physics.setVelocityX(velocityX); 
    physics.setVelocityY(velocityY);

    if (FXGLMath.abs(velocityX) < 1) {
        velocityX = 0;
          }

    if (FXGLMath.abs(velocityY) < 1) {
        velocityY = 0;
         }

         /*FXGL.set("pixelsMoved", velocityX);*/
    }



    @Override
    public void onAdded() {

        double width = entity.getWidth();
        double height = entity.getHeight();


        physics = entity.getComponent(PhysicsComponent.class);

        if (width > 0 && height > 0) {
            entity.getTransformComponent().setScaleOrigin(new Point2D(width / 2, height / 2));
        }

       

    }


    
}
