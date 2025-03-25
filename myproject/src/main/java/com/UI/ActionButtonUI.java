package com.UI;

import java.util.List;

import org.lwjgl.system.linux.Stat;

import com.Combat.OrderCombat;
import com.Component.StatusComponent;
import com.Type.EnemyType;
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

        // สร้าง VBox สำหรับปุ่ม
        vbox = new VBox(20);
        //vbox.setTranslateX(50); // ตำแหน่ง X
        //vbox.setTranslateY(FXGL.getAppHeight() -200); // ตำแหน่ง Y (ล่างจอ)

        // ปุ่มโจมตี
        attackButton = new Button("Attack");
        attackButton.setFont(Font.font(18));
        attackButton.setOnAction(e -> combat.attack());
        attackButton.setTextFill(Color.BLACK);

        // ปุ่มหนี
        fleeButton = new Button("Flee");
        fleeButton.setFont(Font.font(18));
        fleeButton.setOnAction(e -> combat.flee());
        fleeButton.setTextFill(Color.BLACK);

        enemySelectionBox = new VBox(10);
        //enemySelectionBox.setTranslateX(50);
        //enemySelectionBox.setTranslateY(FXGL.getAppHeight() - 270); // กล่องสำหรับแสดงปุ่มเลือกศัตรู
        updateEnemySelectionUI(); // อัปเดต UI เลือกศัตรู
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
        hbox.setPrefWidth(FXGL.getAppWidth() - 900); // ตั้งค่าความกว้างของ hbox
        hbox.setPrefHeight(20); // ตั้งค่าความสูงของ hbox
    }

    private void updateEnemySelectionUI() {
        enemySelectionBox.getChildren().clear(); // ล้างปุ่มเก่าทั้งหมด
        
        List<Entity> enemies = FXGL.getGameWorld().getEntitiesByType(EnemyType.LowEnemy); // ดึงศัตรูทั้งหมด
    
        for (Entity enemy : enemies) {
            if (enemy.hasComponent(StatusComponent.class)) { // เช็กว่ามี StatusComponent ก่อน
                String enemyName = enemy.getComponent(StatusComponent.class).getName();
                
                Button enemyButton = new Button("🎯 Target: " + enemyName);
                enemyButton.setFont(Font.font(16));
                enemyButton.setOnAction(e -> combat.setTargetEnemy(enemy)); // เลือกเป้าหมาย
                
                enemySelectionBox.getChildren().add(enemyButton);
            }
        }
    }

    

    public HBox getHBox() {
        return hbox;
    }

    // ✅ เมธอดลบ UI ออกจาก GameScene
    public void remove() {
        if (hbox != null) {
            FXGL.getGameScene().removeUINode(hbox);
            hbox = null;
        }
    }
}
