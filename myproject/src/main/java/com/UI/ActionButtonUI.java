package com.UI;

import java.util.List;
import java.util.stream.Collectors;

import org.lwjgl.system.linux.Stat;

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

public class ActionButtonUI {
    private VBox vbox;
    private Button attackButton;
    private Button fleeButton;
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

        enemySelectionBox = new VBox(10);
        
        updateEnemySelectionUI(); 
        scrollPane = new ScrollPane(enemySelectionBox);
        scrollPane.setFitToWidth(true);
        scrollPane.setPrefHeight(200); 


        vbox.getChildren().addAll(attackButton, fleeButton);
        vbox.setTranslateX(100);

        hbox = new HBox(10);
        hbox.getChildren().addAll(scrollPane, vbox);
        hbox.setTranslateY(FXGL.getAppHeight() - 250);                
        hbox.setTranslateY(FXGL.getAppHeight() -200);
        hbox.setTranslateX(50);
        hbox.setStyle("-fx-background-color: rgb(0, 0, 0); -fx-padding: 10; -fx-border-color: white; -fx-border-width: 2;");
        hbox.setPrefWidth(FXGL.getAppWidth() - 900); 
        hbox.setPrefHeight(20); 
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
