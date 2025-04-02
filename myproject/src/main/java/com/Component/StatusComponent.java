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

   private String nameCharacter;
   private int hp;
   private int mana;
   private int maxHP;
   private int maxMana;
   private String nameHP;
   private String nameMana;
  
        public StatusComponent(String name,String nameHP,String nameMana,int HP,int mana,int maxHP,int maxMana) {
          this.nameCharacter = name;
          this.hp = HP;
          this.mana = mana;
          this.maxHP = maxHP;
          this.maxMana = maxMana;
          this.nameHP = nameHP;
          this.nameMana = nameMana;
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

        public String getNameHPCharacter(){
          return this.nameHP;
        }

        public String getNameManaCharacter(){
          return this.nameMana;
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
