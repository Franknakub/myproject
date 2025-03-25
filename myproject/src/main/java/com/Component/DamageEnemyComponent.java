package com.Component;

import com.Combat.OrderCombat;
import com.GameEvent.BackMainScene;
import com.GameEvent.SystemEvent;
import com.Type.PlayerType;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;

public class DamageEnemyComponent extends Component {
    private static int attack;

     private static Entity Hero;

    private static Entity targetEnemy; 


    public DamageEnemyComponent(int attack) {
        this.attack = attack;
    }

    public static int getDamage() {
        return attack;
    }

    public static void setDamage(int damage) {
       attack = damage;
    }

    public static void decreaseHP() {

        Hero = FXGL.getGameWorld().getEntitiesByType(PlayerType.Combat).get(0);
        targetEnemy = OrderCombat.getTargetEnemy();
        StatusComponent playerStatus = Hero.getComponent(StatusComponent.class);
        StatusComponent enemyStatus = targetEnemy.getComponent(StatusComponent.class);
        
        FXGL.set("HP", playerStatus.getHPCharacter() - attack);
        playerStatus.setHPCharacter(playerStatus.getHPCharacter() - attack);
        
        if (playerStatus.getHPCharacter() <= 0) {
            FXGL.getGameWorld().removeEntity(Hero);
            FXGL.getNotificationService().pushNotification("💀 " + playerStatus.getName() + " has been defeated!!");
            SystemEvent.eventBus.fireEvent(new BackMainScene(BackMainScene.BACKTOMAINSCENE));
            OrderCombat.setPlayerTurn (true);
        }
           
        
    



}

}
