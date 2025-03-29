package com.Combat;

import static com.almasb.fxgl.dsl.FXGL.play;

import java.util.List;
import java.util.stream.Collectors;

import com.Component.StatusComponent;
import com.Component.CharecterEnemy.DamageEnemyComponent;
import com.Component.CharecterHero.DamageHeroComponent;
import com.Type.Enemy.EnemyType;
import com.Type.Player.PlayerType;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;

public class EnemyCombat {

    private static Entity player;

    private static Entity targetEnemy; 
    
    public static void enemyAttack() {

        StatusComponent playerStatus = player.getComponent(StatusComponent.class);
        DamageEnemyComponent enemyDamage = targetEnemy.getComponent(DamageEnemyComponent.class);
        StatusComponent enemyStatus = targetEnemy.getComponent(StatusComponent.class);
        if (player != null) {           
            
            OrderCombat.setPlayerTurn(true);

            DamageEnemyComponent.decreaseHP();

           
            
        }
    }




}
