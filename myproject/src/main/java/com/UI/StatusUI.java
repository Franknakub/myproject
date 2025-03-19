package com.UI;

import com.Component.StatusComponent;
import com.Type.PlayerType;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class StatusUI {
    private VBox vbox;
    private Label nameLabel;
    private Label hpLabel;
    private Label manaLabel;
    private StatusComponent status;
    private Label name;
    private Label hp;
    private Label mana;
    private HBox nameHbox;
    private HBox hpHbox;
    private HBox manaHbox;
    
   
  
    

    public StatusUI() {

        this.status = FXGL.getGameWorld().getSingleton(PlayerType.Hero).getComponent(StatusComponent.class);
        // สร้าง VBox สำหรับวางเลย์เอาต์
        vbox = new VBox(10);
        vbox.setStyle("-fx-background-color: rgba(40, 20, 20, 0.92); -fx-padding: 10;");
        
        vbox.setTranslateX(FXGL.getAppWidth() -200); // ตั้งค่าให้ VBox อยู่ทางขวา
        vbox.setTranslateY(10);

        // สร้าง Label สำหรับแสดงข้อมูลเริ่มต้น
        name = new Label("Player:");
        name.setFont(new Font(18));
        name.setTextFill(Color.WHITE);
        name.setTextAlignment(TextAlignment.RIGHT);
        nameLabel = new Label();
        nameLabel.textProperty().bind(FXGL.getWorldProperties().stringProperty("Name"));
        nameLabel.setFont(new Font(18));
        nameLabel.setTextFill(Color.WHITE);
        nameLabel.setTextAlignment(TextAlignment.RIGHT);

        nameHbox = new HBox(5);
        nameHbox.getChildren().addAll(name, nameLabel);

        hp = new Label("HP:");
        hp.setFont(new Font(18));
        hp.setTextFill(Color.WHITE);
        hp.setTextAlignment(TextAlignment.RIGHT);
        hpLabel = new Label();
        hpLabel.textProperty().bind(FXGL.getWorldProperties().intProperty("HP").asString());
        hpLabel.setFont(new Font(18));
        hpLabel.setTextFill(Color.WHITE); 
        hpLabel.setTextAlignment(TextAlignment.RIGHT);

        HBox hpHbox = new HBox(5);
        hpHbox.getChildren().addAll(hp, hpLabel);

        mana = new Label("Mana:");
        mana.setFont(new Font(18));
        mana.setTextFill(Color.WHITE);
        mana.setTextAlignment(TextAlignment.RIGHT);
        manaLabel = new Label();
        manaLabel.textProperty().bind(FXGL.getWorldProperties().intProperty("Mana").asString());
        manaLabel.setFont(new Font(18));
        manaLabel.setTextFill(Color.WHITE); 
        manaLabel.setTextAlignment(TextAlignment.RIGHT);


        HBox manaHbox = new HBox(5);
        manaHbox.getChildren().addAll(mana, manaLabel);

        // เพิ่ม Label เข้าไปใน VBox
        vbox.getChildren().addAll(nameHbox, hpHbox, manaHbox);
        
      
      
    }

    // เมธอดสำหรับอัปเดตสถานะจาก StatusComponent



    // เมธอดสำหรับดึง Scene สำหรับการเรนเดอร์
   
    public VBox getVBox() {
        return vbox;
    }
   
    public void remove() {

        if (vbox != null) {
            FXGL.getGameScene().removeUINode(vbox);
            vbox = null;
        }
    }
}
