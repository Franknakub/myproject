package com.Combat;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.Component.StatusComponent;
import com.Component.CharecterHero.DamageHeroComponent;
import com.Component.Skill.SkillComponent1;
import com.Component.Skill.SkillComponent1;
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
    private ActionButtonUI actionButtonUI;
            
                
            
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
                    System.out.println("No target selected.");
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

                Check1();
            
                SkillComponent1 skill1 = player.getComponent(SkillComponent1.class);
                StatusComponent statusPlayer = player.getComponent(StatusComponent.class);

                if(targetEnemy == null) {
                    FXGL.getNotificationService().pushNotification("❌ No target selected!");
                    return;
                }

            
                else if (statusPlayer.getManaCharacter() >= skill1.getmanaCost()) {

                    FXGL.set(statusPlayer.getNameManaCharacter(), statusPlayer.getManaCharacter() - skill1.getmanaCost());
                  
                    statusPlayer.setManaCharacter(statusPlayer.getManaCharacter() - skill1.getmanaCost()); 
                    
                    
                    FXGL.getNotificationService().pushNotification(statusPlayer.getName()+" ⚡ used " + skill1.getmanaCost()+ "!");
                    FXGL.getNotificationService().pushNotification(statusPlayer.getName()+" ⚡ used " + skill1.getSkillName() + " damage "+skill1.getSkillDamage()+"!");
                    DamageHeroComponent.useSkill1();
                    check();
                    count++;
                    
                } else {
                    FXGL.getNotificationService().pushNotification("❌ Not enough mana!");
                }
            } 

            public void useSkill2() {

                player = getPlayer();
                targetEnemy = getTargetEnemy();

                Check1();
            
                SkillComponent2 skill2 = player.getComponent(SkillComponent2.class);
                StatusComponent statusPlayer = player.getComponent(StatusComponent.class);

                if(targetEnemy == null) {
                    FXGL.getNotificationService().pushNotification("❌ No target selected!");
                    return;
                }

            
                else if (statusPlayer.getManaCharacter() >= skill2.getmanaCost()) {

                    FXGL.set(statusPlayer.getNameManaCharacter(), statusPlayer.getManaCharacter() - skill2.getmanaCost());
                    statusPlayer.setManaCharacter(statusPlayer.getManaCharacter() - skill2.getmanaCost()); 
                    
                    FXGL.getNotificationService().pushNotification(statusPlayer.getName()+" ⚡ used " + skill2.getSkillName() + " damage "+skill2.getSkillDamage()+"!");
                    DamageHeroComponent.useSkill2();
                    check();
                    count++;
                    
                } else {
                    FXGL.getNotificationService().pushNotification("❌ Not enough mana!");
                }
            } 

            public void useSkill3() {

                player = getPlayer();
                targetEnemy = getTargetEnemy();

                Check1();
            
                SkillComponent3 skill3 = player.getComponent(SkillComponent3.class);
                StatusComponent statusPlayer = player.getComponent(StatusComponent.class);
                if(targetEnemy == null) {
                    FXGL.getNotificationService().pushNotification("❌ No target selected!");
                    return;
                }

            
                else if (statusPlayer.getManaCharacter() >= skill3.getmanaCost()) {

                    FXGL.set(statusPlayer.getNameManaCharacter(), statusPlayer.getManaCharacter() - skill3.getmanaCost());
                    
                    statusPlayer.setManaCharacter(statusPlayer.getManaCharacter() - skill3.getmanaCost()); 
                    
                    
                    FXGL.getNotificationService().pushNotification(statusPlayer.getName()+" ⚡ used " + skill3.getSkillName() + " damage "+skill3.getSkillDamage()+"!");
                    DamageHeroComponent.useSkill3();
                    check();
                    count++;
                    
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
                System.out.print("Imin");
                    count = 0;
                    FXGL.getNotificationService().pushNotification("🎉 All enemies have been defeated!");

                    if(FXGL.geti("scene") == 1){
                   
                    SystemEvent.eventBus.fireEvent(new BackMainScene(BackMainScene.BACKTOMAINSCENEIFWIN)); 
                    }else if (FXGL.geti("scene") == 2){

                        SystemEvent.eventBus.fireEvent(new BackMainScene(BackMainScene.BACKTOMAINSCENEIFWIN2));

                    }
                }

                if(count >= players.size()){
                    count = 0;
                
                if (!enemies.isEmpty()) {
                    isPlayerTurn = false;
                    EnemyCombat.enemyAttack(); 
                   
                 } 
                    
                }


            }

            
            public void Check1(){


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
            }
            
            
       
    }




