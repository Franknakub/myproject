package com.UI;

import java.util.List;
import java.util.stream.Collectors;

import com.Combat.OrderCombat;
import com.Component.StatusComponent;
import com.Component.Skill.SkillComponent1;
import com.Component.Skill.SkillComponent2;
import com.Component.Skill.SkillComponent3;
import com.GameEvent.SystemEvent;
import com.Type.Enemy.EnemyType;
import com.Type.Player.PlayerType;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ActionButtonUI {
    private VBox vbox;
    private VBox skillBox; 
    private Button attackButton;
    private Button fleeButton;
    private Button skillButton;
    private OrderCombat combat;
    private VBox enemySelectionBox;
    private HBox hbox;
    private ScrollPane scrollPane;
    private int playerIndex = 0; 
    private Entity player;
    private List<Entity> players;
    private Entity targetEnemy;
    private OrderCombat orderCombat;
    

    private List<Entity> getPlayers() {
        return FXGL.getGameWorld().getEntitiesByType(PlayerType.Hero, PlayerType.Combat, PlayerType.Mage)
            .stream()
            .filter(p -> p.getComponent(StatusComponent.class).getHPCharacter() > 0)
            .collect(Collectors.toList());
    }

    public ActionButtonUI() {
        orderCombat = new OrderCombat();
        players = getPlayers();

        if(players == null){
            FXGL.getNotificationService().pushNotification("❌ No player found!");
            return;
        }
          
        player = players.get(playerIndex);
        combat = new OrderCombat();
        vbox = new VBox(20);
        
     
        attackButton = new Button("Attack");
        attackButton.setFont(Font.font(18));
        attackButton.setOnAction(e -> {
            player = getPlayers().get(playerIndex);
            targetEnemy = combat.getTargetEnemy();             
            if(targetEnemy == null){
                FXGL.getNotificationService().pushNotification("❌ Please select a target enemy!");
                return;
            }else{
                combat.setPlayer(player);
                combat.attack();
                 // อัปเดตสถานะศัตรูหลังการโจมตี
        if (SystemEvent.statusUIEnemy != null) {
            SystemEvent.statusUIEnemy.updateEnemyStatus();
        }
                nextPlayerTurn(); 
                updateEnemySelectionUI();
                orderCombat.setTargetEnemy(null);
        }
            
        });
        attackButton.setTextFill(Color.BLACK);
      
      
        fleeButton = new Button("Flee");
        fleeButton.setFont(Font.font(18));
        fleeButton.setOnAction(e -> combat.flee());
        fleeButton.setTextFill(Color.BLACK);

        skillButton = new Button("Skill");
        skillButton.setFont(Font.font(18));
        skillButton.setOnAction(e -> {
            player = getPlayers().get(playerIndex);
            targetEnemy = combat.getTargetEnemy(); 
            if(targetEnemy == null){
                FXGL.getNotificationService().pushNotification("❌ Please select a target enemy!");
                return;
            }else{
            updateEnemySelectionUI();    
            toggleSkillBox();
            
        }
        
        
        }); 

        skillButton.setTextFill(Color.BLACK);

        enemySelectionBox = new VBox(10);
        updateEnemySelectionUI();

        scrollPane = new ScrollPane(enemySelectionBox);
        scrollPane.setPrefHeight(200); 


        skillBox = new VBox(10);
        skillBox.setStyle("-fx-background-color: rgba(40, 40, 40, 0.9); -fx-padding: 10;");
        skillBox.setVisible(false);
        skillBox.setTranslateX(190);

        updateSkillUI(); 

        
        vbox.getChildren().addAll(attackButton, skillButton, fleeButton);
        vbox.setTranslateX(100);

        hbox = new HBox(10);
        hbox.getChildren().addAll(scrollPane, vbox, skillBox);
                
        hbox.setTranslateX(50);
        hbox.setStyle("-fx-background-color: rgb(0, 0, 0); -fx-padding: 10; -fx-border-color: white; -fx-border-width: 2;");
        hbox.setPrefWidth(500); 
        hbox.setPrefHeight(100); 
        
        hbox.setAlignment(Pos.CENTER); 
        hbox.setTranslateX((FXGL.getAppWidth() - hbox.getPrefWidth()) / 2); 
        hbox.setTranslateY(FXGL.getAppHeight() - hbox.getPrefHeight() - 80); 
    }





   
    private void nextPlayerTurn() {
        List<Entity> alivePlayers = getPlayers();
        
        if (alivePlayers.isEmpty()) {
            FXGL.getNotificationService().pushNotification("❌ No alive players!");
            return;
        }
    
        playerIndex++;
        
        if (playerIndex >= alivePlayers.size()) {
            playerIndex = 0; // รีเซ็ตลำดับผู้เล่น
        }
    
        player = alivePlayers.get(playerIndex);
        updateSkillUI();
    }
    
    
    private void updateSkillUI() {

        
        skillBox.getChildren().clear(); 

        List<SkillComponent1> skills = player.getComponents().stream()
            .filter(component -> component instanceof SkillComponent1)
            .map(component -> (SkillComponent1) component)
            .collect(Collectors.toList());

            

        for (SkillComponent1 skill : skills) {
            Button skillButton = new Button(skill.getSkillName());
            skillButton.setFont(Font.font(16));
            skillButton.setOnAction(e -> {
                player = getPlayers().get(playerIndex);
            SkillComponent1 skill1 = player.getComponent(SkillComponent1.class);
            StatusComponent statusPlayer = player.getComponent(StatusComponent.class);
                if (statusPlayer.getManaCharacter() <= skill1.getmanaCost()) {
                    
                
                    FXGL.getNotificationService().pushNotification("❌ Not enough mana!");
                }else {
                combat.setPlayer(player);
                combat.useSkill();
                skillBox.setVisible(false);
                nextPlayerTurn(); 
                updateEnemySelectionUI();
                orderCombat.setTargetEnemy(null);
                }
            });

            skillBox.getChildren().add(skillButton);
        }


        List<SkillComponent2> skills1 = player.getComponents().stream()
            .filter(component ->component instanceof SkillComponent2)
            .map(component -> (SkillComponent2) component)
            .collect(Collectors.toList());
            

        for (SkillComponent2 skill : skills1) {
            Button skillButton = new Button(skill.getSkillName());
            skillButton.setFont(Font.font(16));
            skillButton.setOnAction(e -> {
                player = getPlayers().get(playerIndex);
                SkillComponent2 skill2 = player.getComponent(SkillComponent2.class);
                StatusComponent statusPlayer = player.getComponent(StatusComponent.class);
                    if (statusPlayer.getManaCharacter() <= skill2.getmanaCost()) {
                        
                    
                        FXGL.getNotificationService().pushNotification("❌ Not enough mana!");
                    }else {
                    combat.setPlayer(player);
                    combat.useSkill2();
                    skillBox.setVisible(false);
                    nextPlayerTurn(); 
                    updateEnemySelectionUI();
                    orderCombat.setTargetEnemy(null);
                    }
                });
    

            skillBox.getChildren().add(skillButton);
        }

        List<SkillComponent3> skills2 = player.getComponents().stream()
            .filter(component ->component instanceof SkillComponent3)
            .map(component -> (SkillComponent3) component)
            .collect(Collectors.toList());

            

        for (SkillComponent3 skill : skills2) {
            Button skillButton = new Button(skill.getSkillName());
            skillButton.setFont(Font.font(16));
            skillButton.setOnAction(e -> {
                player = getPlayers().get(playerIndex);
                SkillComponent3 skill3 = player.getComponent(SkillComponent3.class);
                StatusComponent statusPlayer = player.getComponent(StatusComponent.class);
                    if (statusPlayer.getManaCharacter() <= skill3.getmanaCost()) {
                        
                    
                        FXGL.getNotificationService().pushNotification("❌ Not enough mana!");
                    }else {
                    combat.setPlayer(player);
                    combat.useSkill3();
                    skillBox.setVisible(false);
                    nextPlayerTurn(); 
                    updateEnemySelectionUI();
                    
                    orderCombat.setTargetEnemy(null);
                    }
                });
    

            skillBox.getChildren().add(skillButton);
        }


        
    }

 
    private void toggleSkillBox() {
        skillBox.setVisible(!skillBox.isVisible());
    }

    
    public void updateEnemySelectionUI() {
        enemySelectionBox.getChildren().clear(); 
        
        List<Entity> enemies = FXGL.getGameWorld().getEntitiesByType(EnemyType.LowEnemy, EnemyType.HighEnemy, EnemyType.BossMonster)
            .stream()
            .filter(enemy -> enemy.hasComponent(StatusComponent.class))
            .filter(enemy -> enemy.getComponent(StatusComponent.class).getHPCharacter() > 0)
            .collect(Collectors.toList());
            
            
    
        for (Entity enemy : enemies) {
            if (enemy.hasComponent(StatusComponent.class)) { 
                String enemyName = enemy.getComponent(StatusComponent.class).getName();
                
                Button enemyButton = new Button("🎯 Target: " + enemyName);
                enemyButton.setFont(Font.font(16));
                enemyButton.setOnAction(e -> combat.setTargetEnemy(enemy)); 
                
                enemySelectionBox.getChildren().add(enemyButton);
            }
        }
    }

    public HBox getHBox() {
        return hbox;
    }

    public void remove() {
        if (hbox != null) {
            FXGL.getGameScene().removeUINode(hbox);
            hbox = null;
        }
    }
}
