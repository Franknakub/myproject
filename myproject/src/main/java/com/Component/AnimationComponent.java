package com.Component;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;

import javafx.scene.image.Image;
import javafx.util.Duration;

public class AnimationComponent extends Component {
     
    private String currentAnimationState = "idleDown";
    private final AnimatedTexture texture;
    private final AnimationChannel left;
    private final AnimationChannel right;
    private final AnimationChannel up;
    private final AnimationChannel down;
    private final AnimationChannel idleDown;
    private final AnimationChannel idleRight;
    private final AnimationChannel idleUp;
    private final AnimationChannel idleLeft;



    public AnimationComponent (String nameFile) {

       

        Image image = FXGL.image(nameFile);


        int columns = 6;   
        int rows = 10;     

        int frameW = (int) image.getWidth() / columns;
        int frameH = (int) image.getHeight() / rows;


        left = new AnimationChannel(image, columns, frameW, frameH, Duration.seconds(1), 6, 8);
        right = new AnimationChannel(image, columns, frameW, frameH, Duration.seconds(1), 6, 11);
        up = new AnimationChannel(image, columns, frameW, frameH, Duration.seconds(1), 12, 17);
        down = new AnimationChannel(image, columns, frameW, frameH, Duration.seconds(1), 18, 23);
        idleDown = new AnimationChannel(image, columns, frameW, frameH, Duration.seconds(1), 0, 5);
        idleUp = new AnimationChannel(image, columns, frameW, frameH, Duration.seconds(1), 17, 17);
        idleRight = new AnimationChannel(image, columns, frameW, frameH, Duration.seconds(1), 11, 11);
        idleLeft = new AnimationChannel(image, columns, frameW, frameH, Duration.seconds(1), 8, 8);


        texture = new AnimatedTexture(idleDown);
        texture.loopAnimationChannel(idleDown);
        
      
        

    }

    public AnimatedTexture getTexture() {
        return texture;
    }

    public void walkUp() {
        if (texture.getAnimationChannel() != up) {
            texture.playAnimationChannel(up);
            texture.loopAnimationChannel(up);
        }
        currentAnimationState = "walkUp";
    }

    public void walkDown() {
        if (texture.getAnimationChannel() != down) {
            texture.playAnimationChannel(down);
            texture.loopAnimationChannel(down);
        }
        currentAnimationState = "walkDown";
    }

    public void walkLeft() {
        if (texture.getAnimationChannel() != left) {
            texture.playAnimationChannel(left);
            texture.loopAnimationChannel(left);
        }
        currentAnimationState = "walkLeft";
    }

    public void walkRight() {
        if (texture.getAnimationChannel() != right) {
            texture.playAnimationChannel(right);
            texture.loopAnimationChannel(right);
        }
        currentAnimationState = "walkRight";
    }

    public String checkwalk(){

        return currentAnimationState;

    }

    public void idleDown() {
        texture.loopAnimationChannel(idleDown);
    }
    public void idleUp() {
        texture.loopAnimationChannel(idleUp);
    }

    public void idleRight() {
        texture.loopAnimationChannel(idleRight);
    }

    public void idleLeft() {
        texture.loopAnimationChannel(idleLeft);
    }

    

    // public void attack() {
    //     texture.playAnimationChannel(animAttack);
    // }

    // public void stop() {
    //     texture.loopAnimationChannel(animIdle);
    // }

    //  public void respawn() {
    //     entity.removeFromWorld();
    //     FXGL.spawn("Player", new SpawnData(x, y));
    // }

}
