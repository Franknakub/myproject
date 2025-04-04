package com.UI;

import com.Component.StatusComponent;
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

public class StatusUI {
    private VBox vbox; 
    private VBox mvbox; 
    private HBox AHbox; 
    private VBox enemyStatusBox;

    public StatusUI() {

        // Enemy's Status Box
        enemyStatusBox = new VBox(10);
        enemyStatusBox.setStyle("-fx-background-color: rgba(40, 20, 20, 0.92); -fx-padding: 10;");
        enemyStatusBox.setTranslateX(FXGL.getAppWidth() - 800);
        enemyStatusBox.setTranslateY(10);

        // Magia's Status Box
        mvbox = new VBox(10);
        mvbox.setStyle("-fx-background-color: rgba(40, 20, 20, 0.92); -fx-padding: 10;");
        mvbox.setTranslateX(FXGL.getAppWidth() - 500);
        mvbox.setTranslateY(10);

        Label mname = new Label("Player:");
        mname.setFont(new Font(18));
        mname.setTextFill(Color.WHITE);
        Label mnameLabel = new Label();
        mnameLabel.textProperty().bind(FXGL.getWorldProperties().stringProperty("Namem"));
        mnameLabel.setFont(new Font(18));
        mnameLabel.setTextFill(Color.WHITE);

        HBox mnameHbox = new HBox(5);
        mnameHbox.getChildren().addAll(mname, mnameLabel);

        Label mhp = new Label("HP:");
        mhp.setFont(new Font(18));
        mhp.setTextFill(Color.WHITE);
        Label mhpLabel = new Label();
        mhpLabel.textProperty().bind(FXGL.getWorldProperties().intProperty("HPm").asString());
        mhpLabel.setFont(new Font(18));
        mhpLabel.setTextFill(Color.WHITE);

        HBox mhpHbox = new HBox(5);
        mhpHbox.getChildren().addAll(mhp, mhpLabel);

        Label mmana = new Label("Mana:");
        mmana.setFont(new Font(18));
        mmana.setTextFill(Color.WHITE);
        Label mmanaLabel = new Label();
        mmanaLabel.textProperty().bind(FXGL.getWorldProperties().intProperty("Manam").asString());
        mmanaLabel.setFont(new Font(18));
        mmanaLabel.setTextFill(Color.WHITE);

        HBox mmanaHbox = new HBox(5);
        mmanaHbox.getChildren().addAll(mmana, mmanaLabel);

        mvbox.getChildren().addAll(mnameHbox, mhpHbox, mmanaHbox);

        vbox = new VBox(10);
        vbox.setStyle("-fx-background-color: rgba(40, 20, 20, 0.92); -fx-padding: 10;");
        vbox.setTranslateX(FXGL.getAppWidth() - 200);
        vbox.setTranslateY(10);

        Label name = new Label("Player:");
        name.setFont(new Font(18));
        name.setTextFill(Color.WHITE);
        Label nameLabel = new Label();
        nameLabel.textProperty().bind(FXGL.getWorldProperties().stringProperty("Name"));
        nameLabel.setFont(new Font(18));
        nameLabel.setTextFill(Color.WHITE);

        HBox nameHbox = new HBox(5);
        nameHbox.getChildren().addAll(name, nameLabel);

        Label hp = new Label("HP:");
        hp.setFont(new Font(18));
        hp.setTextFill(Color.WHITE);
        Label hpLabel = new Label();
        hpLabel.textProperty().bind(FXGL.getWorldProperties().intProperty("HP").asString());
        hpLabel.setFont(new Font(18));
        hpLabel.setTextFill(Color.WHITE);

        HBox hpHbox = new HBox(5);
        hpHbox.getChildren().addAll(hp, hpLabel);

        Label mana = new Label("Mana:");
        mana.setFont(new Font(18));
        mana.setTextFill(Color.WHITE);
        Label manaLabel = new Label();
        manaLabel.textProperty().bind(FXGL.getWorldProperties().intProperty("Mana").asString());
        manaLabel.setFont(new Font(18));
        manaLabel.setTextFill(Color.WHITE);

        HBox manaHbox = new HBox(5);
        manaHbox.getChildren().addAll(mana, manaLabel);

        vbox.getChildren().addAll(nameHbox, hpHbox, manaHbox);

        // Combine all status boxes
        AHbox = new HBox(10);
        AHbox.getChildren().addAll(vbox, mvbox, enemyStatusBox);
    }

    public HBox getVBox() {
        return AHbox;
    }

    public void remove() {
        if (AHbox != null) {
            FXGL.getGameScene().removeUINode(AHbox);
            AHbox = null;
        }
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
                Label hpLabel = new Label("HP: " + status.getHPCharacter());
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
}