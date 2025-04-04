package com.UI;

import com.Component.StatusComponent;
import com.GameEvent.CombatScene;
import com.Type.Enemy.EnemyType;
import com.Type.Player.PlayerType;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.List;

public class StatusUIEnemy {
    private VBox vbox; 
    private VBox mvbox; 
    private HBox AHbox; 
    private VBox enemyStatusBox;

    public StatusUIEnemy() {

          //    // Status Magia's M Initializeagia's Status Box
       
        enemyStatusBox = new VBox(10);
        enemyStatusBox.setStyle("-fx-background-color: rgba(20, 20, 40, 0.92); -fx-padding: 10;");
        enemyStatusBox.setTranslateX(10); // Position X (top-left)
        enemyStatusBox.setTranslateY(10); // Position Y (top-left)
        updateEnemyStatus();
        // Combine both status boxes
        AHbox = new HBox(10);
        AHbox.getChildren().addAll(enemyStatusBox);

        // Enemy Status Box
       

      
    }

    public void updateEnemyStatus() {
        // Clear old data in VBox
        enemyStatusBox.getChildren().clear();

        // Retrieve all enemies in the game
        List<Entity> enemies = FXGL.getGameWorld().getEntitiesByType(EnemyType.LowEnemy, EnemyType.HighEnemy, EnemyType.BossMonster);

        // Loop through each enemy
        for (Entity enemy : enemies) {
            if (enemy.hasComponent(StatusComponent.class)) {
                StatusComponent status = enemy.getComponent(StatusComponent.class);

                // Create Label for enemy name
                Label nameLabel = new Label("Enemy: " + status.getName());
                nameLabel.setFont(new Font(16));
                nameLabel.setTextFill(Color.WHITE);

                // Create Label for enemy HP
                Label hpLabel = new Label("HP: " + status.getHPCharacter() );
                hpLabel.setFont(new Font(16));
                hpLabel.setTextFill(Color.RED);

                // Create VBox for each enemy
                VBox enemyBox = new VBox(5);
                enemyBox.getChildren().addAll(nameLabel, hpLabel);

                // Add enemy VBox to enemyStatusBox
                enemyStatusBox.getChildren().add(enemyBox);
            }
        }
    }

    public HBox getVBox() {
        return AHbox;
    }

    public VBox getEnemyStatusBox() {
        return enemyStatusBox;
    }

    public void remove() {
        if (AHbox != null) {
            FXGL.getGameScene().removeUINode(AHbox);
            AHbox = null;
        }
    }
}