package com.Component;

import com.Combat.OrderCombat;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;

public class DamageComponent extends Component {
    private static int attack;
    private static Entity targetEnemy; 
    

    public DamageComponent(int attack) {
        this.attack = attack;
        this.targetEnemy = targetEnemy;
    }

    public int getDamage() {
        return attack;
    }

    public void setDamage(int  damage) {
        this.attack = damage;
    }

    public void setTargetEnemy(){

        this.targetEnemy = OrderCombat.getTargetEnemy();

    }

    public Entity getTargetEnemy() {
        return targetEnemy;
    }



     public static void decreaseHP() {

            targetEnemy = OrderCombat.getTargetEnemy();

            StatusComponent status = targetEnemy.getComponent(StatusComponent.class);
            status.setHPCharacter(status.getHPCharacter() - attack);
            if (status.getHPCharacter() <= 0) {
                FXGL.getGameWorld().removeEntity(targetEnemy);
                FXGL.getNotificationService().pushNotification("💀 " + targetEnemy.getType() + " has been defeated!");
            }
        }
}
