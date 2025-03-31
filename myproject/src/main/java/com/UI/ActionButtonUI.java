package com.UI;

import java.util.List;
import java.util.stream.Collectors;

import com.Combat.OrderCombat;
import com.Component.StatusComponent;
import com.Type.Enemy.EnemyType;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

public class ActionButtonUI {
    private VBox vbox;
    private VBox skillBox; // เพิ่ม VBox สำหรับแสดงสกิล
    private Button attackButton;
    private Button fleeButton;
    private Button skillButton;
    private OrderCombat combat;
    private VBox enemySelectionBox;
    private HBox hbox;
    private ScrollPane scrollPane;

    public ActionButtonUI() {
        combat = new OrderCombat();

        vbox = new VBox(20);
        
        attackButton = new Button("Attack");
        attackButton.setFont(Font.font(18));
        attackButton.setOnAction(e -> combat.attack());
        attackButton.setTextFill(Color.BLACK);
      
        fleeButton = new Button("Flee");
        fleeButton.setFont(Font.font(18));
        fleeButton.setOnAction(e -> combat.flee());
        fleeButton.setTextFill(Color.BLACK);

        skillButton = new Button("Skill");
        skillButton.setFont(Font.font(18));
        skillButton.setOnAction(e -> toggleSkillBox()); // เรียก toggleSkillBox() เมื่อกดปุ่ม
        skillButton.setTextFill(Color.BLACK);

        enemySelectionBox = new VBox(10);
        updateEnemySelectionUI(); 

        scrollPane = new ScrollPane(enemySelectionBox);
        scrollPane.setFitToWidth(true);
        scrollPane.setPrefHeight(200); 

        // สร้าง VBox สำหรับแสดงสกิล แต่ยังไม่เพิ่มใน HBox
        skillBox = new VBox(10);
        skillBox.setStyle("-fx-background-color: rgba(40, 40, 40, 0.9); -fx-padding: 10;");
        skillBox.setVisible(false); // ซ่อน skillBox ไว้ก่อน
        skillBox.setTranslateX(190); // ตั้งค่าตำแหน่ง X ของ skillBox
        // เพิ่มปุ่มสกิลใน skillBox
        // Button skill1 = new Button("🔥 Fireball");
        // skill1.setFont(Font.font(16));
        // skill1.setOnAction(e -> {
        //     combat.useSkill("Fireball");
        //     skillBox.setVisible(false);
        // });

        // Button skill2 = new Button("❄ Ice Blast");
        // skill2.setFont(Font.font(16));
        // skill2.setOnAction(e -> {
        //     combat.useSkill("Ice Blast");
        //     skillBox.setVisible(false);
        // });

        Button skill3 = new Button("Heavy Attack");
        skill3.setFont(Font.font(16));
        skill3.setOnAction(e -> {
            combat.useSkill();
            skillBox.setVisible(false);
        });
        

        skillBox.getChildren().addAll(skill3);

        // เพิ่ม VBox หลักและ ScrollPane เข้าไปใน HBox
        vbox.getChildren().addAll(attackButton, skillButton, fleeButton);
        vbox.setTranslateX(100);

        hbox = new HBox(10);
        hbox.getChildren().addAll(scrollPane, vbox, skillBox); // เพิ่ม skillBox เข้าไปใน HBox
        hbox.setTranslateY(FXGL.getAppHeight() - 250);                
        hbox.setTranslateX(50);
        hbox.setStyle("-fx-background-color: rgb(0, 0, 0); -fx-padding: 10; -fx-border-color: white; -fx-border-width: 2;");
        hbox.setPrefWidth(FXGL.getAppWidth() - 900); 
        hbox.setPrefHeight(20); 
    }

    // เมธอดสำหรับแสดง/ซ่อน skillBox
    private void toggleSkillBox() {
        skillBox.setVisible(!skillBox.isVisible());
    }

    public void updateEnemySelectionUI() {
        enemySelectionBox.getChildren().clear(); 
        
        List<Entity> enemies = FXGL.getGameWorld().getEntitiesByType(EnemyType.LowEnemy, EnemyType.HighEnermy, EnemyType.BossMonster)
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
