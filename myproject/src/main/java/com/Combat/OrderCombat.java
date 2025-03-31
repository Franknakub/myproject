package com.Combat;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.Component.StatusComponent;
import com.Component.CharecterHero.DamageHeroComponent;
import com.GameEvent.BackMainScene;
import com.GameEvent.CombatScene;
import com.GameEvent.SystemEvent;
import com.Type.Enemy.EnemyType;
import com.Type.Player.PlayerType;
import com.UI.ActionButtonUI;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;

public class OrderCombat {


    private static boolean isPlayerTurn = true;
    private static int count = 0;
    private static Entity targetEnemy; 
    private static Entity player;
            
                
            
            // ✅ เลือกเป้าหมายที่จะตี
            public void setTargetEnemy(Entity targetEnemy) {
                this.targetEnemy = targetEnemy;
            }
        
            public static Entity getTargetEnemy() {
                return targetEnemy;
            }

            public static boolean getIsPlayerTurn() {
                return isPlayerTurn;
            }
            
            public static void setPlayerTurn(boolean isPlayerTurn) {
                OrderCombat.isPlayerTurn = isPlayerTurn;
            }
        
            

            public void attack() {
                if (!isPlayerTurn) {
                    FXGL.getNotificationService().pushNotification("❌ It's not your turn!");
                    return;
                }

               else if (targetEnemy != null) {
                    targetEnemy = getTargetEnemy();

                     StatusComponent enemyStatus = targetEnemy.getComponent(StatusComponent.class);

                    DamageHeroComponent.decreaseHP();
                    FXGL.getNotificationService().pushNotification("⚔ Attacked " + enemyStatus.getName() + " for " + DamageHeroComponent.getDamage() + " damage!");
                    count++;
                    check();
                //     List<Entity> players = FXGL.getGameWorld().getEntitiesByType(PlayerType.Hero,PlayerType.Combat)
                //     .stream()   
                //     .filter(enemy -> enemy.getComponent(StatusComponent.class).getHPCharacter() > 0)
                //     .collect(Collectors.toList());

                //     List<Entity> enemies = FXGL.getGameWorld().getEntitiesByType(EnemyType.LowEnemy, EnemyType.HighEnermy, EnemyType.BossMonster)
                //     .stream()
                //     .filter(enemy -> enemy.getComponent(StatusComponent.class).getHPCharacter() > 0)
                //     .collect(Collectors.toList());


                //    if(enemies.isEmpty()) {
                //         FXGL.getNotificationService().pushNotification("🎉 All enemies have been defeated!");
                //         SystemEvent.eventBus.fireEvent(new BackMainScene(BackMainScene.BACKTOMAINSCENEIFWIN)); 
                //     }

                //     if(count >= players.size()){
                //         count = 0;
                    
                //     if (!enemies.isEmpty()) {
                //         isPlayerTurn = false;
                //         EnemyCombat.enemyAttack(); 
                       
                //      } 
                        
                //     }
                //     FXGL.getGameScene().getUINodes().stream() //เก็บUIทั้งหมดที่อยู่ใน Scene
                //     .filter(ActionButtonUI.class::isInstance) //เลือกเฉพาะ UI ที่เป็น ActionButtonUI
                //     .map(ActionButtonUI.class::cast)  //แปลงเป็น ActionButtonUI
                //     .forEach(ActionButtonUI::updateEnemySelectionUI); //LoopUI ให้เป็นของ ActionButtonUI  
                    
                } else {
                    FXGL.getNotificationService().pushNotification("❌ No target selected!");
                   
                }
            }
        
            // ✅ หนีจากการต่อสู้
            public void flee() {


                if (isPlayerTurn == false) {
                    
                   
                    FXGL.getNotificationService().pushNotification("❌ It's not your turn!");
                   
                    return;
                }
                
                FXGL.getNotificationService().pushNotification("🏃‍♂ You fled from battle!");

                SystemEvent.eventBus.fireEvent(new BackMainScene(BackMainScene.BACKTOMAINSCENE));
                isPlayerTurn = true;
            }

            public void useSkill() {


                List<Entity> players = FXGL.getGameWorld().getEntitiesByType(PlayerType.Hero,PlayerType.Combat)
                .stream()   
                .filter(enemy -> enemy.getComponent(StatusComponent.class).getHPCharacter() > 0)
                .collect(Collectors.toList());
            
                List<Entity> enemies = FXGL.getGameWorld().getEntitiesByType(EnemyType.LowEnemy, EnemyType.HighEnermy, EnemyType.BossMonster)
                .stream()
                .filter(enemy -> enemy.getComponent(StatusComponent.class).getHPCharacter() > 0)
                .collect(Collectors.toList());



                if (!isPlayerTurn) {
                    FXGL.getNotificationService().pushNotification("❌ It's not your turn!");
                    return;
                }

               else if (targetEnemy != null) {
                    targetEnemy = getTargetEnemy();
                    player = FXGL.getGameWorld().getEntitiesByType(PlayerType.Combat).get(0);
                    StatusComponent statusPlayer = player.getComponent(StatusComponent.class);
                    StatusComponent enemyStatus = targetEnemy.getComponent(StatusComponent.class);
                    DamageHeroComponent damage = player.getComponent(DamageHeroComponent.class);

                    if(statusPlayer.getManaCharacter() >= damage.getManacost()){
                        FXGL.set("Mana", statusPlayer.getManaCharacter() - damage.getManacost());
                        DamageHeroComponent.useSkill();
                        FXGL.getNotificationService().pushNotification("⚡ Used "+ damage.getSkillName()+ " ! Mana cost :" + damage.getManacost());
                        FXGL.getNotificationService().pushNotification("⚡ Used "+ damage.getSkillName()+"!: " + damage.getSkillDamage()+" damage");
                        count++;
                        check();
                    }
                    else{
                        FXGL.getNotificationService().pushNotification("❌ Not enough mana!");
                    }
                    if(enemies.isEmpty()) {
                    FXGL.getNotificationService().pushNotification("🎉 All enemies have been defeated!");
                    SystemEvent.eventBus.fireEvent(new BackMainScene(BackMainScene.BACKTOMAINSCENEIFWIN)); 
                }

               
                    
                    
                    
                    
                } else {
                    FXGL.getNotificationService().pushNotification("❌ No target selected!");
                   
                }
            }

            public void check(){

                List<Entity> players = FXGL.getGameWorld().getEntitiesByType(PlayerType.Hero,PlayerType.Combat)
                .stream()   
                .filter(enemy -> enemy.getComponent(StatusComponent.class).getHPCharacter() > 0)
                .collect(Collectors.toList());

                List<Entity> enemies = FXGL.getGameWorld().getEntitiesByType(EnemyType.LowEnemy, EnemyType.HighEnermy, EnemyType.BossMonster)
                .stream()
                .filter(enemy -> enemy.getComponent(StatusComponent.class).getHPCharacter() > 0)
                .collect(Collectors.toList());


               if(enemies.isEmpty()) {
                    FXGL.getNotificationService().pushNotification("🎉 All enemies have been defeated!");
                    SystemEvent.eventBus.fireEvent(new BackMainScene(BackMainScene.BACKTOMAINSCENEIFWIN)); 
                }

                if(count >= players.size()){
                    count = 0;
                
                if (!enemies.isEmpty()) {
                    isPlayerTurn = false;
                    EnemyCombat.enemyAttack(); 
                   
                 } 
                    
                }
                FXGL.getGameScene().getUINodes().stream() //เก็บUIทั้งหมดที่อยู่ใน Scene
                .filter(ActionButtonUI.class::isInstance) //เลือกเฉพาะ UI ที่เป็น ActionButtonUI
                .map(ActionButtonUI.class::cast)  //แปลงเป็น ActionButtonUI
                .forEach(ActionButtonUI::updateEnemySelectionUI); //LoopUI ให้เป็นของ ActionButtonUI  


            }
            
            
       
    }
    



