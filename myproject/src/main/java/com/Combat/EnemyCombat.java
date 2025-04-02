package com.Combat;

import static com.almasb.fxgl.dsl.FXGL.play;

import java.io.ObjectInputFilter.Status;
import java.util.List;
import java.util.Random;
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

   
    
    public static void enemyAttack() {


        List<Entity> enemies = FXGL.getGameWorld().getEntitiesByType(EnemyType.LowEnemy, EnemyType.HighEnemy, EnemyType.BossMonster)
        .stream()
        .filter(enemy -> enemy.getComponent(StatusComponent.class).getHPCharacter() > 0)
        .collect(Collectors.toList());

      

        Random random = new Random();

        for(Entity enemy : enemies) { 
        
           int randomIndex = random.nextInt(enemies.size());

        StatusComponent enemyStatus = enemy.getComponent(StatusComponent.class);    
        DamageEnemyComponent enemyDamage = enemy.getComponent(DamageEnemyComponent.class);
            

        switch (randomIndex) {
            case 0:

                if (enemyStatus.getManaCharacter() >= 10) {
                    enemyStatus.setManaCharacter(enemyStatus.getManaCharacter() - 10);
                    FXGL.getNotificationService().pushNotification("💥 Enemy attacks with " + enemyDamage.getDamage() + " damage!");
                   enemyDamage.decreaseHP();
                }else enemyDamage.decreaseHP();
                    break;
            case 1:
                enemyDamage.decreaseHP();
                break;
            default:
                enemyDamage.decreaseHP();

                break;
        }
           
 
            
        }

        

     OrderCombat.setPlayerTurn(true);
    }

    


}
