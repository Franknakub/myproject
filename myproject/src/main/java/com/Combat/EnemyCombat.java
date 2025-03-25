package com.Combat;

import static com.almasb.fxgl.dsl.FXGL.play;

import com.Component.DamageEnemyComponent;
import com.Component.DamageHeroComponent;
import com.Component.StatusComponent;
import com.Type.PlayerType;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;

public class EnemyCombat {

    private static Entity player;

    private static Entity targetEnemy; 
    
    public static void enemyAttack() {

        targetEnemy = OrderCombat.getTargetEnemy();

        player = FXGL.getGameWorld().getEntitiesByType(PlayerType.Combat).get(0);
        StatusComponent playerStatus = player.getComponent(StatusComponent.class);
        DamageEnemyComponent enemyDamage = targetEnemy.getComponent(DamageEnemyComponent.class);
        StatusComponent enemyStatus = targetEnemy.getComponent(StatusComponent.class);
        if (player != null) {
           
            FXGL.getNotificationService().pushNotification("💥 Enemy attacks you with " + enemyDamage.getDamage() + " damage!");
            
            OrderCombat.setPlayerTurn(true);

            DamageEnemyComponent.decreaseHP();

           
            
        }
    }




}
