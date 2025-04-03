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

                    //deal40
                    enemyDamage.RafflesiaSkill1();

                }else{

                    enemyDamage.decreaseHP();
                }

            }else if(enemyStatus.getName() == "Dregan"){

                if(randomIndex <= 30 ){

                    //30
                    enemyDamage.DreganSkill1();

                }else if(randomIndex >= 31 && randomIndex <= 60){

                   
                    //40
                    enemyDamage.DreganSkill2();


                }else {enemyDamage.decreaseHP();}
            
        }else if(enemyStatus.getName() == "Marlik")  {
            
                if(randomIndex <= 20 ){

                    //dealAoe20damage
                    enemyDamage.MarlikSkill1();

                }else if(randomIndex >= 21 && randomIndex <= 50){

                    //deal30
                    enemyDamage.MarlikSkill2();
                    
                }else {enemyDamage.decreaseHP();}
        
            }else if(enemyStatus.getName() == "Knight Michael"){

                if(randomIndex <= 20 ){

                    //deal90
                    enemyDamage.KnightMichaelSkill1();

                }else if(randomIndex >= 21 && randomIndex <= 50){

                    //deal40
                    enemyDamage.KnightMichaelSkill2();

                }else {enemyDamage.decreaseHP();}

            }else if(enemyStatus.getName() == "King Michael"){

                if(randomIndex <= 20 ){

                    //dealAOE90
                    enemyDamage.KingMichaelSkill1();

                }else if(randomIndex >= 21 && randomIndex <= 40){

                    //dealAOE40
                    enemyDamage.KingMichaelSkill2();

                }else {enemyDamage.decreaseHP();}

            }else if(enemyStatus.getName() == "Empress Duessa"){

                if(randomIndex <= 10 ){

                    //makeplayerhp 1
                    enemyDamage.EmpressDuessaSkill1();

                }else if(randomIndex >= 11 && randomIndex <= 40){

                    //dealAOE60
                    enemyDamage.EmpressDuessaSkill2();  

                }else {enemyDamage.decreaseHP();}
            
}
      OrderCombat.setPlayerTurn(true);
        }
        }



  
}