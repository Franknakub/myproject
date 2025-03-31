package com.Component;
// Java Map class, used for storing game variables
import java.util.Map;

// FXGL classes
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;

// JavaFX classes
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;


public class StatusComponent extends Component {

    String nameCharacter;
   public int hp;
   public int mana;
   public int maxHP;
   public int maxMana;
  
        public StatusComponent(String name,int HP,int mana,int maxHP,int maxMana) {
          this.nameCharacter = name;
          this.hp = HP;
          this.mana = mana;
          this.maxHP = maxHP;
          this.maxMana = maxMana;
        }

        public void setNameCharacter(String name){
          this.nameCharacter = name;
        }

        public int getMaxManaCharacter(){

          return maxMana;
        } 

        public int getMaxHPCharacter(){

          return maxHP;
        }

        public void setHPCharacter(int HP){
              this.hp = HP;
        }
        
        public void setManaCharacter(int mana){
              this.mana = mana;  
        }

        public String getName(){
          return this.nameCharacter;
        }

        public int getHPCharacter(){
          return this.hp;
        }
        
        public int getManaCharacter(){
          return this.mana;
        }

 
    }
