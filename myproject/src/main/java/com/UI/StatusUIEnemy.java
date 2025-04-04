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
import java.util.stream.Collectors;

public class StatusUIEnemy {
    private VBox vbox; 
    private VBox mvbox; 
    private HBox AHbox; 
    private VBox enemyStatusBox;

    public StatusUIEnemy() {

      
       
        enemyStatusBox = new VBox(10);
        enemyStatusBox.setStyle("-fx-background-color: rgba(20, 20, 40, 0.92); -fx-padding: 10;");
        enemyStatusBox.setTranslateX(10); 
        enemyStatusBox.setTranslateY(10); 
        updateEnemyStatus();
      


        
       

      
    }

    public void updateEnemyStatus() {
       

    
        enemyStatusBox.getChildren().clear();
            
      
        
        

       
        List<Entity> enemies = FXGL.getGameWorld().getEntitiesByType(EnemyType.LowEnemy);
   
        for (Entity enemy : enemies) {

            
            if (enemy.hasComponent(StatusComponent.class)) {
                StatusComponent status = enemy.getComponent(StatusComponent.class);
                System.out.print(status.getName() + status.getHPCharacter());
            
                Label nameLabel = new Label("Enemy: " + status.getName());
                nameLabel.setFont(new Font(16));
                nameLabel.setTextFill(Color.WHITE);

                
                Label hpLabel = new Label("HP: " + status.getHPCharacter() );
                hpLabel.setFont(new Font(16));
                hpLabel.setTextFill(Color.RED);

    
                VBox enemyBox = new VBox(5);
                enemyBox.getChildren().addAll(nameLabel, hpLabel);

                enemyStatusBox.getChildren().add(enemyBox);
            }
        }
    }


    public VBox getEnemyStatusBox() {
        return enemyStatusBox;
    }

    public void remove() {
        if (enemyStatusBox != null) {
            FXGL.getGameScene().removeUINode(enemyStatusBox);
            enemyStatusBox = null;
        }
    }
}