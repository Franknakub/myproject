package com.Component.CharecterHero;

import com.Combat.OrderCombat;
import com.Component.StatusComponent;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;
import com.GameEvent.BackMainScene;
import com.GameEvent.SystemEvent;

public class DamageHeroComponent extends Component {
    private static int attack;
    private static Entity targetEnemy; 
    

    public DamageHeroComponent(int attack) {
        this.attack = attack;
        this.targetEnemy = targetEnemy;
    }

    public static int getDamage() {
        return attack;
    }

    public void setDamage(int  damage) {
        this.attack = damage;
    }

    


     public static void decreaseHP() {

            targetEnemy = OrderCombat.getTargetEnemy();

            StatusComponent status = targetEnemy.getComponent(StatusComponent.class);
            status.setHPCharacter(status.getHPCharacter() - attack);
            if (status.getHPCharacter() <= 0) {
                FXGL.getGameWorld().removeEntity(targetEnemy);
                FXGL.getNotificationService().pushNotification("💀 " + status.getName() + " has been defeated!");

            }
        }

       
}
