package com.Component.CharecterEnemy;

import com.Component.CharecterHero.CombatAnimationComponent;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.util.Duration;

public class AnimationEnemyComponent extends Component {
    private String currentAnimationState = "idle";
    private String nameFile;
    private final AnimatedTexture texture;
    private final AnimationChannel idle;
    private AnimationEnemyComponent idleanimation;
   


    public AnimationEnemyComponent(String nameFile, int columns, int rows) {
        Image image = FXGL.image(nameFile);
        if (image == null) {
            throw new IllegalArgumentException("Image file not found: " + nameFile);
        }
        this.nameFile = nameFile;
        
        int frameW = (int) image.getWidth() / columns;
        int frameH = (int) image.getHeight() / rows;

        idle = new AnimationChannel(image, columns, frameW, frameH, Duration.seconds(1.25), 0, 2);
 

        texture = new AnimatedTexture(idle);
        
        texture.loopAnimationChannel(idle);
    }

    public void idle() {
        if (!currentAnimationState.equals("idle")) {
            texture.loopAnimationChannel(idle);
            currentAnimationState = "idle";
        }
    }



    public AnimatedTexture getTexture() {
        return texture;
    }

        @Override
    public void onAdded() {

        double width = entity.getWidth();
        double height = entity.getHeight();

  
        idleanimation = new AnimationEnemyComponent(nameFile,3,1);
        entity.getViewComponent().addChild(idleanimation.getTexture());

        entity.getTransformComponent().setScaleOrigin(new Point2D(width / 2, height / 2));
        
    }
    
}

