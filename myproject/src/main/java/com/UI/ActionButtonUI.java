package com.UI;



import com.Combat.UseCombatComponent;
import com.almasb.fxgl.dsl.FXGL;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ActionButtonUI {
    private HBox hbox;
    private VBox vbox;
    private Button attackButton;
    private Button fleeButton;
    private UseCombatComponent combat;

    public ActionButtonUI() {

        combat = new UseCombatComponent();
        // สร้าง HBox สำหรับจัดเรียงปุ่มในแนวนอน
        vbox = new VBox(20);
        vbox.setTranslateX(50); // ตำแหน่ง X
        vbox.setTranslateY(FXGL.getAppHeight() - 150); // ตำแหน่ง Y (ล่างจอ)

        // สร้างปุ่ม Attack
        attackButton = new Button("⚔ Attack");
        attackButton.setFont(Font.font(18));
        attackButton.setOnAction(e -> combat.Attack());
        attackButton.setTextFill(Color.BLACK);

        // สร้างปุ่ม Flee
        fleeButton = new Button("🏃‍♂ Flee");
        fleeButton.setFont(Font.font(18));
        fleeButton.setOnAction(e -> combat.Flee());
        fleeButton.setTextFill(Color.BLACK);

        // เพิ่มปุ่มเข้า HBox
        vbox.getChildren().addAll(attackButton, fleeButton);
    }

    public VBox getVBox() {
        return vbox;
    }

    public void remove() {
        FXGL.getGameScene().removeUINode(hbox);
    }
}

