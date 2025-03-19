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
   public int hpCharacter;
   public int manaCharcter;
  
        public StatusComponent(String name,int HP,int mana){
          this.nameCharacter = name;
          this.hpCharacter = HP ;
          this.manaCharcter = mana;
        }

        public void setNameCharacter(String name){
          this.nameCharacter = name;
        }

        public void setHPCharacter(int HP){
              this.hpCharacter=HP;
        }
        
        public void setManaCharacter(int mana){
              this.manaCharcter = mana;  
      
        }

        public String getName(){
          return this.nameCharacter;
        }

        public int getHPCharacter(){
          return this.hpCharacter;
        }
        
        public int getManaCharacter(){
          return this.manaCharcter;
        }

 
    }
