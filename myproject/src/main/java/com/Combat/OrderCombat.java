package com.Combat;

import java.util.List;
import java.util.Optional;

import com.Component.DamageHeroComponent;
import com.Component.StatusComponent;
import com.GameEvent.BackMainScene;
import com.GameEvent.CombatScene;
import com.GameEvent.SystemEvent;
import com.Type.EnemyType;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;

public class OrderCombat {


    private static boolean isPlayerTurn = true;
   
    private static Entity targetEnemy; 
            
                
            
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
        
            
            // ✅ โจมตีศัตรูที่เลือก
            public void attack() {
                if (!isPlayerTurn) {
                    FXGL.getNotificationService().pushNotification("❌ It's not your turn!");
                    return;
                }

               else if (targetEnemy != null) {
                    targetEnemy = getTargetEnemy();

                     StatusComponent enemystatus = targetEnemy.getComponent(StatusComponent.class);

                    DamageHeroComponent.decreaseHP(); // ลด HP ศัตรู
                    FXGL.getNotificationService().pushNotification("⚔ Attacked " + enemystatus.getName() + " for " + DamageHeroComponent.getDamage() + " damage!");
                    isPlayerTurn = false;

                    EnemyCombat.enemyAttack(); // ศัตรูตอบโจมตี
                    
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
            
            
       
    }
    



