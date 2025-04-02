package com.UI;

import java.util.List;
import java.util.stream.Collectors;

import com.Combat.OrderCombat;
import com.Component.StatusComponent;
import com.Component.Skill.SkillComponent;
import com.Component.Skill.SkillComponent2;
import com.Component.Skill.SkillComponent3;
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

    public ActionButtonUI() {
       
        players = FXGL.getGameWorld().getEntitiesByType(PlayerType.Hero, PlayerType.Combat, PlayerType.Mage)
            .stream()   
            .filter(p -> p.getComponent(StatusComponent.class).getHPCharacter() > 0)
            .collect(Collectors.toList());

        if (players.isEmpty()) {
            System.out.println("❌ ไม่มีผู้เล่นที่มีชีวิตอยู่!");
            return;
        }

        player = players.get(playerIndex);
        combat = new OrderCombat();

        vbox = new VBox(20);
        
     
        attackButton = new Button("Attack");
        attackButton.setFont(Font.font(18));
        attackButton.setOnAction(e -> {
            combat.setPlayer(player);
            combat.attack();
            nextPlayerTurn(); 
            
        });
        attackButton.setTextFill(Color.BLACK);
      
      
        fleeButton = new Button("Flee");
        fleeButton.setFont(Font.font(18));
        fleeButton.setOnAction(e -> combat.flee());
        fleeButton.setTextFill(Color.BLACK);

    
        skillButton = new Button("Skill");
        skillButton.setFont(Font.font(18));
        skillButton.setOnAction(e -> toggleSkillBox()); 
        skillButton.setTextFill(Color.BLACK);

        enemySelectionBox = new VBox(10);
        updateEnemySelectionUI();

        scrollPane = new ScrollPane(enemySelectionBox);
        scrollPane.setFitToWidth(true);
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
        hbox.setPrefWidth(500); // กำหนดความกว้างของ hbox
        hbox.setPrefHeight(100); // กำหนดความสูงของ hbox
        
        hbox.setAlignment(Pos.CENTER); 
        hbox.setTranslateX((FXGL.getAppWidth() - hbox.getPrefWidth()) / 2); // จัดให้อยู่ตรงกลางในแนวนอน
        hbox.setTranslateY(FXGL.getAppHeight() - hbox.getPrefHeight() - 80); // จัดให้อยู่ด้านล่าง (20 คือระยะห่างจากขอบล่าง)
    }





   
    private void nextPlayerTurn() {
        playerIndex++; 
        if (playerIndex == players.size()) {
            playerIndex = 0; 

        }
        
        player = players.get(playerIndex);


        updateSkillUI();
    }

    
    private void updateSkillUI() {
        skillBox.getChildren().clear(); 

        List<SkillComponent> skills = player.getComponents().stream()
            .filter(component -> component instanceof SkillComponent)
            .map(component -> (SkillComponent) component)
            .collect(Collectors.toList());

            

        for (SkillComponent skill : skills) {
            Button skillButton = new Button(skill.getSkillName());
            skillButton.setFont(Font.font(16));
            skillButton.setOnAction(e -> {
                combat.setPlayer(player);
                combat.useSkill();
                skillBox.setVisible(false);
                nextPlayerTurn(); 
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
                combat.setPlayer(player);
                combat.useSkill2();
                skillBox.setVisible(false);
                nextPlayerTurn(); 
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
                combat.setPlayer(player);
                combat.useSkill3();
                skillBox.setVisible(false);
                nextPlayerTurn(); 
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
