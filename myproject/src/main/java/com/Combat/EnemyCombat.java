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
           
           int randomIndex = random.nextInt(100);

        StatusComponent enemyStatus = enemy.getComponent(StatusComponent.class);    
        DamageEnemyComponent enemyDamage = enemy.getComponent(DamageEnemyComponent.class);
            

       if(enemyStatus.getName() == "Rafflesia"){
        

                if(randomIndex < 40 ){

                    //damage25

                }else{

                    enemyDamage.decreaseHP();
                }

            }else if(enemyStatus.getName() == "Dregan"){

                if(randomIndex <= 30 ){

                    //

                }else if(randomIndex >= 31 && randomIndex <= 60){

                   
                    //


                }else {enemyDamage.decreaseHP();}
            
        }else if(enemyStatus.getName() == "Marlik")  {
            
                if(randomIndex <= 20 ){

                    //dealAoe20damage

                }else if(randomIndex >= 21 && randomIndex <= 50){

                    //deal
                    
                }else {enemyDamage.decreaseHP();}
        
            }else if(enemyStatus.getName() == "Knight Michael"){

                if(randomIndex <= 20 ){

                    //

                // }else if(randomIndex >= 50)
            }


       


      
 
            
         }

        

      OrderCombat.setPlayerTurn(true);
    

        }
        }

}