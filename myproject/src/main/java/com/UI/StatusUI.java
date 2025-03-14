package com.UI;

import com.Component.StatusComponent;
import com.Type.PlayerType;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class StatusUI {
    private VBox vbox;
    private Label nameLabel;
    private Label hpLabel;
    private Label manaLabel;
    private StatusComponent status;
    
  
    

    public StatusUI() {

        this.status = FXGL.getGameWorld().getSingleton(PlayerType.Hero).getComponent(StatusComponent.class);
        // สร้าง VBox สำหรับวางเลย์เอาต์
        vbox = new VBox(10);
        vbox.setStyle("-fx-background-color: rgba(0, 0, 0, 0.92); -fx-padding: 10;");
        
        vbox.setTranslateX(FXGL.getAppWidth() - 200); // ตั้งค่าให้ VBox อยู่ทางขวา
        vbox.setTranslateY(10);

        // สร้าง Label สำหรับแสดงข้อมูลเริ่มต้น
        nameLabel = new Label("Player: " + status.getName());
        nameLabel.setFont(new Font(18));
        nameLabel.setTextFill(Color.WHITE); 
        nameLabel.setTextAlignment(TextAlignment.RIGHT);

        hpLabel = new Label("HP: " + status.getHPCharacter());
        hpLabel.setFont(new Font(18));
        hpLabel.setTextFill(Color.WHITE); 
        hpLabel.setTextAlignment(TextAlignment.RIGHT);

        manaLabel = new Label("Mana: " + status.getManaCharacter());
        manaLabel.setFont(new Font(18));
        manaLabel.setTextFill(Color.WHITE); 
        manaLabel.setTextAlignment(TextAlignment.RIGHT);

        // เพิ่ม Label เข้าไปใน VBox
        vbox.getChildren().addAll(nameLabel, hpLabel, manaLabel);
        
      
      
    }

    // เมธอดสำหรับอัปเดตสถานะจาก StatusComponent
    public void updateStatus() {
        // ดึง Component ของ Player จาก GameWorld
        this.status = FXGL.getGameWorld().getSingleton(PlayerType.Hero).getComponent(StatusComponent.class);    

        // อัปเดตข้อความใน Label
        nameLabel.setText("Player: " + status.getName());
        hpLabel.setText("HP: " + status.getHPCharacter());
        manaLabel.setText("Mana: " + status.getManaCharacter());
    }

    // เมธอดสำหรับดึง Scene สำหรับการเรนเดอร์
   
    public VBox getVBox() {
        return vbox;
    }
   
    public void remove() {

        if (vbox != null) {
            FXGL.getGameScene().removeUINode(vbox);
            
        }
    }
}
