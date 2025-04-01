package com.Component.CharecterHero;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.util.Duration;

public class CombatAnimationComponent extends Component {
    private String currentAnimationState = "idle";
    private final AnimatedTexture texture;
    private final AnimationChannel idle;
    private final AnimationChannel attack;
    private final AnimationChannel takedamage;


    public CombatAnimationComponent(String nameFile, int columns, int rows) {
        Image image = FXGL.image(nameFile);
        if (image == null) {
            throw new IllegalArgumentException("Image file not found: " + nameFile);
        }

        int frameW = (int) image.getWidth() / columns;
        int frameH = (int) image.getHeight() / rows;

        idle = new AnimationChannel(image, columns, frameW, frameH, Duration.seconds(1.25), 9, 11);
        attack = new AnimationChannel(image, columns, frameW, frameH, Duration.seconds(0.75), 3, 5);
        takedamage = new AnimationChannel(image, columns, frameW, frameH, Duration.seconds(0.75), 35, 37);

        texture = new AnimatedTexture(idle);
        texture.loopAnimationChannel(idle);
    }

    public void idle() {
        if (!currentAnimationState.equals("idle")) {
            texture.loopAnimationChannel(idle);
            currentAnimationState = "idle";
        }
    }

    public void attack() {
       
            texture.loopAnimationChannel(attack);
            currentAnimationState = "attack";
        
    }

    public void takedamage() {
        
            texture.loopAnimationChannel(takedamage);
            currentAnimationState = "takedamage";
        
    }

    public AnimatedTexture getTexture() {
        return texture;
    }

    
}

