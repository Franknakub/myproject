package com.Combat;

import java.util.List;
import java.util.Optional;

import com.Component.DamageComponent;
import com.Component.StatusComponent;
import com.Type.EnemyType;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;

public class OrderCombat {

    private static int attack;
    private static Entity targetEnemy; 
            
                
            
            // ✅ เลือกเป้าหมายที่จะตี
            public void setTargetEnemy(Entity targetEnemy) {
                this.targetEnemy = targetEnemy;
            }
        
            public static Entity getTargetEnemy() {
                return targetEnemy;
            }
        
            
            // ✅ โจมตีศัตรูที่เลือก
            public void attack() {
                if (targetEnemy != null) {
                    StatusComponent enemyStatus = targetEnemy.getComponent(StatusComponent.class);
                    DamageComponent.decreaseHP(); // ลด HP ศัตรู
                    FXGL.getNotificationService().pushNotification("⚔ Attacked " + targetEnemy.getType() + " for " + attack + " damage!");
                } else {
                    FXGL.getNotificationService().pushNotification("❌ No target selected!");
                }
            }
        
            // ✅ หนีจากการต่อสู้
            public void flee() {
                FXGL.getNotificationService().pushNotification("🏃‍♂ You fled from battle!");
            }
            
            
       
    }
    



