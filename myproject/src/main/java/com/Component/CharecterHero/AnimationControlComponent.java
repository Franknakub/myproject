package com.Component.CharecterHero;

import static com.almasb.fxgl.dsl.FXGL.random;

import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.physics.PhysicsComponent;

import javafx.geometry.Point2D;

public class AnimationControlComponent extends Component {
    CombatAnimationComponent combatanimation;
    String namefile;
   
    public AnimationControlComponent(String nameFile, int columns, int rows) {
        this.namefile = nameFile; // กำหนดค่าให้ namefile
    }
   public void animateidle(){
        combatanimation.idle();
    }

    
    
    public void animateattack(){
        combatanimation.attack();
    }

    public void animatetakedamage(){
        combatanimation.takedamage();
    }


    @Override
    public void onAdded() {

        double width = entity.getWidth();
        double height = entity.getHeight();

  
        combatanimation = new CombatAnimationComponent(namefile,9,6);
        entity.getViewComponent().addChild(combatanimation.getTexture());

        entity.getTransformComponent().setScaleOrigin(new Point2D(width / 2, height / 2));
        
    }


}



