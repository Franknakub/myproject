package com.Combat;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.Component.StatusComponent;
import com.Component.CharecterHero.DamageHeroComponent;
import com.Component.Skill.SkillComponent;
import com.Component.Skill.SkillComponent2;
import com.Component.Skill.SkillComponent3;
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

            public static Entity getPlayer() {
                return player;
            }

            public void setPlayer(Entity player) {
                this.player = player;
            }
        
            

            public void attack() {

               
                if (!isPlayerTurn) {
                    FXGL.getNotificationService().pushNotification("❌ It's not your turn!");
                    return;
                }

               else if (targetEnemy != null) {
                    targetEnemy = getTargetEnemy();

                     StatusComponent enemyStatus = targetEnemy.getComponent(StatusComponent.class);

                     player = getPlayer();
         
                     DamageHeroComponent attack = player.getComponent(DamageHeroComponent.class);

                    DamageHeroComponent.decreaseHP();
                    FXGL.getNotificationService().pushNotification("⚔ Attacked " + enemyStatus.getName() + " for " + attack.getDamage() + " damage!");
                    count++;
                    check();
                    
                } else {
                    FXGL.getNotificationService().pushNotification("❌ No target selected!");
                   
                }
            }
        
            // ✅ หนีจากการต่อสู้
            public void flee() {

                List<Entity> enemies = FXGL.getGameWorld().getEntitiesByType(EnemyType.LowEnemy, EnemyType.HighEnemy, EnemyType.BossMonster)
                .stream()
                .filter(enemy -> enemy.getComponent(StatusComponent.class).getHPCharacter() > 0)
                .collect(Collectors.toList());

                for(Entity enemy : enemies) {
                   
                    StatusComponent enemyStatus = enemy.getComponent(StatusComponent.class);
                    enemyStatus.setHPCharacter(enemyStatus.getMaxHPCharacter()); // เพิ่ม HP ของศัตรูขึ้น 10
                }


                if (isPlayerTurn == false) {
                    
                   
                    FXGL.getNotificationService().pushNotification("❌ It's not your turn!");
                   
                    return;
                }
                
                FXGL.getNotificationService().pushNotification("🏃‍♂ You fled from battle!");

                SystemEvent.eventBus.fireEvent(new BackMainScene(BackMainScene.BACKTOMAINSCENE));
                isPlayerTurn = true;
            }

            public void useSkill() {

                player = getPlayer();
                targetEnemy = getTargetEnemy();

                if (targetEnemy == null) {
                    FXGL.getNotificationService().pushNotification("❌ No target selected!");
                    return;
                }
                if (player == null) {
                    FXGL.getNotificationService().pushNotification("❌ No player selected!");
                    return;
                }
            
                if (!player.hasComponent(SkillComponent.class)) {
                    FXGL.getNotificationService().pushNotification("❌ Player does not have SkillComponent!");
                    return;
                }
            
                SkillComponent skill = player.getComponent(SkillComponent.class);
                StatusComponent statusPlayer = player.getComponent(StatusComponent.class);
            
                if (statusPlayer.getManaCharacter() >= skill.getmanaCost()) {

                    
                    FXGL.set("Mana", statusPlayer.getManaCharacter() - skill.getmanaCost());
                    FXGL.getNotificationService().pushNotification(statusPlayer.getName()+" ⚡ used " + skill.getSkillName() + " damage "+skill.getSkillDamage()+"!");
                    DamageHeroComponent.useSkill1();
                    count++;
                    check();
                } else {
                    FXGL.getNotificationService().pushNotification("❌ Not enough mana!");
                }
            } 

            public void useSkill2() {

                player = getPlayer();
                targetEnemy = getTargetEnemy();

                if (targetEnemy == null) {
                    FXGL.getNotificationService().pushNotification("❌ No target selected!");
                    return;
                }
                if (player == null) {
                    FXGL.getNotificationService().pushNotification("❌ No player selected!");
                    return;
                }
            
                if (!player.hasComponent(SkillComponent2.class)) {
                    FXGL.getNotificationService().pushNotification("❌ Player does not have SkillComponent!");
                    return;
                }
            
                SkillComponent2 skill = player.getComponent(SkillComponent2.class);
                StatusComponent statusPlayer = player.getComponent(StatusComponent.class);
            
                if (statusPlayer.getManaCharacter() >= skill.getmanaCost()) {

                    
                    FXGL.set("Mana", statusPlayer.getManaCharacter() - skill.getmanaCost());
                    FXGL.getNotificationService().pushNotification(statusPlayer.getName()+" ⚡ used " + skill.getSkillName() + " damage "+skill.getSkillDamage()+"!");
                    DamageHeroComponent.useSkill2();
                    count++;
                    check();
                } else {
                    FXGL.getNotificationService().pushNotification("❌ Not enough mana!");
                }
            } 

            public void useSkill3() {

                player = getPlayer();
                targetEnemy = getTargetEnemy();

                if (targetEnemy == null) {
                    FXGL.getNotificationService().pushNotification("❌ No target selected!");
                    return;
                }
                if (player == null) {
                    FXGL.getNotificationService().pushNotification("❌ No player selected!");
                    return;
                }
            
                if (!player.hasComponent(SkillComponent3.class)) {
                    FXGL.getNotificationService().pushNotification("❌ Player does not have SkillComponent!");
                    return;
                }
            
                SkillComponent3 skill = player.getComponent(SkillComponent3.class);
                StatusComponent statusPlayer = player.getComponent(StatusComponent.class);
            
                if (statusPlayer.getManaCharacter() >= skill.getmanaCost()) {

                    
                    FXGL.set("Mana", statusPlayer.getManaCharacter() - skill.getmanaCost());
                    FXGL.getNotificationService().pushNotification(statusPlayer.getName()+" ⚡ used " + skill.getSkillName() + " damage "+skill.getSkillDamage()+"!");
                    DamageHeroComponent.useSkill3();
                    count++;
                    check();
                } else {
                    FXGL.getNotificationService().pushNotification("❌ Not enough mana!");
                }
            } 
            

            public void check(){

                List<Entity> players = FXGL.getGameWorld().getEntitiesByType(PlayerType.Hero,PlayerType.Combat,PlayerType.Mage)
                .stream()   
                .filter(enemy -> enemy.getComponent(StatusComponent.class).getHPCharacter() > 0)
                .collect(Collectors.toList());

                List<Entity> enemies = FXGL.getGameWorld().getEntitiesByType(EnemyType.LowEnemy, EnemyType.HighEnemy, EnemyType.BossMonster)
                .stream()
                .filter(enemy -> enemy.getComponent(StatusComponent.class).getHPCharacter() > 0)
                .collect(Collectors.toList());


               if(enemies.isEmpty()) {
                    count = 0;
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




